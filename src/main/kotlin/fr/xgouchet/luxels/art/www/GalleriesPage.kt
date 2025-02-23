package fr.xgouchet.luxels.art.www

import fr.xgouchet.luxels.art.data.Series
import fr.xgouchet.luxels.art.data.seriesTitle
import fr.xgouchet.luxels.art.render.htmlPage
import fr.xgouchet.luxels.art.route.Route
import io.javalin.http.Context
import io.javalin.http.HandlerType
import kotlinx.html.a
import kotlinx.html.h3
import kotlinx.html.h4
import kotlinx.html.h5
import kotlinx.html.header
import kotlinx.html.section

class GalleriesPage : Route {

    override val path: String = "/galleries"
    override val method: HandlerType = HandlerType.GET

    override fun handle(ctx: Context) {
        ctx.htmlPage("Luxels - Galleries") {

            header {
                h3 { +"Galleries" }
            }

            Series.all
                .forEach {
                    section {
                        header {
                            h5 {
                                a(href = "/gallery/${it.identifier}") { seriesTitle(it) }
                            }
                        }
                    }
                }
        }
    }
}