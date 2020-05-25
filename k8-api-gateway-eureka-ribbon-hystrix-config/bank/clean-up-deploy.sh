
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

docker images
