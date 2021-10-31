# Object

A Kubernetes object is a "record of intent" - once you create the object, the Kubernetes system will constantly work to ensure that object exists. By creating an object, you're effectively telling the Kubernetes system what you want your cluster's workload to look like; this is your cluster's _desired state_.

## Object Spec and Status

Almost every Kubernetes object includes two nested object fields that govern the object's configuration: the object _spec_ and the object _status_. For objects that have a _spec_, you have to set this when you create the object, providing a description of the characteristics you want the resource to have: its _desired state_.

The _status_ describes the _current state_ of the object, supplied and updated by the Kubernetes system and its components. The Kubernetes control plane continually and actively manages every object's actual state to match the desired state you supplied.

## Describing a Kubernetes object

When you use the Kubernetes API to create the object, that API request must include that information as JSON in the request body. **Most often, you provide the information to _kubectl_ in a .yaml file.**

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
    name: nginx-deployment
spec:
    selector:
        matchLabels:
            app: nginx
    replicas: 2 # tells deployment to run 2 pods matching the template
    template:
        metadata:
            labels:
                app: nginx
        spec:
            containers:
            - name: nginx
              image: nginx:1.14.2
              ports:
              - containerPort: 80
```

## Object Names and IDs

Each object in your cluster has a Name that is unique for that type of resource. Every Kubernetes object also has a UID that is unique across your whole cluster.

