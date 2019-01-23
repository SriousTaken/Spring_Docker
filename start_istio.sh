cd istio-1.0.5
helm template install/kubernetes/helm/istio --name istio --namespace istio-system > $HOME/istio.yaml
kubectl create namespace istio-system
kubectl apply -f $HOME/istio.yaml
kubectl label namespace spring istio-injection=enabled
kubectl label namespace default istio-injection=enabled
