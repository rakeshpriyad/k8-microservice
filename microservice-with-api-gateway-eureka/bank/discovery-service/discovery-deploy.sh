BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/microservice-with-api-gateway-eureka/bank

#3. Deploy Discovery Service
A_SERVICE=${BANK_DIR}/discovery-service
cd ${A_SERVICE}

docker build -t rkp/discovery-service:1.0 .
cd ${A_SERVICE}/src/main/resources

#4. Deploy Dsicovery service 
kubectl apply -f discovery-deployment.yml
