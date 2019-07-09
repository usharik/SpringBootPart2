#!/usr/bin/env sh
# Example of direct Heroku REST API call (application update)
curl -n -X PATCH https://api.heroku.com/apps/geek-market-eureka/formation \
  -d '{
  "updates": [
    {
      "type": "web",
      "docker_image": "geek-market-eureka"
    }
  ]
}' \
  -H "Content-Type: application/json" \
  -H "Accept: application/vnd.heroku+json; version=3.docker-releases"