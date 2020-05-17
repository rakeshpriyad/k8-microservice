BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/microservice-with-api-gateway/bank

#3. Deploy Api Gateway
A_SERVICE=${BANK_DIR}/api-gateway
cd ${A_SERVICE}

docker build -t rkp/api-gateway-service:1.0 .
cd ${A_SERVICE}/src/main/resources

#4. Deploy Api Gatewat service 
kubectl apply -f api-gateway-deployment.yml
