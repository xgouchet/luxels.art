package fr.xgouchet.luxels.art.www

import fr.xgouchet.luxels.art.data.Series
import fr.xgouchet.luxels.art.data.seriesTitle
import fr.xgouchet.luxels.art.render.htmlPage
import fr.xgouchet.luxels.art.route.Route
import io.javalin.http.Context
import io.javalin.http.HandlerType
import io.javalin.http.NotFoundResponse
import kotlinx.html.a
import kotlinx.html.article
import kotlinx.html.div
import kotlinx.html.h3
import kotlinx.html.header
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.section

class GalleryPage : Route {

    override val path: String = "/gallery/{name}"
    override val method: HandlerType = HandlerType.GET

    override fun handle(ctx: Context) {
        val seriesId = ctx.pathParam("name")
        val series = Series.all.firstOrNull { it.identifier == seriesId }
        if (series == null) {
            throw NotFoundResponse()
        }

        ctx.htmlPage("Luxels - ${series.title}", withLightBox = true) {

            article (classes = "gallery"){
                header {
                    h3 { seriesTitle(series) }
                }

                section(classes = "hero"){
                    div  {
                        val imgName = series.imageNames[0]
                        a(href = "/image/series/${series.identifier}/$imgName.${series.format}") {
                            attributes["data-fslightbox"] = series.identifier
                            img(src = "/image/series/${series.identifier}/$imgName.${series.format}")
                        }
                    }
                }

                p {}
                val columns = 6
                val rows = (series.imageNames.size / columns) + 1
                repeat(rows) { row ->
                    section(classes = "grid") {
                        repeat(columns) { col ->
                            val idx = (row * columns) + col + 1
                            div {
                                if (idx < series.imageNames.size) {
                                    val imgName = series.imageNames[idx]
                                    a(href = "/image/series/${series.identifier}/$imgName.${series.format}") {
                                        attributes["data-fslightbox"] = series.identifier
                                        img(src = "/image/series/${series.identifier}/thumbs/$imgName.${series.format}")
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}