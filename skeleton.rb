#!/usr/bin/env ruby

require 'yaml'
require 'optparse'
require 'fileutils'

class YMLConfig
  attr_reader :filters

  def initialize(path)
    @filters = YAML.safe_load(File.read(path))
  end
end

class Skeleton
  attr_reader :config
  attr_reader :output_dir
  attr_reader :ignored

  def initialize(config, output_dir)
    @config = config
    @output_dir = output_dir
    @ignored = %w[skeleton.rb skeleton.yml]
  end

  def build
    clean_output_dir

    tree.each do |file|
      next if ignore?(file)

      output_path = save(file, output(file))
      show_filter(file, output_path) if filters?(file)
      show_saved(output_path)
    end

    puts "Build available in #{output_dir}"
  end

  private
  def show_saved(output_path)
    puts "Saved #{output_path}"
  end

  def show_filter(original_path, output_path)
    separator = '-' * 30
    puts "Filtered #{original_path}"
    puts separator
    puts `diff #{original_path} #{output_path}`
    puts separator
  end

  def tree
    `git ls-tree -r --name-only master`.split("\n")
  end

  def output(path)
    return filtered(path) if filters?(path)
    File.read(path)
  end

  def filtered(path)
    lines = File.readlines(path)
    filters = config.filters[path]
    filtered_lines = (1..lines.count).select do |line|
      filters.none? { |from, to| (from..to).cover? line }
    end

    filtered_lines.map do |line|
      lines[line - 1]
    end.join
  end

  def filters?(path)
    config.filters.include? path
  end

  def save(original_path, output)
    output_path = File.join(output_dir, original_path)
    output_dir = File.dirname(output_path)
    `mkdir -p #{output_dir}`
    File.open(output_path, 'w') { |f| f.write(output) }

    output_path
  end

  def ignore?(file)
    ignored.include? file
  end

  def clean_output_dir
    Dir["#{output_dir}/*"].each do |node|
      FileUtils.rmtree(node)
      puts "Removed #{node}"
    end
  end
end

def parse_options
  options = {}

  OptionParser.new do |opts|
    opts.banner = 'Usage: skeleton.rb [options]'
    opts.on('--output OUTPUT_DIR') { |o| options[:output] = o }
  end.parse!

  options
end

def main
  options = parse_options
  config = YMLConfig.new('skeleton.yml')
  skeleton = Skeleton.new(config, options.fetch(:output, 'skeleton'))
  skeleton.build
end

main
