# How to run in Kubernetes

1. `minikube start --driver='virtualbox'`
1. `eval $(minikube -p minikube docker-env)`
1. `docker build -t mykube .`
1. Open in a new shell `minikube mount /home/leonardo/Projetos/kubernetes-examples/Prometheus:/prometheus`


http://localhost:8080/actuator/health

# Problems
## vboxnet0 is down
``` bash
sudo ip link set vboxnet0 up
sudo ip address add 192.168.99.1/24 dev vboxnet0
```
