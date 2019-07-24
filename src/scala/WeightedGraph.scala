case class WeightedEdge[V](destination: V, weight: Int)

class WeightedGraph[V](adjList: Map[V, List[WeightedEdge[V]]]) extends Graph[V] {
  override def vertices: List[V] = adjList.keys.toList

  override def edges: List[(V, V)] = adjList.flatMap { case (vertex, edgeList) =>
    edgeList.map(edge => vertex -> edge.destination)
  }.toList

  def addEdge(a: V, weightedEdge: WeightedEdge[V]): WeightedGraph[V] = {
    val aNeighbours = weightedEdge +: adjList.getOrElse(a, Nil)
    new WeightedGraph(adjList + (a -> aNeighbours))
  }

  override def addEdge(a: V, b: V): WeightedGraph[V] = addEdge(a, new WeightedEdge(b, weight = 0))

  override def neighbours(vertex: V): List[V] = adjList.getOrElse(vertex, Nil).map(_.destination)

  def neighboursWeights(vertex: V): List[WeightedEdge[V]] = adjList.getOrElse(vertex, Nil).toList
}
