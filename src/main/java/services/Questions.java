package services;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.Gather;
import com.twilio.twiml.Say;


public class Questions extends Response {
  private String digits;

  public Questions(String digits) {
    this.digits = digits;
  }

  public VoiceResponse response() {
    if (digits.isEmpty() || !digitHasAnswer()) {
      return questions();
    } else {
      return answer();
    }
  }

  private int digitNumber() {
    return Integer.parseInt(digits);
  }

  private boolean digitHasAnswer() {
    return digitNumber() > 0 && digitNumber() <= Strings.ANSWERS.length;
  }

  private VoiceResponse questions() {
    return builder.gather(
      new Gather.Builder()
      .numDigits(1)
      .say(new Say.Builder(Strings.QUESTIONS).build())
      .action("/voice/questions")
      .build()
    )
    .build();
  }

  private VoiceResponse answer() {
    String answer = Strings.ANSWERS[digitNumber() - 1];
    return builder.say(new Say.Builder(answer).build()).build();
  }
}
