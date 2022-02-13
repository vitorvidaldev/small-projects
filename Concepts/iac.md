# IaC

IaC means Infrastructure as Code. It is the method of defining and provisioning infrastructure using definition files containing code. The references for the information provided in this file are [^1] and [^2].

IaC offers a way to unify previously separate processes and automate infrastructure provisioning. This makes the process simpler, faster, and more reliable when aligning infrastructure requirements and application deployment.

IaC configuration tools act as a single source of truth throughout the application development process. This allows a straightforward version control and eliminates the need for unnecessary documentation.

IaC is an important part of implementating DevOps practices and continuos integration/continuos delivery (CI/CD). IaC takes away the majority of provisioning work from developers, who can execute a script to have their infrastructure ready to go.

Benefits:
- Faster development time
- Reliability and consistency
- Churn protection
- Cost savings
- Elimite configuration drift

### Declarative approach

A declarative approach defines the desired state fo the system, including what resources you need and any properties they should have, and an IaC tool will configure it for you.

A declarative approach also keeps a list of the current state of your system objects, which makes talking down the infrastructure simpler to manage.

## References
[^1]: [Cisco](https://www.cisco.com/c/en/us/solutions/cloud/what-is-iac.html#~key-q-a)
[^2]: [RedHat](redhat.com/en/topics/automation/what-is-infrastructure-as-code-iac)