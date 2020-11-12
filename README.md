# neo4j-proc-pattern
An example server project using Neo4j plugin to achieve the best performance.

The project consists of three modules:
- **neo4j-plugin**: A plugin with an example built-in procedure.
- **server**: A Ktor server with an example endpoint that calls the procedure. For testing, it uses Neo4j Harness to run an embedded database with the plugin deployed.
- **common**: Consists of common code needed by both modules, like the names of the procedures and domain-specific exception types for transparent exception-handling.
