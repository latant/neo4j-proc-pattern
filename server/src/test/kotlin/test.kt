import org.neo4j.driver.Config
import org.neo4j.driver.GraphDatabase
import org.neo4j.harness.Neo4jBuilders

fun main() {

    val neo4j = Neo4jBuilders.newInProcessBuilder().withProcedure(CreateNode::class.java).build()
    val driver = GraphDatabase.driver(neo4j.boltURI(), Config.builder().withoutEncryption().build())
    runServer(driver)

}