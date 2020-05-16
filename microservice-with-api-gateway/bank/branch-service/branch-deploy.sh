BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/microservice-with-api-gateway/bank
B_SERVICE=${BANK_DIR}/branch-service
cd ${B_SERVICE}
docker build -t rkp/branch-service:1.0 .
cd ${B_SERVICE}/src/main/resources

#d. deploy branch service
kubectl apply -f branch-service-deployment.yml
