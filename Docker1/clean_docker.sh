kubectl delete service spring1
kubectl delete deployment spring1
sudo perl -pi -e "s,^$(minikube ip) Spring1\n$,," /etc/hosts