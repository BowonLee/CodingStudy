package programers

import kotlin.math.ceil
import kotlin.math.sqrt

class Q120846 {
    fun solution(n: Int): Int {
        var answer: Int = 0

        val arr = Array(n){true}


        for(i in 2..sqrt(n.toFloat()).toInt()) {
            if(arr[i-1]) {
                for(j in i*2 .. n step i) {
                    arr[j-1] = false
                }
            }
        }

        println(arr.toList())

        return arr.count { !it }
    }
}

fun main() {
    val sol = Q120846()
    println(sol.solution(10))
    println(sol.solution(15))
}

/**
 * 함성수 찾기 = 소수 찾은 다음 빼기
 */