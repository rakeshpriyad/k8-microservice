BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/microservice-with-api-gateway-eureka/bank

# Deploy customer
C_SERVICE=${BANK_DIR}/customer-service
cd ${C_SERVICE}

docker build -t rkp/customer-service:1.0 .
cd ${C_SERVICE}/src/main/resources

#kubectl get deployments
#4. Deploy customer service 
kubectl apply -f customer-service-deployment.yml

