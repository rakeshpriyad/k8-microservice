BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/microservice-with-api-gateway/bank

# Deploy customer
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

