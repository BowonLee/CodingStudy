package leetcode

/**
 * 이진탐색의 정의는 해당 조건을 만족하는 가장 적은 경우의 수를 찾을 수 있다?..
 */
class MinDaysBouquets {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        val dayList = bloomDay.distinct().sorted().filter { it >= m*k }

        if(bloomDay.size < m*k) {
            return -1
        } else if (bloomDay.size == m*k) {
            return bloomDay.max()
        }

        println(dayList)

        for (i in dayList.indices) {
            var adjacentCount = 0
            var bouquetCount = 0
            for (j in bloomDay.indices ) {
                if(bloomDay[j] <= dayList[i]) {
                    adjacentCount++
                } else {
                    adjacentCount = 0
                    continue
                }

                if(adjacentCount == k) {
                    adjacentCount = 0
                    bouquetCount++
                }

                if(bouquetCount == m) {
                    return dayList[i]
                }
            }
        }

        return -1
    }
}

fun main() {
    val sol = MinDaysBouquets()
    println(sol.minDays(intArrayOf(7,7,7,7,12,7,7), 2,3))
}

/**
m : 만들고 싶은 부케의 수
k : 필요한 인접한 꽃의 개수
array[i] : 꽃이 피는 날

부케를 만들 수 있는날의 개수, 없으면 -1


 */