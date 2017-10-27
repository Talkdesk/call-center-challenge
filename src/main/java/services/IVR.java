package services;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.Dial;
import com.twilio.twiml.Number;

import services.Config;

public class IVR extends Response {
  private String digits;

  public IVR(String digits) {
    this.digits = digits;
  }

  public VoiceResponse response() {
    VoiceResponse response;

    switch(digits) {
      case "1":
        response = redirectTo("/voice/questions");
        break;
      case "2":
        response = dialAgent();
        break;
      default:
        response = redirectTo("/voice/inbound");
    }

    return response;
  }

  private VoiceResponse dialAgent() {
    Number number = new Number.Builder(Config.AGENT_NUMBER).build();
    return builder.dial(new Dial.Builder().number(number).build()).build();
  }
}
