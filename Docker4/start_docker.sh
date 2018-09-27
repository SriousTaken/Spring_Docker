eval $(minikube docker-env)
docker build -t spring4:v1 .
kubectl create -f ./deployment.yml
kubectl create -f ./service.yml
echo "$(minikube ip) Spring4" | sudo tee -a /etc/hosts