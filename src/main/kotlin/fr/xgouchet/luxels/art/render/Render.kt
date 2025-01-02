package fr.xgouchet.luxels.art.render

import fr.xgouchet.luxels.art.BuildConfig
import fr.xgouchet.luxels.art.server.Configuration
import io.javalin.http.Context
import kotlinx.html.BODY
import kotlinx.html.HEAD
import kotlinx.html.MAIN
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.br
import kotlinx.html.div
import kotlinx.html.footer
import kotlinx.html.head
import kotlinx.html.header
import kotlinx.html.html
import kotlinx.html.li
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.nav
import kotlinx.html.p
import kotlinx.html.section
import kotlinx.html.small
import kotlinx.html.stream.appendHTML
import kotlinx.html.strong
import kotlinx.html.title
import kotlinx.html.ul

inline fun Context.htmlPage(
    pageTitle: String,
    crossinline content: MAIN.() -> Unit = {},
) {
    html(
        buildString {
            append("<!DOCTYPE HTML>\n")
            appendHTML(prettyPrint = Configuration.isLocal(), xhtmlCompatible = false).html {
                attributes["data-theme"] = "dark"
                head {
                    htmlHead(pageTitle)
                }
                body {
                    bodyHeader()

                    main(classes = "container") { content() }

                    bodyFooter()
                }
            }
        }
    )
}

fun HEAD.htmlHead(pageTitle: String) {
    title { +pageTitle }

    // Pico CSS / Jade theme
    link(
        rel = "stylesheet",
        // Uncomment the following line instead to use a full width main container
//        href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.fluid.classless.jade.min.css"
        href = "https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.jade.min.css"
    )
}

fun BODY.bodyHeader() {
    header(classes = "container") {
        nav {
            ul { li { a(href = "/") { strong { +"Luxels.art" } } } }
            ul {
                li { a(href = "/history") { +"History" } }
//                li { a(href = "/gallery") { +"Gallery" } }
//                li { a(href = "/about") { +"About…" } }
            }
        }
    }
}

fun BODY.bodyFooter() {
    footer {
        div(classes = "container") {
            section(classes = "grid") {
                p {
                    small { +"Site version ${BuildConfig.APP_VERSION} (${BuildConfig.GIT_HASH})" }
                    br()
                    small {
                        +"Built with "
                        a(href = "https://picocss.com") { +"Pico" }
                        +" and "
                        a(href = "https://javalin.io/") { +"Javalin" }
                    }
                }
                p {
                    small { a(href = "https://github.com/xgouchet/luxel-engine") { +"Luxel Engine" } }
                    br()
                    small { a(href = "https://github.com/xgouchet/luxels.art") { +"Source " } }
                }
            }
        }
    }
}
