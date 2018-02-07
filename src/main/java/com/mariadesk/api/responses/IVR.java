package com.mariadesk.api.responses;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.Dial;
import com.twilio.twiml.Number;

public class IVR extends Response {
  private final String digits;
  private final String agentNumber;

  public IVR(String digits, String agentNumber) {
    this.digits = digits;
    this.agentNumber = agentNumber;
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
    Number number = new Number.Builder(agentNumber).build();
    return builder.dial(new Dial.Builder().number(number).build()).build();
  }
}
