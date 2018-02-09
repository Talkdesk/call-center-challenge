package com.mariadesk.api.responses;

import com.twilio.twiml.TwiMLException;

import static org.junit.Assert.assertEquals;

public class ResponseTest {
    protected void assertResponse(Response response, String expectedXML) throws TwiMLException {
        String xml = response.response().toXml();
        assertEquals(expectedXML, xml);
    }
}
