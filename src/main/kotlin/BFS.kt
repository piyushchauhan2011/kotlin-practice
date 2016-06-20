import java.util.*

/**
Graph
9 7
0 1
1 2
1 3
2 3
3 4
6 7
6 8

Result
u: 0 and [Node(color=BLACK, distance=0, parent=-1), Node(color=BLACK, distance=1, parent=1), Node(color=BLACK, distance=2, parent=2), Node(color=BLACK, distance=2, parent=3), Node(color=BLACK, distance=3, parent=4)]
u: 6 and [Node(color=BLACK, distance=0, parent=-1), Node(color=BLACK, distance=1, parent=7), Node(color=BLACK, distance=1, parent=8)]
u: 5 and [Node(color=BLACK, distance=0, parent=-1)]
 */

data class Node(var color: Color, var distance: Int = Int.MAX_VALUE, var parent: Int = -1);

var nodes: MutableList<Node> = mutableListOf()

fun bfs(u: Int) {
    val queue = mutableListOf<Int>()
//    val tmp: MutableList<Node> = Collections.nCopies(10, Node(Color.WHITE))
    nodes[u].distance = 0
    queue.add(u)

    while(!queue.isEmpty()) {
        val current = queue.removeAt(0)
        if(nodes[current].color == Color.WHITE) {
            nodes[current].color = Color.BLACK
            adj[current].forEach {
                if (nodes[it.first].distance == Int.MAX_VALUE) {
                    nodes[it.first].distance = nodes[current].distance + it.second
                    nodes[it.first].parent = it.first
                    queue.add(it.first)
                }
            }
        }
    }

    val visitedNodes = nodes.filter { it.color == Color.BLACK }
    println("u: $u and $visitedNodes")
}

fun main(args: Array<String>) {
    var tmp = sc.readLine()
    val (v, e) = tmp.split(" ").map { it.toInt() }

    (0..v-1).forEach { nodes.add(Node(Color.WHITE)) }
    (0..v-1).forEach { adj.add(mutableListOf()) }

    (0..v-1).forEach { nodes[it] = Node(Color.WHITE) }
    (0..e-1).forEach {
        tmp = sc.readLine()
        val (tv, tw) = tmp.split(" ").map { it.toInt() }
        adj[tv].add(Pair(tw, 1))
        adj[tw].add(Pair(tv, 1))
    }

    bfs(0)
    nodes = mutableListOf()
    (0..v-1).forEach { nodes.add(Node(Color.WHITE)) }
    bfs(6)
    nodes = mutableListOf()
    (0..v-1).forEach { nodes.add(Node(Color.WHITE)) }
    bfs(5)
}