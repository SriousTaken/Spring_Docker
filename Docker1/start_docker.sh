eval $(minikube docker-env)
minikube ip > cluster_ip.txt
docker build -t spring1:v1 .
kubectl create -f ./deployment.yml
kubectl create -f ./service.yml