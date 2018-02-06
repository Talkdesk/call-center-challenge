package com.mariadesk.api.responses;

import com.twilio.twiml.TwiMLException;

import static org.junit.Assert.assertEquals;

public class ResponseTest {
    protected void assertResponse(Response response, String expectedXML) {

        try {
            String xml = response.response().toXml();
            assertEquals(expectedXML, xml);
        }
        catch (TwiMLException e) {
            e.printStackTrace();
        }
    }
}
