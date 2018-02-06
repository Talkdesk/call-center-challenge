package com.mariadesk.api;

import com.mariadesk.api.responses.Inbound;
import com.twilio.twiml.VoiceResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoiceController {

  @RequestMapping(path="/voice/inbound", produces="application/xml")
  public VoiceResponse inbound(@RequestParam("From") String from,
                               @RequestParam("To") String to,
                               @RequestParam("Caller") String caller,
                               @RequestParam("CallSid") String callId,
                               @RequestParam("AccountSid") String accountId) {
    return new Inbound().response();
  }

  @RequestMapping(path="/voice/ivr", produces="application/xml")
  public VoiceResponse ivr(@RequestParam(value="Digits", defaultValue="") String digits) {
    throw new UnsupportedOperationException("To be implemented");
  }

  @RequestMapping(path="/voice/questions", produces="application/xml")
  public VoiceResponse questions(@RequestParam(value="Digits", defaultValue="") String digits) {
    throw new UnsupportedOperationException("To be implemented");
  }
}
