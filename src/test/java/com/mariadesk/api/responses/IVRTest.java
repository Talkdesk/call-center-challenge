package com.mariadesk.api.responses;

import org.junit.Ignore;
import org.junit.Test;

public class IVRTest extends ResponseTest {

    @Test
    public void testRedirectToQuestionsResponse() {
        String expectedXML = "<Response><Redirect>/voice/questions</Redirect></Response>";
        assertIVRResponse("1", expectedXML);
    }

    @Test
    public void testDialAgentResponse() {
        String expectedXML = "<Response><Dial><Number/></Dial></Response>";
        assertIVRResponse("2", expectedXML);

    }

    @Test
    public void testRedirectToInboundResponse() {
        String expectedXML = "<Response><Redirect>/voice/inbound</Redirect></Response>";

        String emptyDigits = "";
        assertIVRResponse(emptyDigits, expectedXML);

        String outOfRangeDigit = "3";
        assertIVRResponse(outOfRangeDigit, expectedXML);
    }

    public void assertIVRResponse(String digits, String expectedXML) {
        IVR ivr = new IVR(digits);
        assertResponse(ivr, expectedXML);
    }

}