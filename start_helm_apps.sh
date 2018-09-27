helm install --name mongodb \
  --set mongodbRootPassword=pw,mongodbUsername=user,mongodbPassword=pw,mongodbDatabase=my-database \
  stable/mongodb
#helm install --name rabbitmq \
#  --set rabbitmq.username=admin,rabbitmq.password=pw,rabbitmq.erlangCookie=secretcookie \
#    stable/rabbitmq