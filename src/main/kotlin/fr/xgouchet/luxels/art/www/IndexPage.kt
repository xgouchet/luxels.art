package fr.xgouchet.luxels.art.www

import fr.xgouchet.luxels.art.render.htmlPage
import fr.xgouchet.luxels.art.route.Route
import io.javalin.http.Context
import io.javalin.http.HandlerType
import kotlinx.html.h1
import kotlinx.html.hGroup
import kotlinx.html.header
import kotlinx.html.p

class IndexPage : Route {

    override val path: String = "/"
    override val method: HandlerType = HandlerType.GET

    override fun handle(ctx: Context) {
        ctx.htmlPage("Index") {

            header {
                hGroup {
                    h1 { +"“Luxels”" }
                    p { +"A generative art project" }
                }
            }
            p {
                +"Lorem ipsum dolor sit amet…"
            }
        }
    }

}