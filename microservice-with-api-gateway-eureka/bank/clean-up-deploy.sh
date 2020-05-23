
kubectl delete deployments branch-service
kubectl delete deployments customer-service
kubectl delete deployments discovery-service
kubectl delete deployments api-gateway-service
docker rmi $(docker images | grep branch-service | awk '{print $3}') 2>/dev/null || echo "No more branch-service image to remove."
docker rmi $(docker images | grep customer-service | awk '{print $3}') 2>/dev/null || echo "No more customer-service image to remove."
docker rmi $(docker images | grep discovery-service | awk '{print $3}') 2>/dev/null || echo "No more discovery-service image to remove."
docker rmi $(docker images | grep api-gateway-service | awk '{print $3}') 2>/dev/null || echo "No more api-gateway-service image to remove."

docker images
