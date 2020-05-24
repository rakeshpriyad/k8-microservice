BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/microservice-with-api-gateway-eureka-ribbon/bank

#3. Deploy Discovery Service
A_SERVICE=${BANK_DIR}/load-balance-service
cd ${A_SERVICE}

docker build -t rkp/load-balance-service:1.0 .
cd ${A_SERVICE}/src/main/resources

#4. Deploy Dsicovery service 
kubectl apply -f load-balance-service-deployment.yml
