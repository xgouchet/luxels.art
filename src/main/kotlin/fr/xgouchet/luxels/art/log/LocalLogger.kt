package fr.xgouchet.luxels.art.log

import org.slf4j.Marker
import org.slf4j.event.Level
import org.slf4j.helpers.LegacyAbstractLogger
import org.slf4j.helpers.MessageFormatter

/**
 * A local logger using ANSI colors
 */
class LocalLogger(name: String) : LegacyAbstractLogger() {

    var currentLogLevel = Level.INFO
    var hideSecrets = true

    private val shortName = name.substringAfterLast('.')

    init {
        this.name = name
    }

    // region Logger

    override fun isTraceEnabled(): Boolean {
        return isLevelEnabled(Level.TRACE)
    }

    override fun isDebugEnabled(): Boolean {
        return isLevelEnabled(Level.DEBUG)
    }

    override fun isInfoEnabled(): Boolean {
        return isLevelEnabled(Level.INFO)
    }

    override fun isWarnEnabled(): Boolean {
        return isLevelEnabled(Level.WARN)
    }

    override fun isErrorEnabled(): Boolean {
        return isLevelEnabled(Level.ERROR)
    }

    // endregion

    // region AbstractLogger

    override fun getFullyQualifiedCallerName(): String? = null

    override fun handleNormalizedLoggingCall(
        level: Level,
        marker: Marker?,
        messagePattern: String?,
        arguments: Array<out Any>?,
        throwable: Throwable?,
    ) {
        val output = buildString {
            append(
                when (level) {
                    Level.ERROR -> "${ANSI_RED}✘ "
                    Level.WARN -> "${ANSI_YELLOW}⚠ "
                    Level.INFO -> "${ANSI_WHITE}ℹ "
                    Level.DEBUG -> "${ANSI_LIGHT_GREY}δ "
                    Level.TRACE -> "${ANSI_DARK_GREY}⚙ "
                },
            )

            if (shortName.length < 14) {
                append(shortName.padEnd(16, ' '))
            } else {
                append(shortName.substring(0, 14))
                append("… ")
            }

            var formattedMessage = MessageFormatter.basicArrayFormat(messagePattern, arguments)

            if (marker == SECRET_MARKER) {
                append("⚿ ")
                if (hideSecrets) {
                    formattedMessage = formattedMessage.replace(ARGUMENTS) {
                        ":" + "█".repeat(it.groupValues[1].length)
                    }
                    formattedMessage = formattedMessage.replace(SECRET_REGEX) {
                        "█".repeat(it.groupValues[1].length)
                    }
                }
            } else if (marker != null) {
                append("⚡ ")
            } else {
                append("  ")
            }

            append(formattedMessage)
            append(ANSI_RESET)
        }

        val stream = when (level) {
            Level.ERROR, Level.WARN -> System.err
            else -> System.out
        }

        System.out.println(output)
        throwable?.printStackTrace(stream)
    }

    // endregion

    // region Internal

    private fun isLevelEnabled(level: Level): Boolean {
        return currentLogLevel.toInt() <= level.toInt()
    }

    // endregion

    companion object {

        val SECRET_REGEX = Regex("([a-fA-F0-9-]{4,})")
        val ARGUMENTS = Regex(":([a-zA-Z0-9-.]+)")

        const val ANSI_RESET = "\u001B[0m"

        const val ANSI_BLACK = "\u001B[30m"
        const val ANSI_RED = "\u001B[31m"
        const val ANSI_GREEN = "\u001B[32m"
        const val ANSI_YELLOW = "\u001B[33m"
        const val ANSI_BLUE = "\u001B[34m"
        const val ANSI_PURPLE = "\u001B[35m"
        const val ANSI_CYAN = "\u001B[36m"
        const val ANSI_LIGHT_GREY = "\u001B[37m"
        const val ANSI_DARK_GREY = "\u001B[90m"
        const val ANSI_WHITE = "\u001B[97m"
    }
}