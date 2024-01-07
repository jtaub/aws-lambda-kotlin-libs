package dev.jtkt.services.lambda.runtime

enum class LogLevel {
    TRACE,
    DEBUG,
    INFO,
    WARN,
    ERROR,
    FATAL,
}

fun interface LambdaLogger {
    fun log(level: LogLevel, message: () -> String)

    fun trace(message: () -> String) =
        log(LogLevel.TRACE, message)

    fun debug(message: () -> String) =
        log(LogLevel.DEBUG, message)

    fun info(message: () -> String) =
        log(LogLevel.INFO, message)

    fun warn(message: () -> String) =
        log(LogLevel.WARN, message)

    fun error(message: () -> String) =
        log(LogLevel.ERROR, message)

    fun fatal(message: () -> String) =
        log(LogLevel.FATAL, message)
}


data object PrintLogger : LambdaLogger {
    override fun log(level: LogLevel, message: () -> String) =
        println("[$level] ${message()}")
}