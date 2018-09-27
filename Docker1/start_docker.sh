eval $(minikube docker-env)
docker build -t spring1:v1 .
kubectl create -f ./deployment.yml
kubectl create -f ./service.yml
echo "$(minikube ip) Spring1" | sudo tee -a /etc/hosts