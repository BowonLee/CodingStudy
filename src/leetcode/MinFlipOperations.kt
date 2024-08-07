package leetcode

class MinFlipOperations {
    fun minOperations(nums: IntArray): Int {
        var result = 0
        var pivit = 0

        nums.forEach {
            if(it == pivit) {
                result++
                if(pivit == 0) {
                    pivit = 1
                } else {
                    pivit = 0
                }
            }
        }

        return result
    }
}

fun main() {
    val sol = MinFlipOperations()

    println(sol.minOperations(intArrayOf(0,1,1,0,1)))
    println(sol.minOperations(intArrayOf(1,0,0,0)))
}

/**
2진수를 의미하는 배열을 받는다.
플립 연산을 수행할 수 있음
특정 인덱스 뒤의 모든 인자를 뒤집는 행위를 플립이라고 함
모든 요소를 1로 만드는 최소 연산 개수를 구하여라

0이 보일 때마다 뒤집으면 가능하긴 할탠데 실제로 뒤집으면서 가면 무조건 시간조과
뒤집힌다는 의미는 이전과 다른 인자라는 의미
최조의 0을 기준으로 직전과 다른 인자가 보이면 전부 카운팅

 nums는1 ~ 10의 5승
 */