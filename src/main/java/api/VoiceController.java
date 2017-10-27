package api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.twilio.twiml.VoiceResponse;

import services.Inbound;
import services.IVR;
import services.Questions;

@RestController
public class VoiceController {

  @RequestMapping(path="/voice/inbound", produces="application/xml")
  public VoiceResponse inbound() {
    return new Inbound().response();
  }

  @RequestMapping(path="/voice/ivr", produces="application/xml")
  public VoiceResponse ivr(@RequestParam(value="Digits", defaultValue="") String digits) {
    return new IVR(digits).response();
  }

  @RequestMapping(path="/voice/questions", produces="application/xml")
  public VoiceResponse questions(@RequestParam(value="Digits", defaultValue="") String digits) {
    return new Questions(digits).response();
  }
}
