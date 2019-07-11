#!/usr/bin/env sh

heroku apps:create geek-market-ui
heroku addons:create heroku-postgresql:hobby-dev --app geek-market-ui
heroku config:set DB_DRIVER=org.postgresql.Driver HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect --app geek-market-ui
heroku config:set EUREKA_URI=https://geek-market-eureka.herokuapp.com/eureka --app geek-market-ui
heroku config:set HOST_NAME=https://geek-market-ui.herokuapp.com --app geek-market-ui

heroku apps:create geek-market-chatbot
heroku config:set BOT_NAME=chatbot --app geek-market-chatbot
heroku config:set EUREKA_URI=https://geek-market-eureka.herokuapp.com/eureka --app geek-market-chatbot
heroku config:set HOST_NAME=https://geek-market-chatbot.herokuapp.com --app geek-market-chatbot

heroku apps:create geek-market-eureka