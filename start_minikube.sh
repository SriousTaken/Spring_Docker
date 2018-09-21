minikube start --vm-driver=virtualbox --memory 4096 --cpus 2
minikube addons enable ingress
kubectl create -f ingress_controller.yml