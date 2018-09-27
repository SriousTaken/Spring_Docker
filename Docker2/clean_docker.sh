kubectl delete service spring2
kubectl delete deployment spring2
sudo perl -pi -e "s,^$(minikube ip) Spring2\n$,," /etc/hosts