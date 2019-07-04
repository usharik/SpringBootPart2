FROM openjdk:8-jdk-alpine

COPY ./lib/bots /bots
COPY ./target/geek-market-chatbot-0.0.1-SNAPSHOT.jar /bin

ENV BOT_NAME=chatbot
ENV BOT_CONFIGURATION_PATH=/

ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/bin/geek-market-chatbot-0.0.1-SNAPSHOT.jar"]

EXPOSE 5000