package com.mariadesk.api.responses;

import org.junit.Test;


public class InboundTest extends ResponseTest {
  @Test
  public void testResponse() throws Exception {
    Inbound inbound = new Inbound();
    String expectedXML = "<Response><Say>Dear customer thanks for calling Maria Flower Shop</Say><Gather "
                       + "numDigits=\"1\" action=\"/voice/ivr\"><Say>For questions press 1, to talk with an "
                       + "assistant press 2</Say></Gather></Response>";

    assertResponse(inbound, expectedXML);
  }
}
