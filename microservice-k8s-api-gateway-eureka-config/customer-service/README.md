Open powershell
minikube start
minikube docker-env
minikube -p minikube docker-env | Invoke-Expression

docker system prune
docker image rm <image id>
cd customer-service


docker build -t rkp/customer-service:1.0 .
cd ../api-gateway
docker build -t rkp/api-gateway:1.0 .
docker images

cd customer-service\src\main\resources

1. 
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


customer JSON:
{"name":"Mayur Vihar PhaseII"}

Emp json:
{"empNo":"E02","empName":"Rajesh Kumar","age":"34","dob":"2019-12-22",
 "customer":{"id":1,"name":"Mayur Vihar PhaseII"},"address":{"address":"F8","city":"DELHI", "state": "Delhi", "country": "India", "zipCode":"201009"}}
 
 http://localhost:8080/api/customer-service/customer/1
 
 gateway url:
 http://localhost:8080/api/customer-service/customer/1