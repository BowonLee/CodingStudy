package programers

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

class Solution181187pr {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        for(i in 1 .. r2) {
            // 큰 원의 좌표에서 작은 원의 좌표를 뺀다.
            // 작은 원에 속한 점들은 모두 뺀다.
            // 좌표는 앞으로간다.
            // 큰 원은 버리고 작은 원은 올린다.
            // 직각 삼각혐 한쪽은 i, 빗변은 r1, r2, 나머지 변의 길이
            // x^2 + i^2 = r^2
            // x = sqrt( r^2 - i^2 )

            val outerCircleCount = floor(sqrt((1.0*r2 * r2 - 1.0*i*i))).toLong()
            val innerCircleCount = ceil(sqrt((1.0*r1 * r1 - 1.0*i*i))).toLong()

            println("$outerCircleCount $innerCircleCount")

            answer+= outerCircleCount-innerCircleCount + 1


        }

        return answer * 4
    }
}

fun main() {
    val sol = Solution181187pr()
    println(sol.solution(2,3))
//    println(sol.solution(1,1000000))
}

/**
 * 두 원 사이에 존제하는 모든 정수 좌표의 수
 * 모든 방위에 대한 계산 필요
 * 한 방위만 계산 후 4배를 곱하면 된다. 즉 한쪽 방위만 계산한다.
 * 원 안에 포함 될 수 있는 좌표를 구하는 공식을 구해보자
 * 2중 루프는 시간초과 발생 한번만 돌려야 함
 *
 */