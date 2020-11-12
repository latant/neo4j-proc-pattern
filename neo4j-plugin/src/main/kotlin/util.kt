import java.util.stream.Stream

fun procedureResult(action: () -> Any): Stream<ProcedureResult> {
    val result = try {
        ProcedureResult(result = action())
    } catch (e: DomainException) {
        ProcedureResult(error = mapOf("type" to e.type.toString(), "parameters" to e.parameters))
    }
    return Stream.of(result)
}