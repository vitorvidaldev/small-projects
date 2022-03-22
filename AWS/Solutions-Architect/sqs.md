# Amazon Simple Queue Service (SQS)

When the ReceiveMessageWaitTimeSeconds property of a queue is set to a value greater tahn zero, long polling is in effect. Long polling reduces the number of empty responses by allowing Amazon SQS to wait until a message is available before sending a response to a ReceiveMessage request.
