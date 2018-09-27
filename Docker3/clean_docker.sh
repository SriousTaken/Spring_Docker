kubectl delete service spring3
kubectl delete deployment spring3
sudo perl -pi -e "s,^$(minikube ip) Spring3\n$,," /etc/hosts