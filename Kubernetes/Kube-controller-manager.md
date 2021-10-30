# kube-controller-manager

Control plane component that runs controller processes.

- Node controller: Responsible for noticing and responding when nodes go down.
- Job controller: Watches for job objects that represent one-off tasks, then creates Pods to run those tasks to completion.
- Endpoints controller: Populates the Endpoints object.
- Service Account & Token controllers: Create default accounts and API access tokens for new namespaces.