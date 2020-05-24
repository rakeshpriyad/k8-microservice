minikube docker-env
eval $(minikube -p minikube docker-env)
BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/microservice-with-api-gateway-eureka/bank
B_SERVICE=${BANK_DIR}/branch-service
kubectl delete deployments branch-service
kubectl delete deployments branch-mysql
kubectl delete deployments customer-service
kubectl delete deployments customer-mysql
kubectl delete deployments discovery-service
kubectl delete deployments api-gateway-service



