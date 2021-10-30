# Kubernetes

Kubernetes is an open source container orchestration engine for automating deployment, scaling, and management of containerized applications.

You can deploy a Kubernetes cluster on a local machine, into the cloud, or in your own datacenter.

A production-quality Kubernetes cluster requires planning and preparation. If your Kubernetes cluster has to run critical workloads, it must be configured to be resilient.

## What is Kubernetes?

Kubernetes is a portable, extensible, open-source platform for managing containerized workloads and services, that facilitates both declarative configuration and automation.

### Why you need Kubernetes and what is can do

Kubernetes provides you with a framework to run distributed systems resiliently. It takes care of scaling and failover for your application, provides deployment patterns, and more.

Key Features:
- Service discovery and load balancing
- Storage orchestration
- Automated rollouts and rollbacks
- Automatic bin packing
- Self-healing
- Secret and configuration management

### What Kubernetes is not

Kubernetes is not a traditional, all-inclusive PaaS (Platform as a Service) system. It provides the building blocks for building developer platforms, but preserves user choice and flexibility where it is important.

## Kubernetes Components

When you deploy Kubernetes, you get a cluster.

A Kubernetes cluster consists of a set of worker machines, called nodes, that run containerized applications. Every cluster has at least one worker node.

The worker node(s) host the Pods that are the components of the application workload. THe control plane manages the worker nodes and the Pods in the cluster. In production environments, the control plane usually runs across multiple computers and a cluster usually runs multiple computers and a cluster usually runs multiple nodes, providing fault-tolerance and high availability.

## The Kubernetes API

The core of Kubernetes' control plane is the API server. The API server exposes an HTTP API that lets end users, different parts of your cluster, and external components communicate with one another.

The Kubernetes API lets you query and manipulate the state of API objects in Kubernetes.