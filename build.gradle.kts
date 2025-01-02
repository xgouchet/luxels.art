import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

plugins {
    kotlin("jvm") version ("1.9.0")
    kotlin("plugin.serialization") version ("1.9.0")

    // Creates a fat jar
    id("com.github.johnrengelman.shadow") version ("8.1.1")

    // Dependency updates
    id("com.github.ben-manes.versions") version ("0.49.0")

    // Build config
    id("com.github.gmazzo.buildconfig") version ("5.3.5")
}

group = "fr.xgouchet"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation(libs.bundles.excel) // XLSX import
    implementation(libs.bundles.javalin)
    implementation(libs.bundles.jakarta)
    implementation(libs.jodaTime)
    implementation(libs.bundles.jte) // Templating
    implementation(libs.jwt) // Auth/Security
    implementation(libs.kotlinSerialization)
    implementation(libs.kotlinxHtml)
    implementation(libs.platformshConfig) // Platform.sh (hosting)
    implementation(libs.reflections) // Reflection (auto route register)
    implementation(libs.bundles.logs)
    implementation(libs.openPdf)
    implementation(libs.markdown)

    //
//    testImplementation(kotlin("test"))
    testImplementation(libs.bundles.kotest)
    testImplementation(kotlin("reflect"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
    compilerOptions {
        allWarningsAsErrors.set(true)
    }
}

buildConfig {
    val format = SimpleDateFormat("yy.MM.dd").apply { timeZone = TimeZone.getTimeZone("UTC") }
    val date = format.format(Date())
    val treeId = System.getenv("PLATFORM_TREE_ID")
    val hash = if (treeId.isNullOrBlank()) {
        try {
            ByteArrayOutputStream().let { stdout ->
                rootProject.exec {
                    commandLine("git", "rev-parse", "--short", "HEAD")
                    standardOutput = stdout
                }
                stdout.toString().trim()
            }

        } catch (e: Exception) {
            e.printStackTrace()
            "???"
        }
    } else {
        treeId
    }

    buildConfigField("APP_VERSION", date)
    buildConfigField("GIT_HASH", hash)
}

tasks.shadowJar {
    manifest.attributes["Main-Class"] = "fr.xgouchet.luxels.art.MainKt"
}
