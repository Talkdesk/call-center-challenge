package com.mariadesk.api;

import com.mariadesk.models.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.twilio.twiml.VoiceResponse;

import com.mariadesk.api.responses.Inbound;
import com.mariadesk.api.responses.IVR;
import com.mariadesk.api.responses.Questions;
import com.mariadesk.repositories.CallsRepository;

@RestController
public class VoiceController {

  private final CallsRepository callsRepository;
  private final String agentNumber;

  @Autowired
  public VoiceController(CallsRepository callsRepository,
                         @Value("${agent.number}") String agentNumber) {
    this.callsRepository = callsRepository;
    this.agentNumber = agentNumber;
  }

  @RequestMapping(path="/voice/inbound", produces="application/xml")
  public VoiceResponse inbound(@RequestParam("From") String from,
                               @RequestParam("To") String to,
                               @RequestParam("Caller") String caller,
                               @RequestParam("CallSid") String callId,
                               @RequestParam("AccountSid") String accountId) {
    Call call = new Call();
    call.setAccountId(accountId);
    call.setExternalCallId(callId);
    call.setFrom(from);
    call.setTo(to);

    this.callsRepository.save(call);

    return new Inbound().response();
  }

  @RequestMapping(path="/voice/ivr", produces="application/xml")
  public VoiceResponse ivr(@RequestParam(value="Digits", defaultValue="") String digits) {
    return new IVR(digits, agentNumber).response();
  }

  @RequestMapping(path="/voice/questions", produces="application/xml")
  public VoiceResponse questions(@RequestParam(value="Digits", defaultValue="") String digits) {
    return new Questions(digits).response();
  }
}
