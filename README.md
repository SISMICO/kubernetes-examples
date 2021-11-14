# How to run in Kubernetes

1. `minikube start --driver='virtualbox' --memory 8192 --cpus 2 --extra-config=kubelet.max-pods=100`
1. `minikube addons enable metrics-server`
1. `eval $(minikube -p minikube docker-env)`
1. `docker build -t mykube .`
1. `minikube cp Prometheus/prometheus.yml /home/docker/prometheus.yml`
1. `kubectl apply -f kubernetes.yml`
1. Open in a new shell `minikube mount /home/leonardo/Projetos/kubernetes-examples/Prometheus:/prometheus`


# Install Prometheus
``` bash
kubectl create namespace prometheus
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm install prometheus prometheus-community/kube-prometheus-stack --namespace prometheus
kubectl get pods -n prometheus
kubectl port-forward -n prometheus prometheus-prometheus-kube-prometheus-prometheus-0 9090
kubectl port-forward -n prometheus prometheus-grafana-74b9c448f6-qcptr 3000
```
[Reference](https://www.magalix.com/blog/monitoring-of-kubernetes-cluster-through-prometheus-and-grafana)

# Problems
## vboxnet0 is down
``` bash
sudo ip link set vboxnet0 up
sudo ip address add 192.168.99.1/24 dev vboxnet0
```
