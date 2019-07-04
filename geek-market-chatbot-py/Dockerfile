FROM python:3.7-alpine

RUN apk add --no-cache build-base
RUN apk add --no-cache libexecinfo-dev
RUN pip install -U pip

RUN pip install chatterbot
RUN pip install chatterbot-corpus
RUN pip install Flask

ADD chatbot.py /

EXPOSE 5000

CMD python chatbot.py