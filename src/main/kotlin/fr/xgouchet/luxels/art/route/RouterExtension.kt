package fr.xgouchet.luxels.art.route

import fr.xgouchet.luxels.art.log.LOGGER
import fr.xgouchet.luxels.art.server.Configuration
import fr.xgouchet.luxels.art.server.extensions.JavalinExtension
import io.javalin.Javalin
import io.javalin.config.JavalinConfig
import org.reflections.Reflections
import org.reflections.scanners.Scanners
import java.lang.reflect.Modifier

class RouterExtension : JavalinExtension {

    // region  JavalinExtension

    override fun onConfigure(config: JavalinConfig) {
        if (Configuration.isLocal()) {
            config.bundledPlugins.enableRouteOverview("/debug")
        }
    }

    override fun onPrepare(javalin: Javalin) {
        val reflections = Reflections("fr.xgouchet.luxels.art.www")
        val subTypes = reflections.get(
            Scanners.SubTypes.of(Route::class.java).asClass<Route>(),
        )
        subTypes
            .filter { !Modifier.isAbstract(it.modifiers) }
            .forEach {

                val route = try {
                    it.getDeclaredConstructor().newInstance()
                } catch (e: InstantiationException) {
                    LOGGER.error("Unable to instantiate class $it ${it.modifiers}")
                    null
                }

                if (route is Route) {
                    javalin.addHttpHandler(route.method, route.path, route)
                    LOGGER.trace("Registered route for {}:{}", route.method, route.path)
                } else {
                    LOGGER.error("Instance of class $it is not a Route")
                }
            }
    }

    // endregion
}