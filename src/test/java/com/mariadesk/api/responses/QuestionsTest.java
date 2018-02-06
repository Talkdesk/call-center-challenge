package com.mariadesk.api.responses;

import org.junit.Test;

public class QuestionsTest extends ResponseTest {

    @Test
    public void testQuestionsResponse() {
        String expectedXML = "<Response><Gather numDigits=\"1\" action=\"/voice/questions\"><Say>For payments press 1,"
                           + " for orders press 2,for email support press 3</Say></Gather></Response>";

        String emptyDigits = "";
        assertQuestionsResponse(emptyDigits, expectedXML);

        String outOfRangeDigit = "4";
        assertQuestionsResponse(outOfRangeDigit, expectedXML);
    }

    @Test
    public void testPaymentAnswerResponse() {
        String expectedXML = "<Response><Say>Use IBAN NL22ABNA0566397423 and send payment proofs to payments at "
                           + "mariaflowershop dot pt</Say></Response>";
        assertQuestionsResponse("1", expectedXML);
    }

    @Test
    public void testOrdersAnswerResponse() {
        String expectedXML = "<Response><Say>Place your orders in our online shop at mariaflowershop dot pt</Say>"
                           + "</Response>";
        assertQuestionsResponse("2", expectedXML);
    }

    @Test
    public void testSupportAnswerResponse() {
        String expectedXML = "<Response><Say>When you need support, send an email to support at mariaflowershop dot "
                           + "pt</Say></Response>";
        assertQuestionsResponse("3", expectedXML);
    }

    protected void assertQuestionsResponse(String digits, String expectedXML) {
        Questions questions = new Questions(digits);
        assertResponse(questions, expectedXML);
    }
}
