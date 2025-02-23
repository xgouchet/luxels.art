package fr.xgouchet.luxels.art.www

import fr.xgouchet.luxels.art.render.htmlPage
import fr.xgouchet.luxels.art.route.Route
import io.javalin.http.Context
import io.javalin.http.HandlerType
import kotlinx.html.div
import kotlinx.html.em
import kotlinx.html.footer
import kotlinx.html.h1
import kotlinx.html.hGroup
import kotlinx.html.header
import kotlinx.html.hr
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.section
import kotlinx.html.style

class IndexPage : Route {

    override val path: String = "/"
    override val method: HandlerType = HandlerType.GET

    override fun handle(ctx: Context) {
        ctx.htmlPage("Luxels - Home") {
            header {
                hGroup {
                    h1 { +"“Luxels”" }
                    p { +"A generative art project" }
                }
            }

            section {
                div {
                    img(src = "/image/home/home.jpg") {
                        style = "display: block; margin: auto; object-fit: cover;"
                        width = "640"
                    }
                    p {
                        style = "text-align:center;"
                        em { +"Luxels: Spectre" }
                        +" — Xavier F. Gouchet, 2015"
                    }
                }
                footer { hr() }
            }
        }
    }

}