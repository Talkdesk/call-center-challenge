package services;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.Redirect;

public abstract class Response {
  public VoiceResponse.Builder builder;

  public Response() {
    builder = new VoiceResponse.Builder();
  }

  public VoiceResponse redirectTo(String url) {
    return builder.redirect(new Redirect.Builder().url(url).build()).build();
  }

  abstract VoiceResponse response();
}
