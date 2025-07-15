#!/bin/bash
set -e

echo "⏳ Enabling Minikube ingress if not enabled..."
minikube addons enable ingress || true

echo "🚀 Starting Postgres port-forward in background..."
pkill -f "kubectl port-forward service/postgres-service 5433:5432" || true
nohup kubectl port-forward service/postgres-service 5433:5432 > portforward-db.log 2>&1 &

sleep 3

echo "🌐 Getting URL for spiritual-tracker-deployment..."
APP_URL=$(minikube service spiritual-tracker-deployment --url)

echo "✅ App URL: $APP_URL"

# Optionally open in browser
if grep -qEi "(Microsoft|WSL)" /proc/version &> /dev/null; then
    powershell.exe start "$APP_URL" || explorer.exe "$APP_URL" || echo "🔗 Visit manually: $APP_URL"
else
    xdg-open "$APP_URL" 2>/dev/null || (command -v open >/dev/null && open "$APP_URL") || echo "🔗 Visit manually: $APP_URL"
fi

# Keep script running if you want the port-forward to stay alive
wait
