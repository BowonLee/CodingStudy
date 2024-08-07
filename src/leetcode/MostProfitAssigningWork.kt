package leetcode

import java.util.TreeMap

class MostProfitAssigningWork {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        var result = 0


        val workArray = Array<Pair<Int,Int>>(difficulty.size,{Pair(0,0)})
        for (i in difficulty.indices) {
            workArray[i] = Pair(profit[i],difficulty[i])
        }
        workArray.sortByDescending { it.first }
        for (i in worker.indices) {

            for (j in workArray.indices) {
                if(workArray[j].second <= worker[i]) {
                    result += workArray[j].first
                    break
                }
            }
        }

        return result
    }
}
/**
    n 개의 일과 m개의 업무가 있다. 각각의 업무는 난이도가 있다.
    난이도와 보상은 다른 배열의 같은 위치의 원소이다.
    작업자는 자신의 능력 안의 일만 수행 가능하다.
    작업자는 하나의 일만 해야 한다. 일은 중복 수행 가능하다
    가장 큰 보상을 받을 수 있는 경우의 수를 구하여라
 */

fun main() {
    val sol = MostProfitAssigningWork()
    println(sol.maxProfitAssignment(intArrayOf(2,4,6,8,10), intArrayOf(10,20,30,40,50), intArrayOf(4,5,6,7)))
}