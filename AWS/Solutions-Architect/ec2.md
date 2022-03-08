# AWS Elastic Compute Cloud (EC2)

EC2 = Elastic Compute Cloud = Infrastructure as a Service

It mainly consists of:
- Renting virtual machines (EC2)
- Storing data on virtual drives (EBS)
- Distributing load across machines (ELB)
- Scalling the services using an auto-scaling group (ASG)

EC2 is region based.

## AWS Billing Budget

You have to enable billing and cost management permissions as root user. Once this configuration is enabled, admin IAM users can setup billing alarms.

In the Billing Dashboard, you can visualize what services are generating expenses, and how much.

You can create a Cost Budget, defining the budget amount, and notification options.

## EC2 Sizing and Configuration Options

You have to choose:
- Operating System
- How much compute power & cores (CPU)
- How much random-access memory (RAM)
- How much storage space:
- - Network-attatched (EBS & EFS)
- - Hardware (EC2 Instance Store)
- Network card: speed of the card, Public IP address
- Firewall rules: security group
- Bootstrap script: EC2 User Data

## EC2 User Data

It is possible to bootstrap your instances using an EC2 User Data script.

Bootstrapping means launching commands when a machine starts.

That script is only run once at the instance first start.

EC2 user data is used to automate boot tasks such as:
- Installing updates
- Installing software
- Downloading common files from the internet
- etc

The EC2 User Data Script runs with the root user of the virtual machine.

## EC2 Instance Types

You can use different types of EC2 instances that are optimized for different use cases.

General Purpose:
- Great for a diversity of workloads such as web servers or code repositories;
- Balance between compute, memory, and networking;

Compute Optimized:
- Great for compute-intensive tasks that require high performance processors

Memory Optimized:
- Fast performance for workloads that process large data sets in memory

Storage Optimized:
- Great for storage-intensive tasks that require high, sequential read and write access to large datasets on local storage.

## Security Groups

Security Groups are the fundamental of networking security in AWS.

They control how traffic is allowed into or out of our EC2 Instances.

Security groups only contain allow rules.

Security groups can only be referenced by IP or by security group.

Security groups are acting as a "firewall" on EC2 instances.

Secutity groups regulate:
- Access to Ports
- Authorized IP ranges - IPv4 and IPv6
- Control of inbound network (from other to the instance)
- Control of outbound network (from the instance to other)

Security Groups are a service outside EC2.

Security Groups have to be configured per VPC and region.

The Security Group allows all outbound traffic by default.

The Security Group blocks all inbound traffic by default.

Security Groups can be attached to multiple instances.

Classic Ports to know:
- 22 = SSH (Secure Shell) - log into a Linux instance
- 21 = FTP (File Transfer Protocol) - upload files into a file share
- 22 = SFTP (Secure File Transfer Protocol) - upload files using SSH
- 80 = HTTP - access unsecured websites
- 443 = HTTPS - access secured websites
- 3389 = RDP (Remote Desktop Protocol) - log into a Windows instance

It is considered good practice to have a separate security group for SSH.

If your application is not accessible (time out), then it's a security group issue.

## SSH

For servers running Linux, Mac, and Windows 10 or newer, you can use SSH to access them. If you're using an onder version of Windows, you'll have to use Putty, an utility that is a terminal emulator, serial console and network file transfer application. With this application, you can connect to the server using the SSH protocol.

You can also use EC2 Instance Connect, to connect to your EC2 instances. It works with the amz-linux-2 machines, at this time.

## EC2 Instance Launch Types

On-Demand Instances: short workload, predicable pricing

Reserved (one year or more) :
- Reserved Instances: long workloads
- Convertible Reserved Instances: long workloads with flexible instances
- Schedule Reserved Instances: example - every Thursday between 3 and 6 pm

Spot Instaces: short workloads, cheap, can lose instances (less reliable)

Dedicated Hosts: book an entire physical server, control instance placement

### EC2 On Demand
Pay for what you use:
- Linux or Windows: billing per second, after the first minute
- All other operating systems: billing per hour

Has the highest cost but no upfront payment

No long-term commitment

Recommended for short-term and un-interrupted workloads, where you can't predict how the application will behave.

### EC2 Reserved Instances
Up to 75% discount compared to On-demand.

Purchasing options: no upfront, partial upfront, all upfront.

You have to reserve a specific instance type.

Recommended for steady-state usage applications.

### EC2 Spot Instances

You can get up to 90% discount compared to On-demand.

Instances that you can "lose" at any point of time if your max price is less than the current spot price.

Useful for workloads that are resilient for failure. Examples:
- Batch jobs
- Data analysis
- Image processing
- Any distributed workloads
- Workloads with a flexible start and end time

This type of instance is not suitable for critical jobs or databases.

### EC2 Dedicated Hosts

An Amazon EC2 Dedicated Host is a physical server with EC2 instance capacity fully dedicated to your use. Dedicated Hosts can help you address compliance requirements and reduce costs by allowing you to use your existing server-bound software licenses.

Allocated for your account for a 3-year period reservation.