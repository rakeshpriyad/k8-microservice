
minikube docker-env
eval $(minikube -p minikube docker-env)
BASE_DIR=/home/aayush/k8
BANK_DIR=${BASE_DIR}/k8-microservice/microservice-with-api-gateway-eureka-ribbon/bank
B_SERVICE=${BANK_DIR}/branch-service
#kubectl delete deployments branch-service 2>/dev/null || echo "No more branch-service deployment"
kubectl delete deployments customer-service 2>/dev/null || echo "No more customer-service deployment to remove."
kubectl delete deployments discovery-service 2>/dev/null || echo "No more branch-service deployment to remove."
kubectl delete deployments api-gateway-service 2>/dev/null || echo "No more api-gateway-service deployment to remove."
kubectl delete deployments load-balance-service 2>/dev/null || echo "No more oad-balance-service deployment to remove."
#docker rmi $(docker images | grep branch-service | awk '{print $3}') 2>/dev/null || echo "No more branch-service image to remove."
docker rmi $(docker images | grep customer-service | awk '{print $3}') 2>/dev/null || echo "No more customer-service image to remove."
docker rmi $(docker images | grep discovery-service | awk '{print $3}') 2>/dev/null || echo "No more discovery-service image to remove."
docker rmi $(docker images | grep api-gateway-service | awk '{print $3}') 2>/dev/null || echo "No more api-gateway-service image to remove."
docker rmi $(docker images | grep load-balance-service | awk '{print $3}') 2>/dev/null || echo "No more api-gateway-service image to remove."


#cd ${B_SERVICE}
#docker build -t rkp/branch-service:1.0 .
#cd ${B_SERVICE}/src/main/resources

#a. Deploy configmap 
#kubectl apply -f branch-mysql-configmap.yml
#kubectl get configmap
#b. Create credentials
#kubectl apply -f branch-mysqldb-credentials.yml
#kubectl apply -f branch-mysqldb-root-credentials.yml

#kubectl get secrets

#c. Deploy mysql
#kubectl apply -f branch-mysql-deployment.yml
#kubectl describe pods <pod id>
#kubectl get deployments
#d. deploy branch service
#kubectl apply -f branch-service-deployment.yml

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

#3. Deploy Discovery Gateway
D_SERVICE=${BANK_DIR}/discovery-service
cd ${D_SERVICE}

docker build -t rkp/discovery-service:1.0 .
cd ${D_SERVICE}/src/main/resources

#4. Deploy Api gateway service
kubectl apply -f discovery-service-deployment.yml

A_SERVICE=${BANK_DIR}/api-gateway
cd ${A_SERVICE}

docker build -t rkp/api-gateway-service:1.0 .
cd ${A_SERVICE}/src/main/resources
#5. Deploy Api Gateway service
kubectl apply -f api-gateway-deployment.yml

#6. Deploy load balance-service ribbon
L_SERVICE=${BANK_DIR}/load-balance-service
cd ${L_SERVICE}

docker build -t rkp/load-balance-service:1.0 .
cd ${L_SERVICE}/src/main/resources
#5. Deploy Api Gateway service
kubectl apply -f load-balance-service-deployment.yml


kubectl get deployments
kubectl get pods


