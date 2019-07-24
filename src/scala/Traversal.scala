import scala.collection.immutable.Queue

object Traversal {

  def traversalBFS[V](start: V, graph: Graph[V], f: V => Unit) = {
    Stream.iterate((Queue(start), Set[V](start))) { case (queue, visited) =>
      val (vertex, rest) = queue.dequeue
      val newQueue = rest.enqueue(graph.neighbours(vertex).filterNot(visited.contains))
      val newVisited = graph.neighbours(vertex).toSet ++ visited
      (newQueue, newVisited)
    }
      .takeWhile(t => t._1.nonEmpty).foreach(t => f(t._1.head))
  }

  def traversalDFS[V](start: V, graph: Graph[V], f: V => Unit,
                      visited: Set[V] = Set[V]()): Set[V] = {
    if (visited.contains(start)) visited
    else {
      f(start)
      graph.neighbours(start).foldLeft(visited + start)((allVisited, n) =>
        traversalDFS(n, graph, f, allVisited))
    }
  }


  def traversalDFSAlt[V](start: V, graph: Graph[V], f: V => Unit): Unit = {
    Stream.iterate((List(start), Set[V](start))) { case (stack, visited) =>
      val vertex = stack.head
      val newStack = graph.neighbours(vertex).filterNot(visited.contains) ++ stack.tail
      val newVisited = graph.neighbours(vertex).toSet ++ visited
      (newStack, newVisited)
    }
      .takeWhile(t => t._1.nonEmpty).foreach(t => f(t._1.head))
  }
}
