package fr.xgouchet.luxels.art.server.extensions

import io.javalin.Javalin
import io.javalin.config.JavalinConfig
import io.javalin.http.Header
import io.javalin.http.staticfiles.Location
import kotlin.time.Duration.Companion.days

class PublicFilesExtension : JavalinExtension {

    override fun onConfigure(config: JavalinConfig) {
        config.staticFiles.add { staticFiles ->
            staticFiles.directory = "/public"
            staticFiles.location = Location.CLASSPATH
            staticFiles.precompress = true
            staticFiles.headers = mapOf(Header.CACHE_CONTROL to "max-age=${TTL.inWholeSeconds}")
        }
//        config.staticFiles.add("public")
    }

    override fun onPrepare(javalin: Javalin) {
    }

    companion object {
        val TTL = 7.days
    }
}
