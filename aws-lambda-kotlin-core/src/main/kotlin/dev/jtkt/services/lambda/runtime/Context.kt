package dev.jtkt.services.lambda.runtime

interface Context {
    val awsRequestId: String
    val clientContext: ClientContext?
    val functionName: String
    val functionVersion: String
    val identity: CognitoIdentity?
    val invokedFunctionArn: String
    val logGroupName: String?
    val logStreamName: String?
    val memoryLimitInMB: Int
    val remainingTimeInMillis: Int
    val logger: LambdaLogger
        get() = PrintLogger
}