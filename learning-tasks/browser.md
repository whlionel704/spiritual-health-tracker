To open k8 app in browser:
    minikube service spiritual-tracker-deployment url

Doing: curl -H "Host: spiritual.health.tracker.app.ingress.local" http://127.0.0.1/health 
    will require you to do: minikube tunnel
    why? 

How to push changes to github actions CI/CD pipeline:
- git add .
- git commit -m commit-message
- git push
- cd actions-runner && ./run.sh

How to setup kubernetes:
- open docker
- minikube start --driver=docker
- cd scripts && ./start-dev.sh -> this will do kubectl port-forward service/postgres-service 5433:5432 and minikube service spiritual-tracker-deployment --url BOTH at the same time
Ingress Controller (still figuring out):
minikube tunnel
curl --resolve spiritual.health.tracker.app.ingress.local:80:192.168.49.2 -i http://spiritual.health.tracker.app.ingress.local

Kubernetes dashboard:
- minikube dashboard

