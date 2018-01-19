# Deploying to Heroku
To deploy your project to the cloud, you'll be using Heroku. In order to do so:

* Create a free account in Heroku - https://signup.heroku.com/
* Install the Heroku CLI (Command Line Interface) - https://devcenter.heroku.com/articles/heroku-cli
* Verify the installation running

```bash
heroku login
```

* In your terminal, change into your project base directory
Create an app in Heroku running 

```bash
heroku create
```

A git remote named `heroku` will be added to your project, and a random name will be generated for your app.

* Deploy your code running 


```bash
git push heroku master
```

That's it. You can optionally open the website using 

```bash
heroku open
```

or view the logs with 

```bash
heroku logs --tail
```

