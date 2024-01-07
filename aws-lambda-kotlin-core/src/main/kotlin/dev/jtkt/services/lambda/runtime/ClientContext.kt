package dev.jtkt.services.lambda.runtime

interface ClientContext {
    val client: Client?
    val custom: MutableMap<String, String>
    val environment: Map<String, String>
}

interface Client {
    val installationId: String
    val appTitle: String
    val appVersionName: String
    val appVersionCode: String
    val appPackageName: String
}