package dev.jtkt.services.lambda.runtime

interface ClientContext {
    val client: Client?
    val custom: MutableMap<String, String>
    val environment: Map<String, String>
}

interface Client {
    val appPackageName: String
    val appTitle: String
    val appVersionCode: String
    val appVersionName: String
    val installationId: String
}