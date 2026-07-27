#!/bin/sh
export BACKEND_URL="${BACKEND_URL:-http://backend:8080}"
envsubst '$BACKEND_URL' < /etc/nginx/templates/nginx.conf.template > /etc/nginx/conf.d/default.conf
nginx -g 'daemon off;'
