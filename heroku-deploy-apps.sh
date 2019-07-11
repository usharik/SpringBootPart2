#!/usr/bin/env sh

heroku container:release web --app=geek-market-eureka
heroku container:release web --app=geek-market-chatbot
heroku container:release web --app=geek-market-ui