#!/bin/bash

# Exit if any command fails
set -e

echo "🚀 Starting port-forward for Postgres in background..."
# Stop existing port-forward if any
pkill -f "kubectl port-forward service/postgres-service 5433:5432" || true
nohup kubectl port-forward service/postgres-service 5433:5432 > portforward-db.log 2>&1 &

sleep 3

echo "🌐 Opening Spring Boot app via Minikube service..."
APP_URL=$(minikube service spiritual-tracker-deployment --url)

echo "🔗 App is accessible at: $APP_URL"
xdg-open "$APP_URL" 2>/dev/null || open "$APP_URL" || echo "Open the URL manually."

echo "✅ Port-forwarding and app tunnel set up. Ctrl+C to stop them."