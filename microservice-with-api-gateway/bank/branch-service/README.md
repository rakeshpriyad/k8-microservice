https://vocon-it.com/2018/11/19/single-node-kubernetes-cluster-1-installing-minikube-on-centos/

Open powershell
minikube start
minikube docker-env
minikube -p minikube docker-env | Invoke-Expression

docker system prune
docker image rm <image id>
cd branch-service


docker build -t rkp/branch-service:1.0 .
docker build -t rkp/customers-service:1.0 .
cd ../api-gateway
docker build -t rkp/api-gateway:1.0 .
docker images

cd branch-service\src\main\resources

1. 
kubectl apply -f branch-mysql-configmap.yml
kubectl get configmap
2. Create credentials
kubectl apply -f branch-mysqldb-credentials.yml
kubectl apply -f branch-mysqldb-root-credentials.yml
kubectl get secrets

3. deploy mysql
kubectl apply -f branch-mysql-deployment.yml
kubectl describe pods <pod id>
kubectl get deployments
4. 
kubectl apply -f branch-service-deployment.yml

kubectl config use-context minikube

http://192.168.99.102:30164/branch

Branch JSON:
{"name":"Mayur Vihar PhaseII"}

Emp json:
{"empNo":"E02","empName":"Rajesh Kumar","age":"34","dob":"2019-12-22",
 "branch":{"id":1,"name":"Mayur Vihar PhaseII"},"address":{"address":"F8","city":"DELHI", "state": "Delhi", "country": "India", "zipCode":"201009"}}
 
 http://localhost:8080/api/branch-service/branch/1
 
 gateway url:
 http://localhost:8080/api/branch-service/branch/1