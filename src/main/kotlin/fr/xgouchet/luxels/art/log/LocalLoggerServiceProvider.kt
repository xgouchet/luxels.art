package fr.xgouchet.luxels.art.log

import org.slf4j.ILoggerFactory
import org.slf4j.IMarkerFactory
import org.slf4j.helpers.BasicMarkerFactory
import org.slf4j.spi.MDCAdapter
import org.slf4j.spi.SLF4JServiceProvider

class LocalLoggerServiceProvider : SLF4JServiceProvider {

    private val _loggerFactory: ILoggerFactory by lazy { LocalLoggerFactory() }
    private val _markerFactory: IMarkerFactory by lazy { BasicMarkerFactory() }

    override fun initialize() {
    }

    override fun getLoggerFactory(): ILoggerFactory {
        return _loggerFactory
    }

    override fun getMarkerFactory(): IMarkerFactory {
        return _markerFactory
    }

    override fun getMDCAdapter(): MDCAdapter {
        TODO("Not yet implemented")
    }

    override fun getRequestedApiVersion(): String = "2.0.7"
}