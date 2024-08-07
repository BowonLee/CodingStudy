package leetcode

import kotlin.math.floor

class SuccessfulPairsSpellsPotions {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {

        val result = IntArray(spells.size)
        potions.sort()

        for (i in spells.indices) {

            var left = 0
            var right = potions.lastIndex

            while (left <= right) {
                var mid = (left + right)/2
                if(potions[mid] * spells[i].toLong() >= success) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }

            result[i] = potions.size - left

        }

        /**
         * spell * potion <= success 를 만족하는 최초의 값을 찾는다. 그 값 부터는 전부 가능하다고 치나?
         * 1 2 3 3 5 / 3
         * 3 6 9 9 15 - 9
         * 탐색의 시간이 n이기에 n^2이 된다.
         *
         * 이진탐색의 구현이 필요하다.
         * 중간값을 기준으로 간다. 해당 값이
         *
         */

        println(result.toList())
        return result
    }
}
fun main() {
    val sol = SuccessfulPairsSpellsPotions()
    println(sol.successfulPairs(intArrayOf(5,1,3), intArrayOf(1,2,3,4,5), 7))
    println(sol.successfulPairs(intArrayOf(3,1,2), intArrayOf(8,5,8), 14))
    println(sol.successfulPairs(intArrayOf(1,2,3), intArrayOf(8,5,8), 16))
}
/**
 *  potion = success/spell
    spell 과 potion 두가지의 배열과 성공요구치를 받는다.
    순서대로 스펠을 사용한다. 성공하려면 곱이 해당 수치를 넘겨야 한다.
    개별 시도마다 넘어간 배열을 반환하여라
    시간 복잡도 해결이 필요 n^2이면 실패
    spell의 순서는 지켜야 하지만 potion의 순서는 지킬 필요 없다.
    작은 수는 셀 필요가 없다. 큰 수만 계산하면 된다.
    success부터 하나씩 증가시켜볼까.
 5,1,3

 1,2,3,4,5
 5 10 15 20 25

 */