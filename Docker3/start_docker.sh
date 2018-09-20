eval $(minikube docker-env)
docker build -t spring3:v1 .
kubectl create -f ./deployment.yml
kubectl create -f ./service.yml