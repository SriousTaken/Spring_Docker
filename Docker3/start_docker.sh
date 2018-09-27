eval $(minikube docker-env)
docker build -t spring3:v1 .
kubectl create -f ./deployment.yml
kubectl create -f ./service.yml
echo "$(minikube ip) Spring3" | sudo tee -a /etc/hosts