package fr.xgouchet.luxels.art.data

import kotlinx.html.FlowOrPhrasingContent
import kotlinx.html.em
import kotlin.text.Typography.nbsp

fun FlowOrPhrasingContent.seriesTitle(series: Series) {
    +series.title
    +"$nbsp"
    em { +"(${series.year})" }
}