package leetcode

import kotlin.math.max

/***
 * 극대값에 유의하여야 했다.
 * 반복되는 증감패턴은 그래프로 표현 가능하여 이 그래프의 변곡점이 일치하는 부분을 찾아야 한다.
 */
class Q525 {
    fun findMaxLength(nums: IntArray): Int {
        var maxLength = 0

        var prefix = 0

        val hashMap = HashMap<Int,Int>()

        hashMap.set(0,-1)

        nums.forEachIndexed { index, i ->


            if(i == 0) {
                prefix += 1
            } else {
                prefix -= 1
            }

            if(hashMap.contains(prefix)) {
                maxLength = max(maxLength, index - hashMap.get(prefix)!!)
                println("$index $prefix ${hashMap.get(prefix)} ${index - hashMap.get(prefix)!!}")
            } else {
                hashMap.set(prefix, index)
            }
        }

//        if(prefix == 0) {
//           maxLength = nums.size
//        }


        return maxLength
    }
}

fun main() {
    val temp = Q525()
//    println(temp.findMaxLength(intArrayOf(0,1)))
    println(temp.findMaxLength(intArrayOf(0,1,0,1)))
    println()
    println(temp.findMaxLength(intArrayOf(0,1,1)))
//    println(temp.findMaxLength(intArrayOf(0,0,1,0,0,0,1,1)))
//    println(temp.findMaxLength(intArrayOf(0,1,0,1,0,0)))
//    println(temp.findMaxLength(intArrayOf(0,1,0)))
}
/**
 * 0,1 로 구성된 배열이 주어진다.
 * 0과 1의 숫자가 같은 가장 긴 부분배열을 찾아라
 */