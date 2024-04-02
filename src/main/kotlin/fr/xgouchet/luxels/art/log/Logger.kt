package fr.xgouchet.luxels.art.log

import ch.qos.logback.classic.LoggerContext
import fr.xgouchet.luxels.art.server.Configuration
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.Marker
import org.slf4j.MarkerFactory

private const val LOGGER_NAME = "fr.xgouchet.luxels.art"

val SECRET_MARKER: Marker = MarkerFactory.getMarker("SECRET")

private fun getLoggerFactory(): ILoggerFactory {
    val factory = LoggerFactory.getILoggerFactory()

    if (factory is LoggerContext) {
        factory.isPackagingDataEnabled = true
        factory.putProperty("source", "java")
        factory.putProperty("env", Configuration.environment.id)
        factory.putProperty("service", "javalin")
    }

    return factory
}

val LOGGER: Logger by lazy { getLoggerFactory().getLogger(LOGGER_NAME) }
