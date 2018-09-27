kubectl delete service spring4
kubectl delete deployment spring4
sudo perl -pi -e "s,^$(minikube ip) Spring4\n$,," /etc/hosts