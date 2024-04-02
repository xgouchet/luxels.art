package fr.xgouchet.luxels.art

import fr.xgouchet.luxels.art.route.RouterExtension
import fr.xgouchet.luxels.art.server.Application
import fr.xgouchet.luxels.art.server.extensions.PublicFilesExtension
import io.javalin.util.JavalinLogger

fun main() {
    JavalinLogger.enabled = true
    JavalinLogger.startupInfo = false

    val application = Application()

    val routerExtension = routerExtension()
    application.addExtension(routerExtension)
    application.addExtension(PublicFilesExtension())

    application.start()
}


private fun routerExtension(): RouterExtension {


    return RouterExtension()
}