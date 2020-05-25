
minikube docker-env
eval $(minikube -p minikube docker-env)
kubectl delete deployments customer-service 2>/dev/null || echo "No more customer-service deployment to remove."
kubectl delete deployments discovery-service 2>/dev/null || echo "No more branch-service deployment to remove."
kubectl delete deployments api-gateway-service 2>/dev/null || echo "No more api-gateway-service deployment to remove."
kubectl delete deployments load-balance-service 2>/dev/null || echo "No more oad-balance-service deployment to remove."
kubectl delete deployments config-server 2>/dev/null || echo "No more config-server deployment to remove."
docker rmi $(docker images | grep customer-service | awk '{print $3}') 2>/dev/null || echo "customer-service image already removed."
docker rmi $(docker images | grep discovery-service | awk '{print $3}') 2>/dev/null || echo "discovery-service image already remove."
docker rmi $(docker images | grep api-gateway-service | awk '{print $3}') 2>/dev/null || echo "api-gateway-service image already remove."
docker rmi $(docker images | grep load-balance-service | awk '{print $3}') 2>/dev/null || echo "load-balance-service image already remove."
docker rmi $(docker images | grep config-server | awk '{print $3}') 2>/dev/null || echo "config-server image already remove."

#1. Create images
BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/k8-api-gateway-eureka-ribbon-hystrix-config/bank


#a. Create Customer Service docker image
C_SERVICE=${BANK_DIR}/customer-service
cd ${C_SERVICE}
docker build -t rkp/customer-service:1.0 .

#b. Create Discovery Service docker image
D_SERVICE=${BANK_DIR}/discovery-service
cd ${D_SERVICE}
docker build -t rkp/discovery-service:1.0 .

#c. Create Api Gateway Service docker image
A_SERVICE=${BANK_DIR}/api-gateway
cd ${A_SERVICE}
docker build -t rkp/api-gateway-service:1.0 .

#d. Create load balance service ribbon image
L_SERVICE=${BANK_DIR}/load-balance-service
cd ${L_SERVICE}
docker build -t rkp/load-balance-service:1.0 .

#e. Create Config server image
C_SERVICE=${BANK_DIR}/load-balance-service
cd ${C_SERVICE}
docker build -t rkp/config-server:1.0 .

K8S=${BANK_DIR}/k8s
cd ${K8S}

#2. Deploy configmap
kubectl apply -f customer-mysql-configmap.yml
#kubectl get configmap
#3. Deploy credentials in secrets
kubectl apply -f customer-mysqldb-credentials.yml
kubectl apply -f customer-mysqldb-root-credentials.yml
#kubectl get secrets

#4. Deploy mysql
kubectl apply -f customer-mysql-deployment.yml

#5. Deploy applications
# a. Deploy Config Server
kubectl apply -f config-server-deployment.yml


# b. Deploy Customer service 
kubectl apply -f customer-service-deployment.yml


# c. Deploy Discovery service
kubectl apply -f discovery-service-deployment.yml

# d. Deploy Api Gateway service
kubectl apply -f api-gateway-deployment.yml

# e. Deploy Load Balance service
kubectl apply -f load-balance-service-deployment.yml

#kubectl describe pods <pod id>
#Get deployments
kubectl get deployments
#Get pods
kubectl get pods


