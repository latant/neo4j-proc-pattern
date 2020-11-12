
class DomainException(val type: Type, val parameters: Map<String, Any?>) : Throwable(type.toString()) {

    constructor(type: Type, vararg parameter: Pair<String, Any?>) : this(type, parameter.toMap())

    enum class Type {
        NodeCannotBeCreated
    }

}