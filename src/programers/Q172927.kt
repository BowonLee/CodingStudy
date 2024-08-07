package programers

import kotlin.math.ceil

class Q172927 {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0

        val usageArr = Array(minerals.size/5 + 1, { IntArray(3, { 0 }) })

        minerals.forEachIndexed { index, s ->
            if(picks.sum() * 5 < index + 1) {
                return@forEachIndexed
            }

            if(s == "diamond") {
                usageArr[index/5][0] += 1
                usageArr[index/5][1] += 5
                usageArr[index/5][2] += 25
            } else if(s == "iron") {
                usageArr[index/5][0] += 1
                usageArr[index/5][1] += 1
                usageArr[index/5][2] += 5
            } else {
                usageArr[index/5][0] += 1
                usageArr[index/5][1] += 1
                usageArr[index/5][2] += 1
            }
        }
        usageArr.sortByDescending { it[2] }

        usageArr.forEach {
            if(picks[0] > 0) {
                answer += it[0]
                picks[0]--
            } else if(picks[1] > 0) {
                answer += it[1]
                picks[1]--
            } else if(picks[2] > 0) {
                answer += it[2]
                picks[2]--
            }
        }

        return answer
    }
}

fun main() {
    val sol = Q172927()
    println(sol.solution(intArrayOf(1,3,2), arrayOf("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone")))
    println(sol.solution(intArrayOf(0,1,1), arrayOf("diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond")))

    println(sol.solution(intArrayOf(1,0,1), arrayOf("stone", "stone", "stone", "stone", "stone", "iron", "iron", "iron", "iron", "iron", "diamond", "diamond")))
}
// 최소한의 피로도로 광물을 캔다.
// 한번 사용을 시작하면 끝까지 사용한다.
// 광물의 순서는 고정
// 모두 캐거나 모두 소모
// di iron stone