package fr.xgouchet.luxels.art.route

import io.javalin.http.Handler
import io.javalin.http.HandlerType

interface Route : Handler {

    val path: String

    val method: HandlerType

}