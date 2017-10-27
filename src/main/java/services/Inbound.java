package services;

import com.twilio.twiml.Say;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.Gather;

public class Inbound extends Response {
  public VoiceResponse response() {
    return builder
      .say(greeting())
      .gather(ivr())
      .build();
  }

  private Say greeting() {
    return new Say.Builder(Strings.GREETING).build();
  }

  private Gather ivr() {
    return new Gather.Builder()
      .numDigits(1)
      .say(new Say.Builder(Strings.IVR).build())
      .action("/voice/ivr")
      .build();
  }
}
