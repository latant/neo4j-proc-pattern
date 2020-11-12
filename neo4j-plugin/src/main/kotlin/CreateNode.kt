import org.neo4j.graphdb.Transaction
import org.neo4j.logging.Log
import org.neo4j.procedure.*
import java.util.stream.Stream

class CreateNode {

    @Context
    lateinit var log: Log

    @Context
    lateinit var transaction: Transaction

    @Procedure(Procedures.CreateNode, mode = Mode.WRITE)
    @Description("Creates a node")
    fun createNode(@Name("properties") properties: Map<String, Any?>) = procedureResult {
        val node = transaction.createNode()
        properties.forEach(node::setProperty)
        //throw DomainException(NodeCannotBeCreated)
        node
    }

}