# IAM Section

IAM stands for Identity and Access Management.
IAM is a global service, not region based.

AWS Identity and Access Management (IAM) is a web service for securely controlling access to AWS resources. It enables you to create and control services for user authentication or limit access to a certain set of people who use your AWS resources.

## TLDR

IAM (Identity and Access Management) is a global service, resposible for controlling access to AWS resources. It's used to control authentication or to limit access to a set of users.

Users can be grouped, with a feature called Groups. Both users and groups can have policies assigned to them. These policies define what permissions and access they have. Since AWS applies the Least Privilege Principle, a given user will have access based on the permissions assigned to them. These policies can be represented with a JSON document.

## Users & Groups

- Root accounts created by default, they shouldn't be used or shared.
- Users are people within your organization, and they can be grouped.
- Groups only contain users, not other groups.
- Users don't have to belong to a group, and user can belong to multiple groups.

## Permissions

- Users or Groups can be assigned JSON documents called policies.
- These policies define the permissions of the users.
- In AWS, you apply the least privilege principle: don't give more permissions than a user needs.

## Management Console for IAM (Identity and Access Management)

- Access management:
- - User groups: View and configure groups, each having specific permissions.
- - Users: View and configure users.
- - Roles:
- - Policies: List of actions allowed, per user or group
- - Identity providers:

## Policies inheritance

Policies structure:
- Version: policy language version, always include "2012-10-17"
- Id: an identifier for the policy (optional)
- Statement: one or more individual statements (required)

Statements structure:
- Sid: an identifier for the statement (optional)
- Effect: whether the statement allows or denies access (Allow, Deny)
- Principal: account/user/role to which this policy applied to
- Action: list of actions this policy allows or denies
- Condition: conditions for when this policy is in effect (optional)

## Password Policy

You can defined a password policy, making sure you have strong passwords and a higher security for your account.

With a password policy, you can:
- Set a minimum password length;
- Require specific character types;
- Allow all IAM users to change their own passwords
- Require users to change their password after some time (password expiration)
- Prevent password re-use

## Multi Factor Authentication (MFA)

Users have access to your account and can possibly change configurations or delete resources in your AWS account. To protect your Root Accounts and IAM users, you can setup multi factor authentication.

MFA = password you know + security device you own

Main benefit of MFA: If a password is stolen or hacked, the account is not compromised.

Security device options:
- Virtual MFA device (Google Authenticator, Authy). Has support for multiple tokens on a single device.
- Universal 2nd Factor (U2F) Security Key. Has support for multiple root and IAM users using a single security key.
- Hardware Key Fov MFA Device
- Hardware Key Fob MFA Device for AWS GovCloud.

## How can users access AWS?

- AWS Management Console (protected by password + MFA)
- AWS Command Line Interface (CLI): protected by access keys
- AWS Software Developer Kit (SDK) - for code: protected by access keys

- Access Keys are generated through the AWS Console
- Users manage their own acces keys
- Access Keys are secret, just like a password. Don't share them
- Access Key ID ~= username
- Secret Access Key ~= password

Do not share your access keys

## AWS CLI

The AWS CLI is a tool that enables you to interact with AWS services using commands in your command-line shell. It gives you direct access to the public APIs of AWS services, and you can develop scripts to manage resources through the CLI.

The AWS CLI is open source, and can be accessed [here](https://github.com/aws/aws-cli/tree/v2).

## AWS SDK

AWS provides Software Development Kits (AWS SDK), that are language-specific APIs (set of libraries) that enable you to access and manage AWS services programmatically.

The AWS SDK is used embedded in your application.