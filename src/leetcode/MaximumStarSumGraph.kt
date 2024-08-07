package leetcode

import java.util.SortedSet
import java.util.TreeSet
import kotlin.contracts.contract
import kotlin.math.max

class MaximumStarSumGraph {
    fun maxStarSum(vals: IntArray, edges: Array<IntArray>, k: Int): Int {
        var result = Int.MIN_VALUE
        val centerNodeArray = Array(vals.size) { mutableListOf<Int>() }

        edges.forEach {
            if(vals[it[1]] > 0) {
                centerNodeArray[it[0]].add(vals[it[1]])
            }
            if(vals[it[0]] > 0) {
                centerNodeArray[it[1]].add(vals[it[0]])
            }
        }

        centerNodeArray.forEachIndexed { index, ints ->
            ints.sortDescending()
            result = max(result, vals[index] + ints.take(k).sum())
            println("${vals[index]} ${ints}")
        }

        result = max(result, vals.max())

        return result
    }
}

fun main() {
    val sol = MaximumStarSumGraph()
    //[0,1],[1,2],[1,3],[3,4],[3,5],[3,6]
    println(sol.maxStarSum(intArrayOf(1,2,3,4,10,-10,-20), arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(1,3),intArrayOf(3,4),intArrayOf(3,5),
        intArrayOf(3,6)
    ),2))

    println(sol.maxStarSum(intArrayOf(1,-8,0), arrayOf(intArrayOf(1,0), intArrayOf(2,1)),2))

    println(sol.maxStarSum(intArrayOf(17,49,-34,-17,-7,-23,24), arrayOf(
        intArrayOf(3, 1),
        intArrayOf(5, 1),
        intArrayOf(0, 3),
        intArrayOf(4, 6),
        intArrayOf(1, 4),
        intArrayOf(3, 4),
        intArrayOf(6, 3),
        intArrayOf(2, 6),
        intArrayOf(5, 2),
        intArrayOf(1, 6),
        intArrayOf(6, 0),
        intArrayOf(2, 3),
        intArrayOf(3, 5),
        intArrayOf(2, 1),
        intArrayOf(0, 2),
        intArrayOf(5, 0),
        intArrayOf(0, 4)
    ),6))
}
/**
 * 최대 k개 이다. 즉 간선이 k-1, k-2일때도 검사해야 함
 * 각각의 노드가 가질 수 있는 최대값을 따져가며 검사한다.
 *
 */


/**
 * 비정형 그래프 n개의 노드, 0 ~ n-1의 번호를 가진 그래프
 * val는 노드들의 값, 연결정보 edges
 * 성형 그래프 가장 큰 합을 가질 수 있는 그래프
 * k개의 엣지를 가진 그래프 중 가장 큰 합을 가지는 그래프를 구하라
 */

/**
 * 1. 그래프의 구성을 먼저 할 수 있어야 한다.
 * map을 이용해서 특정 노드를 중심을 하는 노드들을 구할 수 있을까
 * 특정노드를 중심으로 하는 노드들을 구성할 수 있다.
 *
 * 그 중 가장 큰 순서대로 k개만 선정할 수 있으면 된다.
 * O(n)
 * nLogn
 *
 */