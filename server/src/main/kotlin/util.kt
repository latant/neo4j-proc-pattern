import org.neo4j.driver.QueryRunner
import org.neo4j.driver.Value

fun QueryRunner.callProcedure(name: String, vararg arg: Any?): Value {
    val argNames = arg.indices.map { "arg$it" }
    val record = run("CALL $name(${argNames.joinToString { "\$$it" }})", argNames.zip(arg).toMap()).single()
    record["error"].takeUnless { it.isNull }?.let { e ->
        throw DomainException(DomainException.Type.valueOf(e["type"].asString()), e["parameters"].asMap())
    }
    return record["result"]
}