package leetcode

import kotlin.math.max
import kotlin.math.min

class MaxSatisfiedBookStore {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        var result = 0

        /**
         * customers 의 배열만큼 이동한다
         * minute만큼 미리 계산한다.
         * miteue만큼 0으로 할 시 이득을 볼 수 있는 값을 들고 있는다
         *
         * n분동안 추가로 만족하는 사람들의 수
         */

        // 만족하는 사람의 수
        var satisfiedCount = 0
        // 추가로 만족하는 사람의 수
        var extraCount = 0


        for (i in customers.indices) {
            var tempExtraCount = 0

            for (j in i .. min(customers.lastIndex, i+minutes-1)) {
                if(grumpy[j] == 1) {
                    tempExtraCount += customers[j]
                }
            }

            extraCount = max(tempExtraCount, extraCount)

            if(grumpy[i] == 0) {
                satisfiedCount+=customers[i]
            }
        }

        println(satisfiedCount)
        println(extraCount)

        return satisfiedCount + extraCount
    }
}

fun main() {
    val sol = MaxSatisfiedBookStore()

    println(sol.maxSatisfied(intArrayOf(1,0,1,2,1,1,7,5), intArrayOf(0,1,0,1,0,1,0,1), 3))
    println(sol.maxSatisfied(intArrayOf(2,6,6,9), intArrayOf(0,0,1,1), 1))
}
/**
n분동안 열림
손님배열 배열의 요소는 입장인원

2 6 6 9
0 0 1 1
1

2 + 6 + (9)
17
8 + 9
주인이 만족스러운 시간의 합
 */