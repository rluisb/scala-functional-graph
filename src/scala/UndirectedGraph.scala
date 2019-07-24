class UndirectedGraph[V](adjList: Map[V, List[V]]) extends DirectedGraph[V](adjList) {

  override def addEdge(a: V, b: V): DirectedGraph[V] = {
    val aNeighbours = b +: neighbours(a)
    val bNeighbours = a +: neighbours(b)
    new UndirectedGraph(adjList + (a -> aNeighbours, b -> bNeighbours))
  }

}
