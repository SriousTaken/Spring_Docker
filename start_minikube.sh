minikube start --memory=8192 --cpus=4 --vm-driver=virtualbox
minikube addons enable ingress
kubectl create -f ingress_controller.yml

