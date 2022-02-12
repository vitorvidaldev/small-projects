# IAM Section

IAM stands for Identity and Access Management.
IAM is a global service, not region based.

AWS Identity and Access Management (IAM) is a web service for securely controlling access to AWS resources. It enables you to create and control services for user authentication or limit access to a certain set of people who use your AWS resources.

## Users & Groups

- Root accounts created by default, they shouldn't be used or shared.
- Users are people within your organization, and can they can be grouped.
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