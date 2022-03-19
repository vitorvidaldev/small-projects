# General notes

AWS provides out of the box policies. These can be identified by the orange box icon shown before the policy name. You cannot edit the out of the box policies. Policies can be versioned.

Policy syntax:
- version
- statement

You can create a Role for a AWS service, an account, an web identity or SAML.

IAM is a free and global service.

## Amazon Congnito

Cognito is decentralized managed authentication system.

Web Identity Federation and IpD (Identity Provider)

Cognito User Pools. Thesse are user directories used to manage actions such as sign-up, sign-in, account recovery, and account confirmation.

Cognito Identity Pools let's you choose who to provide access to.

## AWS CLI (Command line interface) and AWS SDK (Software development kit)

Important: Easily switch between AWS accounts using --profile. Change the --output between json, table and text

Set of API libraries that let you integrate AWS services into your applications.

You have to enable Programmatic Access for the user. This can be enabled during creation. This generates an Access Id and an Access Secret.

In your root directory, create a directory with name ".aws". Create a file called "credentials", and set up your profile and credentials.

## DNS

Doman Name System (DNS) is the service which handles converting a domain name into a routable Internet Protocol (IP) address.

IP Addesses are what uniquely identifies each computer on a network, and allows communication between them using the Internet Protocol(IP).

Domain registrars are authorities who have the ability to assign domain names under one or more top-level domains.

## Amazon EC2 (Elastic Compute Cloud)

EC2 is a highly configurable server, and allows resizable compute capacity.

Instace types:
- General Purpose
- Compute Optimized
- Memory Optimized
- Accelerated Optimized
- Storage Optimized

Instead of embedding your AWS credentials in your code so your Instace has permissions to access certain services you can Attach a role to an instance via an Instance Profile.

An Instace Profile holds a reference to a role. The EC2 instance is associated with the Instance Profile.

Place Groups let you to choose the logical placement of your instances to optimize for communication, performance or durability. Placement groups are free.

- Cluster
- Partition
- Spread

You can provide an EC2 with UserData which is a script that will be automatically run when launching an EC2 instance. You could install packages, apply updates or anything you like.

Launch and SSH into your server within minutes.


## EC2 princing
On-Demand Instances: When you lauch an EC2 instance it is by default using On-Demand Pricing. On-demand has no up-front payment and no long-term commitment.

Reserved Instances: Designed for applications that have a steady-state, predictable usage, or require reserved capacity. Reduced Pricing is based on Term x Class Offering x Payment Option.

Spot Instances: AWS has unused compute capacity that they want to maximize the utility of their idle servers. Instances can be terminated by AWS at anytime.

Dedicated Host Instances: Designed to meet regulatory requirements. When you have strict server-bound licensing that won't support multi-tenancy or clod deployments.

## Amazon Machine Images (AMI)

An Amazon Machine Image (AMI) provides the information required to launch an instance. You must specify an AMI when you launch an instance. You can launch multiple instances from a single AMI when you need multiple instances with the same configuration. You can use different AMIs to launch instances when you need instances with different configurations.

AMIs are region specific. If you want ot use an AMI from another region, you'll need to copy the AMI and the select the destination region.

AMIs help you keep incremental changes to your OS, application code and system packages.

## Auto Scaling Groups (ASG)

You can define scaling policies.

## Elastic Load Balancer (ELB)

Load balancers can be physical hardware or virtual software that accepts incoming traffic, and then distributes the traffic to multiple targets. They can balance the load via different rules. These rules vary based on types of load balancers.

AWS provides three types of load balancers:
- Application load balancer (ALB) - Http/Https
- Network load balancer (NLB) - TCP/UDP
- Classic Load Balancer (CLB) - Legacy

Sticky Sessions is an advanced load balancing method that allows you to bind a user's sessions to a specific EC2 instance.