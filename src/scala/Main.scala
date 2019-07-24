object Main extends App {

  val graph = Graph[String]()
    .addEdge("London", "Lisbon")
    .addEdge("Lisbon", "Madrid")
    .addEdge("Madrid", "London")
    .addEdge("Madrid", "Rome")
    .addEdge("Rome", "London")
    .addEdge("Paris", "Rome")

  //  print(graph.neighbours(vertex = "London"))
  //
    Traversal.traversalDFS("London", graph, println)
    println()
  //  Traversal.traversalDFSAlt("London", graph, println)
  Traversal.traversalBFS("London", graph, println)
}
