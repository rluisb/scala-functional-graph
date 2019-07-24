object Main extends App {

  val graph = Graph[String]()
    .addEdge("London", "Lisbon")
    .addEdge("Lisbon", "Madrid")
    .addEdge("Madrid", "London")
    .addEdge("Madrid", "Rome")
    .addEdge("Rome", "London")
    .addEdge("Paris", "Rome")

  print(graph.neighbours(vertex = "London"))

}
