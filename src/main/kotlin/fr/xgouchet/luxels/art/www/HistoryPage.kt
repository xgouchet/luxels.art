package fr.xgouchet.luxels.art.www

import fr.xgouchet.luxels.art.render.htmlPage
import fr.xgouchet.luxels.art.route.Route
import io.javalin.http.Context
import io.javalin.http.HandlerType
import kotlinx.html.a
import kotlinx.html.blockQuote
import kotlinx.html.br
import kotlinx.html.cite
import kotlinx.html.code
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
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.script
import kotlinx.html.section
import kotlinx.html.style
import kotlinx.html.sub
import kotlinx.html.sup
import kotlinx.html.title
import kotlinx.html.ul
import kotlin.text.Typography.nbsp

class HistoryPage : Route {

    override val path: String = "/history"
    override val method: HandlerType = HandlerType.GET

    override fun handle(ctx: Context) {
        ctx.htmlPage("Luxels - History") {

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
                    +"The Algorists group included artists such as Jean-Pierre Hébert, Ken Musgrave, Roman Verostko, "
                    +"Mark Wilson, Manfred Mohr, Hiroshi Kawano and many others. "
                    +"The definition of Algorist was given by J.-P. Hébert in 1995 in the form of an algorithm, stating "
                    +"that an Algorist should fulfill the following requirements:"
                }

                ul {
                    li { +"they should create something new;" }
                    li { +"the creation should have some artistic quality;" }
                    li { +"the creation must be the result of an algorithm;" }
                    li { +"the algorithm must have been written by the algorist themselves." }
                }

                blockQuote {
                    code {
                        +"if (creation && object of art && algorithm && one's own algorithm) {"
                        br()
                        +"$nbsp $nbsp include * an algorist *"
                        br()
                        +"} elseif (!creation || !object of art || !algorithm || !one's own algorithm) {"
                        br()
                        +"$nbsp $nbsp exclude * not an algorist *"
                        br()
                        +"}"
                    }
                    footer {
                        cite { +"- Jean-Pierre Hébert, 1995" }
                    }
                }

                p {
                    +"During my studies in Computer Graphics and Virtual Reality in the mid 2000s, I met a french group "
                    +"of Algorists, and started playing with ways to generate art based on algorithmic logic. We used to "
                    +"meet once a month, exchanging over our projects, and brainstorming ideas. At the time, we already "
                    +"had discussions about whether or not AI could do something artistic (a very philosophical question, "
                    +"and to this day unanswered)."
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
                    +"another computer artist, coined the name "
                    a(href = "https://superliminal.com/fractals/bbrot/") { +"“Buddhabrot”" }
                    +", hinting at the similarity between the "
                    +"image and the traditional representation of Buddha."
                }
                div {
                    img(src = "/image/history/buddhabrot.png") {
                        style = "display: block; margin: auto; object-fit: cover;"
                        width = "640"
                    }
                    p {
                        style = "text-align:center;"
                        em { +"Buddhabrot" }
                        +" — Melinda Green, 1993"
                    }
                }
                footer { hr() }
            }

            section {
                header { h3 { +"The first experiments: 2008-2011" } }
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
                    img(src = "/image/history/2008_aether.jpg") {
                        style = "display: block; margin: auto; object-fit: cover;"
                        width = "640"
                    }
                    p {
                        style = "text-align:center;"
                        em { a(href = "/gallery/aether") { +"Aether" } }
                        +" — Xavier F. Gouchet, 2008"
                    }
                }


                div {
                    img(src = "/image/history/2009_pixie_dust.jpg") {
                        style = "display: block; margin: auto; object-fit: cover;"
                        width = "640"
                    }
                    p {
                        style = "text-align:center;"
                        em {
                            +"Luxels: "
                            a(href="/gallery/pixie-dust") { +"Pixie Dust" }
                        }
                        +" — Xavier F. Gouchet, 2009"
                    }
                }
                footer { hr() }
            }

            section {
                header { h3 { +"The first period: 2012-2016" } }
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
                        em {
                            +"Luxels: "
                            a(href="/gallery/gravity") { +"Gravity" }
                        }
                        +" — Xavier F. Gouchet, 2012"
                    }
                }

                p {
                    +"Along the years, I experimented with many different rules, trying to come up algorithmically with "
                    +"the pictures I had in mind, sometimes successfully, sometimes not."
                }

                footer { hr() }
            }

            section {
                header { h3 { +"The second period: 2017-2023" } }
                p {
                    +"In 2017, the Processing framework felt like a constraint, and I wanted to allow more out of the "
                    +"Luxels concept. I decided it was time to write my own engine from scratch (ish)."
                }

                p {
                    +"That same year, Kotlin started to get some traction, especially in the Android community (which is "
                    +"where I make a living). Google announced first class citizen support for the language, and "
                    +"along with a few colleagues, I started to play with that language."
                }

                p {
                    +"This lead to a logical conclusion. Why note write my Luxels engine in Kotlin. It would allow me "
                    +"more flexibility, and also give me a project to learn Kotlin. As I worked on that core engine, I "
                    +"kept working on new series, among which "
                    em { +"Aura" }
                    +" was published."
                }

                div {
                    img(src = "/image/history/2017_aura.jpg") {
                        style = "display: block; margin: auto; object-fit: cover;"
                        width = "640"
                    }
                    p {
                        style = "text-align:center;"
                        em {
                            +"Luxels: "
                            a(href="/gallery/aura") { +"Aura" }
                        }
                        +" — Xavier F. Gouchet, 2017"
                    }
                }


                p {
                    +"I kept on working on those experiments, on an off. Some series never passed the draft stage, "
                    +"others would not reach a satisfying result, and are kept as "
                    em { +"work-in-progress-that-I-will-work-on-again-probably" }
                    +". I did eventually released another series from that period, named "
                    em { +"Smoke" }
                    +"."
                }

                div {
                    img(src = "/image/history/2021_smoke.jpg") {
                        style = "display: block; margin: auto; object-fit: cover;"
                        width = "640"
                    }
                    p {
                        style = "text-align:center;"
                        em {
                            +"Luxels: "
                            a(href="/gallery/smoke") { +"Smoke" }
                        }
                        +" — Xavier F. Gouchet, 2021"
                    }
                }

                footer { hr() }
            }

            section {
                header { h3 { +"The third period: 2024-…" } }
                p {
                    +"In 2024, I realised that my Kotlin engine, although much better than my original Processing scripts, "
                    +"still had room for improvement. The language itself had evolved, and my knowledge of it too. "
                    +"I decided to make a luxel engine, Mark 3 if you will, with a couple of global objectives."
                }

                p {
                    +"First, it had to give me room to experiment and play with the concept of Luxels, and make new "
                    +"series. Hopefully with more ease to bring to the digital world the images I have in my mind."
                }

                p {
                    +"Second, it had to follow best practices in terms of coding. Better structure, automated tests, "
                    +"strict static analysis, everything that I use in my daily job, and is often forgotten in pet "
                    +"projects. Also, to make things more complex, I decided to make it as a Kotlin Multiplatform "
                    +"project. The idea being that I could eventually decline it as a website sandbox (similar to "
                    a(href = "https://www.shadertoy.com/") { +"Shadertoy" }
                    +"), or as an Android live wallpaper application."
                }

                p {
                    +"Third, I decided to make the whole thing completely Open Source. I've been an Open Source "
                    +"afficionado since my first year learning about programming, and I've contributed to countless "
                    +"project. Sharing is caring, and I'd be delighted if some people could make things out of the "
                    +"Luxel engine I share. "
                }

                p {
                    +"The adventure is just starting, and I'm thrilled to see what's coming next."
                }

                footer { hr() }
            }
        }
    }

}