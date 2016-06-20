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
Component 1 0 1 2 3 4
Component 2 5
Component 3 6 7 8
There are 3 connected components
 */

import java.io.BufferedReader
import java.io.InputStreamReader

var vert: MutableList<Color> = mutableListOf()
var adj: MutableList<MutableList<Pair<Int, Int>>> = mutableListOf()

val sc = BufferedReader(InputStreamReader(System.`in`))

enum class Color {
    BLACK, WHITE
}

fun dfs(u: Int) {
    vert[u] = Color.BLACK
    print(" $u")
    (0..adj[u].size-1).forEach {
        val tv = adj[u][it]
        if(vert[tv.first] == Color.WHITE) dfs(tv.first)
    }
}

fun main(args: Array<String>) {
    var tmp = sc.readLine()
    var (v, e) = tmp.split(" ").map { it.toInt() }

    (0..v-1).forEach { vert.add(Color.WHITE) }
    (0..v-1).forEach { adj.add(mutableListOf()) }

    (0..v-1).forEach { vert[it] = Color.WHITE }
    (0..e-1).forEach {
        tmp = sc.readLine()
        val (tv, tw) = tmp.split(" ").map { it.toInt() }
        adj[tv].add(Pair(tw, 1))
        adj[tw].add(Pair(tv, 1))
    }

    var numComponents = 0
    (0..v-1).forEach {
        if (vert[it] == Color.WHITE) {
            print("Component ${++numComponents}")
            dfs(it)
            println()
        }
    }
    println("There are $numComponents connected components")
}
