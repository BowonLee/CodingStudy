package programers

import java.util.LinkedList
import java.util.Queue


class Q154538 {
    var minCount = Int.MAX_VALUE
    fun solution(x: Int, y: Int, n: Int): Int {
        if (x==y) return 0

        val queue: Queue<Pair<Int,Int>> = LinkedList()
        val visited = mutableSetOf<Int>(x)

        queue.add(Pair(x,0))

        while (queue.isNotEmpty()) {
            val (current, count) = queue.poll()

            val nextValues = listOf(current * 2, current * 3, current + n)

            for (next in nextValues) {
                if(next == y) {return count + 1}
                if(next < y && !visited.contains(next)) {
                    visited.add(next)
                    queue.add(Pair(next,count + 1))
                }
            }

        }


        return -1
    }



}
// 10 80 10
// 10 * 2 * 2 * 2
// 10 * 2 * 2 40
// x * a = y 한 값이
// y/x = a
// a%2
fun main() {
    val sol = Q154538()

    println(sol.solution(10,40,5))
    println(sol.solution(10,40,30))
}
/**
* x를 y로 만들고싶다.
n을 더하거나
2혹은 3을 곱할 수 있다.
최소 연산횟수를 구하여라
 x에서 2 혹은 3을 곱해서
 10 40 5  -> 2
 10 40 30 -> 1
 3 - > 14
3+2 * 2 10
3*2 + 2 8



*/