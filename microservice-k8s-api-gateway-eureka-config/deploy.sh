kubectl apply -f k8s
kubectl set image deployments/configserver configserver=rkp/config-server:$SHA
kubectl set image deployments/contactus contactus=rkp/contact-us-service:$SHA
kubectl set image deployments/eureka eureka=rkp/eureka-server:$SHA
kubectl set image deployments/user user=rkp/user-service:$SHA
kubectl set image deployments/zuul zuul=rkp/zuul-server:$SHA