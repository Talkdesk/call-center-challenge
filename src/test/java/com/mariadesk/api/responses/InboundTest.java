package com.mariadesk.api.responses;

import com.twilio.twiml.TwiMLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.mariadesk.api.responses.Inbound;


public class InboundTest {
  @Test
  public void testResponse() {
    Inbound inbound = new Inbound();

    try {
      String xml = inbound.response().toXml();
      System.out.println(xml);
      // assertEquals("Response is XML", "ddd", xml);
    }
    catch (TwiMLException e) {
      e.printStackTrace();
    }
  }
}
