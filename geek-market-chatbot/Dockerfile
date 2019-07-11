FROM openjdk:8-jdk-alpine

ARG JAR_FILE

COPY ./lib/bots /bots
COPY ./target/${JAR_FILE} /bin/app.jar
COPY ./entrypoint.sh /bin/entrypoint.sh

ENV BOT_NAME=chatbot
ENV BOT_CONFIGURATION_PATH=/

CMD ["/bin/entrypoint.sh"]

EXPOSE 5000