package fr.xgouchet.luxels.art.www

import fr.xgouchet.luxels.art.render.htmlPage
import fr.xgouchet.luxels.art.route.Route
import io.javalin.http.Context
import io.javalin.http.HandlerType
import kotlinx.html.a
import kotlinx.html.blockQuote
import kotlinx.html.cite
import kotlinx.html.div
import kotlinx.html.em
import kotlinx.html.footer
import kotlinx.html.h1
import kotlinx.html.h3
import kotlinx.html.hGroup
import kotlinx.html.header
import kotlinx.html.hr
import kotlinx.html.iframe
import kotlinx.html.img
import kotlinx.html.p
import kotlinx.html.script
import kotlinx.html.section
import kotlinx.html.style
import kotlinx.html.sub
import kotlinx.html.sup
import kotlinx.html.title

class HistoryPage : Route {

    override val path: String = "/history"
    override val method: HandlerType = HandlerType.GET

    override fun handle(ctx: Context) {
        ctx.htmlPage("Index") {

            header {
                hGroup {
                    h1 { +"History" }
                    p { +"How Luxels came to be?" }
                }
            }

            section {
                header { h3 { +"Fractals and Algorithmic Art" } }

                p {
                    +"Many scientists have found that some experiments gave some results that were not only interesting "
                    +"for our understanding of our universe, but also had real aesthetic and artistic value. "
                    +"A pretty good example of this is the popularity of the space pictures published by NASA on social networks."
                }

                p {
                    +"Among those scientific discoveries, one that holds a special place in my heart is the famous "
                    +"Mandelbrot Set. In 1975, Benoit Mandelbrot not only coined the word "
                    em { +"“fractals”" }
                    +" but also led to the set that is forever associated to its name, and has not finished revealing "
                    +"mesmerizing views of the complex space."
                }

                blockQuote {
                    +"“Being a language, mathematics may be used not only to inform but also, among other things, to seduce.”"
                    footer {
                        cite { +"- Benoit B. Mandelbrot" }
                    }
                }

                p {
                    +"Then in the 1990s, a group of scientist-artists came together as people who used algorithms to "
                    +"generate art, and started calling themselves "
                    em { a(href = "http://www.algorists.org/algorist.html") { +"Algorists" } }
                    +", a contraction between the words “algorithm” and “artist”."
                }

                p {
                    +"During my studies in Computer Graphics and Virtual Reality in the mid 2000s, I met a french group "
                    +"of Algorists, and started playing with ways to generate art based on algorithmic logic."
                }
            }

            section {
                header { h3 { +"Melinda Green's Buddhabrot" } }
                p {
                    +"Back in 1993, Melinda Green, a computer scientist and artist, came up with a new way to visualize "
                    +"the Mandlebrot set: since the interrogates whether an infinite series of complex numbers diverges "
                    +"or converges, she thought to visualize which points on the complex plane were the most visited."
                }

                p {
                    +"Put simply, the image is like a photographic film, and every iteration of the "
                    em {
                        +"z"
                        sub { +"n+1" }
                        +" = z"
                        sub { +"n" }
                        sup { +"2" }
                        +" + c"
                    }
                    +" formula is like a photon hitting that film at a specific location, ever so slightly brightening "
                    +"that pixel."
                }

                blockQuote {
                    +"“When I first tried using the new technique, I had no idea what the images might look like and was "
                    +"completely surprised by the results.”"
                    footer {
                        cite { +"- Melinda Green" }
                    }
                }

                p {
                    +"The image that resulted became almost as famous as the Mandlebrot Set itself, and Lori Gardi, "
                    +"another computer artist, coined the name “Buddhabrot”, hinting at the similarity between the "
                    +"image and the traditional representation of Buddha."
                }
                div {
                    img(src = "/img/history/buddhabrot.png") {
                        style = "display: block; margin: auto; object-fit: cover;"
                        width = "640"
                    }
                    p {
                        style = "text-align:center;"
                        em { +"Aether" }
                        +" — Melinda Green, 1993"
                    }
                }
                footer { hr() }
            }

            section {
                header { h3 { +"The first experiments" } }
                p {
                    +"When I started playing with "
                    a(href = "https://processing.org/") { +"Processing" }
                    +" in 2008, I spent a few days trying to implement famous works, including the Buddhabrot. "
                    +"Soon, I eventually thought about reusing the same principle of having a series of position "
                    +"guided by some arbitrary mathematical rules, to slowly add colored light to a film."
                }

                p {
                    +"I first created my "
                    em { +"Aether" }
                    +" series in Processing, soon followed by the "
                    em { +"Pixie Dust" }
                    +" series."
                    +"Both were based on that same idea, with simple rules, and results that I grew found of. "
                    +"At the time it was still just me tinkering without giving much thoughts about what I expected, "
                    +"just playing around with a new toy I wrote by myself."
                }
                div {
                    img(src = "/img/history/2008_aether.jpg") {
                        style = "display: block; margin: auto; object-fit: cover;"
                        width = "640"
                    }
                    p {
                        style = "text-align:center;"
                        em { +"Aether" }
                        +" — Xavier F. Gouchet, 2008"
                    }
                }
                footer { hr() }
            }

            section {
                header { h3 { +"The first period: 2009-2016" } }
                p {
                    +"When I thought of writing another series based on the same principle, I realised that I needed "
                    +"more structure. I wrote a first version of my engine in Processing (so it was mostly Java based) "
                    +"and added a couple of very basic animation logic."
                }

                p {
                    +"This allowed me to make my first animation based on my Luxels "
                    em { +"Gravity" }
                    +" series, where each particle would be affected by a force loosely based on the equations "
                    +"that govern the motion of the stars (hence the name)."
                }

                div {
                    iframe {
                        src =
                            "https://player.vimeo.com/video/36688872?badge=0&amp;autopause=0&amp;player_id=0&amp;app_id=58479"
                        // frameborder="0"
                        // allow="autoplay; fullscreen; picture-in-picture; clipboard-write"
                        style = "display: block; margin: auto;"
                        title = "Luxels &quot;Gravity&quot; #271"
                        width = "640"
                        height = "360"
                        attributes.put("frameborder", "0")
                    }
                    script(src = "https://player.vimeo.com/api/player.js") {}
                    p {
                        style = "text-align:center;"
                        em { +"Luxels: Gravity" }
                        +" — Xavier F. Gouchet, 2012"
                    }
                }

                p {
                    +"Along the years, I experimented with many different rules, trying to come up algorithmically with "
                    +"the pictures I had in mind, sometimes successfully, sometimes not."
                }

                footer { hr() }
            }
        }
    }

}