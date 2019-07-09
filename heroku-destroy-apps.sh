#!/usr/bin/env sh

heroku apps:destroy geek-market-ui --confirm geek-market-ui
heroku apps:destroy geek-market-chatbot --confirm geek-market-chatbot
heroku apps:destroy geek-market-eureka --confirm geek-market-eureka