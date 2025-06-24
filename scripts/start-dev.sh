#!/bin/bash
set -e

echo "⏳ Enabling Minikube ingress if not enabled..."
minikube addons enable ingress || true

echo "🚀 Starting Postgres port-forward in background..."
pkill -f "kubectl port-forward service/postgres-service 5433:5432" || true
nohup kubectl port-forward service/postgres-service 5433:5432 > portforward-db.log 2>&1 &

sleep 3

APP_URL="http://spiritual-health-tracker-app.local"
echo "🌐 Opening app at: $APP_URL"
xdg-open "$APP_URL" 2>/dev/null || open "$APP_URL" || echo "🔗 Visit manually: $APP_URL"