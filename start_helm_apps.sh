#MongoDB
helm install --name mongodb \
  			 --set mongodbRootPassword=pw,mongodbUsername=user,mongodbPassword=pw,mongodbDatabase=my-database \
  			 stable/mongodb
#Prometheus
helm install stable/prometheus --name prometheus -f prometheus.yaml
helm install --name grafana \
			 --set service.type=NodePort \
	 		 stable/grafana  

#helm install --name rabbitmq \
#  --set rabbitmq.username=admin,rabbitmq.password=pw,rabbitmq.erlangCookie=secretcookie \
#    stable/rabbitmq
