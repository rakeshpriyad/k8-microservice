
#1. Deploy branch

cd branch-service
docker build -t rkp/branch-service:1.0 .
cd src/main/resources
#a. deploy configmap 
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
cd customer-service
docker build -t rkp/customer-service:1.0 .

cd src\main\resources
#1. deploy configmap
kubectl apply -f customer-mysql-configmap.yml
#kubectl get configmap
#2. Create credentials
kubectl apply -f customer-mysqldb-credentials.yml
kubectl apply -f customer-mysqldb-root-credentials.yml
#kubectl get secrets

#3. deploy mysql
kubectl apply -f customer-mysql-deployment.yml
#kubectl describe pods <pod id>
#kubectl get deployments
#4. 
kubectl apply -f customer-service-deployment.yml

#kubectl config use-context minikube

#http://192.168.99.102:30164/branch
#http://192.168.99.103:30165/customer/all


cd ../api-gateway
docker build -t rkp/api-gateway-service:1.0 .
cd src\main\resources

kubectl apply -f api-gateway-deployment.yml
