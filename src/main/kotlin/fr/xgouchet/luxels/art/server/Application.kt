package fr.xgouchet.luxels.art.server

import fr.xgouchet.luxels.art.log.LOGGER
import fr.xgouchet.luxels.art.server.extensions.JavalinExtension
import io.javalin.Javalin

class Application {

    private lateinit var javalin: Javalin
    private val extensions = mutableListOf<JavalinExtension>()

    fun addExtension(extension: JavalinExtension) {
        extensions.add(extension)
    }

    fun start() {
        LOGGER.info("Configure server")
        javalin = Javalin.create { config ->
            config.showJavalinBanner = false
            extensions.forEach { extension ->
                extension.onConfigure(config)
            }
        }

        LOGGER.info("Prepare server")
        extensions.forEach { extension ->
            extension.onPrepare(javalin)
        }

        val environment = Configuration.environment
        javalin.start(Configuration.port())
        LOGGER.info("Server started on ${environment.hostUrl}")
    }
}