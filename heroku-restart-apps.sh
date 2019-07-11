#!/usr/bin/env sh

heroku dyno:restart --app geek-market-chatbot
heroku dyno:restart --app geek-market-ui
heroku dyno:restart --app geek-market-eureka