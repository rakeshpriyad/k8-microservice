BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/microservice-with-api-gateway/bank
B_SERVICE=${BANK_DIR}/branch-service
cd ${B_SERVICE}
docker build -t rkp/branch-service:1.0 .
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
kubectl apply -f branch-service-deployment.yml

#2. Deploy customer
C_SERVICE=${BANK_DIR}/customer-service
cd ${C_SERVICE}

docker build -t rkp/customer-service:1.0 .
cd ${C_SERVICE}/src/main/resources

# deploy configmap
kubectl apply -f customer-mysql-configmap.yml
kubectl get configmap
# Create credentials
kubectl apply -f customer-mysqldb-credentials.yml
kubectl apply -f customer-mysqldb-root-credentials.yml
#kubectl get secrets

#3. deploy mysql
kubectl apply -f customer-mysql-deployment.yml
#kubectl describe pods <pod id>
#kubectl get deployments
#4. Deploy customer service 
kubectl apply -f customer-service-deployment.yml

#3. Deploy Api Gateway
A_SERVICE=${BANK_DIR}/api-gateway
cd ${A_SERVICE}

docker build -t rkp/api-gateway-service:1.0 .
cd ${A_SERVICE}/src/main/resources


#4. Deploy Api Gatewat service 
kubectl apply -f api-gateway-deployment.yml
