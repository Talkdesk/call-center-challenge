# Call Center Challenge
Maria is a real estate entrepreneur and wants to improve Customer Support. She decided to have a Call Center that automatically answers common questions and if the customer really needs help, it transfers the call to her number.

# Setup
- Install [Java](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- Install [Gradle](https://gradle.org/install/)
- Install [Ngrok](https://ngrok.com/)
- Create an Account in [Twilio](https://www.twilio.com/)
- Purchase an United States Number in Twillo

# Usage
Launch webserver with the desired Agent Number:

    AGENT_NUMBER=+351900000000 gradle bootRun

Create a tunnel:

    ngrok http 8080

Setup webhook in Twillio for phone number:

      Example: https://44a1dcb5.ngrok.io/voice/inbound

Make a call in Google Hangouts for the US Number.

# Sugested Documentation
## Twilio
- [Java Quick Start: Say a message](https://www.twilio.com/docs/quickstart/java/twiml/say-response#before-you-start)
- [Java Quick Start: Connect call to second person](https://www.twilio.com/docs/quickstart/java/twiml/connect-call-to-second-person)
