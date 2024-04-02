package fr.xgouchet.luxels.art.server.extensions

import io.javalin.Javalin
import io.javalin.config.JavalinConfig

interface JavalinExtension {
    fun onConfigure(config: JavalinConfig)

    fun onPrepare(javalin: Javalin)
}