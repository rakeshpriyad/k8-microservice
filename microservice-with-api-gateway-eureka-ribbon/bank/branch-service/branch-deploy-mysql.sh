BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/microservice-with-api-gateway-eureka/bank
B_SERVICE=${BANK_DIR}/branch-service
cd ${B_SERVICE}
#docker build -t rkp/branch-service:1.0 .
cd ${B_SERVICE}/src/main/resources

#a. Deploy configmap 
kubectl apply -f branch-mysql-configmap.yml
#kubectl get configmap
#b. Create credentials
kubectl apply -f branch-mysqldb-credentials.yml
kubectl apply -f branch-mysqldb-root-credentials.yml

#kubectl get secrets

#c. Deploy mysql
kubectl apply -f branch-mysql-deployment.yml
#kubectl describe pods <pod id>
#kubectl get deployments
#d. deploy branch service
#kubectl apply -f branch-service-deployment.yml
