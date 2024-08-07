package leetcode

class CountNumberNiceSubarrays {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        val countMap = mutableMapOf<Int, Int>()
        var result = 0
        var oddCount = 0

        // 초기 상태
        countMap[0] = 1

        for (num in nums) {
            // 홀수 개수 누적
            if (num % 2 != 0) {
                oddCount++
            }

            // 현재 홀수 개수에서 k를 뺀 값이 이전에 존재했는지 확인
            result += countMap.getOrDefault(oddCount - k, 0)

            println(result)
            // 현재 홀수 개수를 해시맵에 추가
            countMap[oddCount] = countMap.getOrDefault(oddCount, 0) + 1
        }

        println(countMap)

        return result
    }


}

fun main() {
    val sol = CountNumberNiceSubarrays()
    println(sol.numberOfSubarrays(intArrayOf(2,2,2,1,2,2,1,2,2,2), 2))
    println(sol.numberOfSubarrays(intArrayOf(2,2,2,1,2,2,1,2,2), 2))
    println(sol.numberOfSubarrays(intArrayOf(1,1,1,1,1), 1))
}

/**
nums  : 기준 비열
k : 홀수의 수
k개 만큼의 홀수를 가지는 연속된 부분배열의 수를 구하여라
50,000 배열최대길이 숫자가 인간적이긴 하다. 시간복잡도가 망가질 수 있음
2,2,2,1,2,2,1,2,2,2 - 2
0,0,0,1,1,1,2,2,2,2 <- 누적합 배열

0 3
1 3
2 4

5 4
2 + 1

16 -> 11

1,1,2,1,1 3

모든 부분 배열의 수를 구하는 시간 복잡도

나이스한 서브 배열의 수를 구하여라
 가능한 모든 부분 배열을 돌아야 한다. 고유값은 인덱스로 친다. 값의 중복은 넘어간다.
 혹은, 홀수를 가지는 모든인덱스를 구한다면
 나머지수는 전부 무시할 수 있다? ->이게 더 어려울까

 */