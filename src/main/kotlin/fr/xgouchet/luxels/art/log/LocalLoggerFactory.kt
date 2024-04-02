package fr.xgouchet.luxels.art.log

import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class LocalLoggerFactory : ILoggerFactory {

    private val loggers = mutableMapOf<String, Logger>()

    override fun getLogger(name: String): Logger {
        val cachedLogger = loggers[name]
        return if (cachedLogger != null) {
            cachedLogger
        } else {
            val logger = LocalLogger(name)
            loggers[name] = logger
            logger
        }
    }
}