eval $(minikube docker-env)
docker build -t spring2:v1 .
kubectl create -f ./deployment.yml
kubectl create -f ./service.yml