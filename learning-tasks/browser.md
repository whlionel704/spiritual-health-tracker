To open k8 app in browser:
    minikube service spiritual-tracker-deployment url

Doing: curl -H "Host: spiritual.health.tracker.app.ingress.local" http://127.0.0.1/health 
    will require you to do: minikube tunnel
    why? 

How to push changes to github actions CI/CD pipeline:
- git add .
- git commit -m commit-message
- git push
- cd actions runner && ./run.sh

How to setup kubernetes:
- open docker
- minikube start --driver=docker
How to start the spiritual tracker app:
- minikube service spiritual-tracker-deployment  url
How to connect the k8 spiritual tracker app to the k8 db:
- kubectl port-forward service/postgres-service 5433:5432

Ingress Controller (still figuring out):
minikube tunnel
curl --resolve spiritual.health.tracker.app.ingress.local:80:192.168.49.2 -i http://spiritual.health.tracker.app.ingress.local

Kubernetes dashboard:
- minikube dashboard

