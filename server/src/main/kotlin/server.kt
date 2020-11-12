import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.neo4j.driver.Driver

fun runServer(driver: Driver) {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        routing {
            get {
                driver.session().use { s ->
                    val node = s.callProcedure(Procedures.CreateNode, mapOf("name" to "Anti", "age" to 23)).asNode()
                    call.respond(node.asMap().toString())
                }
            }
        }
    }.start(wait = true)
}

