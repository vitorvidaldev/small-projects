# Getting Started

## AWS Cloud History

- 2002: Internally launched
- 2003: Amazon infrastructure is one of their core strengths.
- 2004: Launched publicly with SQS
- 2006: Re-lauched publicly with SQS, S3 & EC2
- 2007: Launched in Europe

## Facts

Gartner Magic Quadrant: AWS is the lider in the cloud provider service.

Revenue:
- 2019: $35.026 Billion
- 2020: $45,370 Billion

## Use Cases
- AWS enables you to build sophisticated, scalable applications
- Applicable to a diverse set of industries

## Global Infrastructure
- AWS Regions
- AWS Availability Zones
- AWS Data Centers
- AWS Edge Locations/Points of Presence

## AWS Regions

- There are regions all around the world. 
- Every region has a name (e.g. us-east-1). 
- A region is composed of clusters of data centers.
- Most AWS services are region-scoped. This means that if you're using a service in two different regions, they probabilly are different instances of the same service. This helps with availability (more on this later).

### How to choose an AWS Region?

A few factors to consider when choosing the region to use:
- Compliance with data governance and legal requirements: data never leaves a region without your explicit permission.
- Proximity to customers: reduced latency
- Available services within a region
- Pricing varies region to region

## AWS Availability Zones

- Each region has many availability zones (usually 3. Min is 2, max is 6)
- Each availability zone (AZ) is one or more discrete data centers with redundant power, networking, and connectivity.
- AZs are separate from each other, so that they're isolated from disasters
- AZs are connected with high bandwith, ultra-low latency networking

Example: For the AWS Region of ap-southeast-2 (Sydney), we have the following availability zones:
- ap-southeast-2a
- ap-southeast-2b
- ap-southeast-2c

## AWS Points of Presence (Edge Locations)

- More than 200 points of presence