sudo chmod 666 /var/run/docker.sock
minikube config set driver docker
minikube config set memory 12192
eval $(docker-machine env default)




1. Start the branch service
2. Start the customer service
3. Start the api gateway
4. Fetch the branch details using below:

http://localhost:8080/branch-service/branch

5. Fetch the customer details using below:

http://localhost:8090/customer/all #local
http://localhost:8080/customer-service/customer/all



https://vocon-it.com/2018/11/19/single-node-kubernetes-cluster-1-installing-minikube-on-centos/

Open powershell
minikube start
minikube docker-env
minikube -p minikube docker-env | Invoke-Expression

docker system prune
docker image rm <image id>

mvn clean install
cd branch-service\src\main\resources

docker build -t rkp/branch-service:1.0 .

cd customer-service\src\main\resources




cd ../api-gateway
docker build -t rkp/api-gateway:1.0 .
docker images

1. Deploy branch

cd branch-service
docker build -t rkp/branch-service:1.0 .
cd src\main\resources
a. deploy configmap 
kubectl apply -f branch-mysql-configmap.yml
kubectl get configmap
b. Create credentials
kubectl apply -f branch-mysqldb-credentials.yml
kubectl apply -f branch-mysqldb-root-credentials.yml
kubectl get secrets

c. Deploy mysql
kubectl apply -f branch-mysql-deployment.yml
kubectl describe pods <pod id>
kubectl get deployments
d. deploy branch service
kubectl apply -f branch-service-deployment.yml

2. Deploy customer
cd customer-service
docker build -t rkp/customer-service:1.0 .

cd src\main\resources
1. deploy configmap
kubectl apply -f customer-mysql-configmap.yml
kubectl get configmap
2. Create credentials
kubectl apply -f customer-mysqldb-credentials.yml
kubectl apply -f customer-mysqldb-root-credentials.yml
kubectl get secrets

3. deploy mysql
kubectl apply -f customer-mysql-deployment.yml
kubectl describe pods <pod id>
kubectl get deployments
4. 
kubectl apply -f customer-service-deployment.yml

kubectl config use-context minikube

http://192.168.99.102:30164/branch
http://192.168.99.103:30165/customer/all


cd ../api-gateway
docker build -t rkp/api-gateway-service:1.0 .
cd src\main\resources

kubectl apply -f api-gateway-deployment.yml

Branch JSON:
{"name":"Mayur Vihar PhaseII"}

Emp json:
{"empNo":"E02","empName":"Rajesh Kumar","age":"34","dob":"2019-12-22",
 "branch":{"id":1,"name":"Mayur Vihar PhaseII"},"address":{"address":"F8","city":"DELHI", "state": "Delhi", "country": "India", "zipCode":"201009"}}
 
 http://localhost:8080/api/branch-service/branch/1
 
 gateway url:
 http://localhost:8080/api/branch-service/branch/1
