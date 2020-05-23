
kubectl delete deployments branch-service
kubectl delete deployments customer-service
kubectl delete deployments discovery-service
kubectl delete deployments api-gateway-service
docker rmi $(docker images | grep branch-service | awk '{print $3}')
docker rmi $(docker images | grep customer-service | awk '{print $3}')
docker rmi $(docker images | grep discovery-service | awk '{print $3}')
docker rmi $(docker images | grep api-gateway-service | awk '{print $3}')

docker images
