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
import kotlinx.html.img
import kotlinx.html.li
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.nav
import kotlinx.html.p
import kotlinx.html.script
import kotlinx.html.section
import kotlinx.html.small
import kotlinx.html.stream.appendHTML
import kotlinx.html.strong
import kotlinx.html.style
import kotlinx.html.title
import kotlinx.html.ul
import kotlinx.html.unsafe

inline fun Context.htmlPage(
    pageTitle: String,
    withLightBox: Boolean = false,
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

                    if (withLightBox) {
                        script(type = "text/javascript", src = "/js/fslightbox.js") {}
                    }
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
        href = "https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.jade.min.css"
    )

    style {
        unsafe {
            +"footer { font-size: 80%; }\n"
            +"footer p { color:#7b8495 !important; }\n"
            +"footer img { width:20px; height: 20px; }\n"
            +".gallery .hero div a img { display: block; width: 768px; margin: auto; }\n"
            +".gallery .grid div a img { display: block; width: 128px; margin: auto; }\n"
        }
    }
}

fun BODY.bodyHeader() {
    header(classes = "container") {
        nav {
            ul { li { a(href = "/") { strong { +"Luxels.art" } } } }
            ul {
                li { a(href = "/history") { +"History" } }
                li { a(href = "/galleries") { +"Galleries" } }
//                li { a(href = "/about") { +"About…" } }
            }
        }
    }
}

fun BODY.bodyFooter() {
    footer {
        div(classes = "container") {
            section {
                p {
                    +"All content on this website, unless explicitly mentioned, is my own work and cannot be used to train AI models."
                }
                p {
                    +"All images on this website were created by Xavier F. Gouchet, and are licensed under "
                    a(
                        href = "https://creativecommons.org/licenses/by-nc-sa/4.0/?ref=chooser-v1",
                        target = "_blank"
                    ) {
                        title = "Creative Common License BY-NC-SA 4.0"
                        +"CC BY-NC-SA 4.0 "
                        listOf("cc", "by", "nc", "sa").forEach {
                            img(src = "https://mirrors.creativecommons.org/presskit/icons/$it.svg?ref=chooser-v1")
                        }
                    }
                }
            }
            section(classes = "grid") {
                p {
                    small { +"Site version ${BuildConfig.APP_VERSION} (${BuildConfig.GIT_HASH})" }
                    br()
                    small {
                        +"Built with "
                        a(href = "https://picocss.com") { +"Pico" }
                        +", "
                        a(href = "https://fslightbox.com") { +"Fullscreen Lightbox" }
                        +", "
                        a(href = "https://javalin.io/") { +"Javalin" }
                    }
                    br()
                    small {
                        +"Hosted on "
                        a(href = "https://platform.sh/") { +"Platform.sh" }
                        +" / "
                        a(href = "hhttps://us.ovhcloud.com/") { +"OVH" }
                    }
                }
                p {
                    small { +"GitHub" }
                    br()
                    small { a(href = "https://github.com/xgouchet/luxel-engine") { +"Luxel Engine" } }
                    br()
                    small { a(href = "https://github.com/xgouchet/luxels.art") { +"Luxels.art " } }
                }

                p {
                    small { +"Contact" }
                    br()
                    small { a(href = "https://pixelfed.art/luxels") { +"Pixelfed" } }
                    // TODO contact form
                }
            }
        }
    }
}
