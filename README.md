# How to run in Kubernetes

1. `minikube start --driver='virtualbox' --memory 8192 --cpus 2 --extra-config=kubelet.max-pods=100`
1. `minikube addons enable metrics-server`
1. `minikube addons enable ingress`
1. `eval $(minikube -p minikube docker-env)`
1. `docker build -t mykube .`
1. `kubectl apply -f kubernetes.yml`

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


# Kafka Configuration (Using Docker)
First of all download (Confluent Community Tools)[curl -O http://packages.confluent.io/archive/7.0/confluent-community-7.0.0.tar.gz]

``` bash
docker-compose -f docker-compose-kafka.yml up
```
## Create a Topic
``` bash
$CONFLUENT_BIN_PATH/kafka-topics --create --if-not-exists --bootstrap-server "localhost:9092" --topic "mytopic"
```

## Send a Message
### Connect to the topic
``` bash
$CONFLUENT_BIN_PATH/kafka-console-producer --broker-list "localhost:9092" --topic "mytopic"
```
### Send some message
``` bash
My first message{ENTER}
```

### Close connection
``` bash
{CTRL+C}
```

## Receiving Messages
``` bash
$CONFLUENT_BIN_PATH/kafka-console-consumer --bootstrap-server "localhost:9092" --from-beginning --topic "mytopic" --group "my-consumer-group"
```

# Problems
## vboxnet0 is down
``` bash
sudo ip link set vboxnet0 up
sudo ip address add 192.168.99.1/24 dev vboxnet0
```
