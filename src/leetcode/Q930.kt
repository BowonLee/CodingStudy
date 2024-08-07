package leetcode

import kotlin.math.sqrt

class Q930 {
//    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
//        var result = 0
//        nums.forEachIndexed { index, i ->
//
//            var sum = 0
//
//            for (j in index .. nums.lastIndex) {
//                sum += nums[j]
//                if(sum == goal) {
//                    result++
//                } else if (sum >goal) {
//                    break;
//                }
//
//            }
//
//        }
//
//        println(result)
//
//        return  result
//    }

    /**
     * 지나가면서 총합들이 발생하는 자릿수를 저장?..
     */
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        val prefixSum2Freqs = mutableMapOf<Int, Int>()
        var totalCount = 0
        var currentSum = 0
        for (num in nums) {
            currentSum += num
            if (currentSum == goal) {
                totalCount++
            }




            if (prefixSum2Freqs.containsKey(currentSum - goal)) {
                totalCount += prefixSum2Freqs[currentSum - goal]!!
            }

            prefixSum2Freqs[currentSum] = prefixSum2Freqs.getOrDefault(currentSum, 0) + 1
        }
        return totalCount
    }
}

/**
 * 부분배열의 함이 목표치가 되는 부분배열의 수를 구하여라
 */

fun main() {
//    val temp = Q930()
//
//    temp.numSubarraysWithSum(intArrayOf(1,0,1,0,1), 2)
//    temp.numSubarraysWithSum(intArrayOf(0,0,0,0,0), 0)
    val temp : Int = 4;
    val temp2 = sqrt(temp.toFloat())


    println(temp2)
    println(temp2)
}