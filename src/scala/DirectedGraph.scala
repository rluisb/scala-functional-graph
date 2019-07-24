class DirectedGraph[V](adjList: Map[V, List[V]]) extends Graph[V] {
  override def vertices: List[V] = adjList.keys.toList

  override def edges: List[(V, V)] = adjList.flatMap { case (vertex, neighbours) =>
    neighbours.map(neighbour => (vertex, neighbour))
  }.toList

  override def addEdge(a: V, b: V): DirectedGraph[V] = {
    val aNeighbours = b +: neighbours(a)
    new DirectedGraph(adjList + (a -> aNeighbours))
  }

  override def neighbours(vertex: V): List[V] = adjList.getOrElse(vertex, Nil)
}
