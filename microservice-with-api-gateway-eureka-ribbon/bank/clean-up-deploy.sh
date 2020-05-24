
kubectl delete deployments branch-service 2>/dev/null || echo "No more branch service deployment to remove"
kubectl delete deployments customer-service 2>/dev/null || echo "No more customer-service deployment to remove."
kubectl delete deployments discovery-service 2>/dev/null || echo "No more discovery-service deployment to remove."
kubectl delete deployments api-gateway-service || echo "No more customer-service deployment to remove."
kubectl delete deployments load-balance-service || echo "No more customer-service deployment to remove."
docker rmi $(docker images | grep branch-service | awk '{print $3}') 2>/dev/null || echo "No more branch-service image to remove."
docker rmi $(docker images | grep customer-service | awk '{print $3}') 2>/dev/null || echo "No more customer-service image to remove."
docker rmi $(docker images | grep discovery-service | awk '{print $3}') 2>/dev/null || echo "No more discovery-service image to remove."
docker rmi $(docker images | grep api-gateway-service | awk '{print $3}') 2>/dev/null || echo "No more api-gateway-service image to remove."
docker rmi $(docker images | grep load-balance-service | awk '{print $3}') 2>/dev/null || echo "No more api-gateway-service image to remove."

docker images
