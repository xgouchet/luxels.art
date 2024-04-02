package fr.xgouchet.luxels.art.server

object Configuration {


    fun port(): Int {
        return System.getenv("PORT")?.toIntOrNull() ?: 2342
    }

    enum class Environment(
        val id: String,
        val hostUrl: String,
        val themeColor: String
    ) {
        LOCAL("local", "http://localhost:${port()}", "blue"),
        DEV("development", "http://localhost:${port()}", "purple"),
        STAGING("staging", "http://localhost:${port()}", "yellow"),
        PROD("production", "http://localhost:${port()}", "green"),
        CI("ci", "http://localhost:${port()}", "grey"),
        UNKNOWN("unknown", "http://localhost:${port()}", "red"),
    }

    @JvmStatic
    val environment by lazy {

        val envId = System.getenv("PLATFORM_ENVIRONMENT_TYPE")
        if (envId.isNullOrBlank()) {
            Environment.LOCAL
        } else {
            Environment.entries.firstOrNull { it.id == envId } ?: Environment.UNKNOWN
        }
    }


    @JvmStatic
    fun isLocal(): Boolean {
        return environment == Environment.LOCAL
    }

    @JvmStatic
    fun isDev(): Boolean {
        return environment == Environment.DEV
    }

    @JvmStatic
    fun isStaging(): Boolean {
        return environment == Environment.STAGING
    }

    @JvmStatic
    fun isProd(): Boolean {
        return environment == Environment.PROD
    }

    @JvmStatic
    fun isCI(): Boolean {
        return environment == Environment.CI
    }

    fun hostName(): String {
        return if (isLocal()) {
            "http://localhost:${port()}"
        } else {
            ""
        }
    }

    const val ALLOW_REGISTER = true
    const val REGISTER_AS_ADMIN = false
}