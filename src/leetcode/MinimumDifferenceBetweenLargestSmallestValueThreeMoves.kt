package leetcode

import kotlin.math.min

class MinimumDifferenceBetweenLargestSmallestValueThreeMoves {
    var diff = 0
    fun minDifference(nums: IntArray): Int {


        if(nums.size<=3) {
            return 0
        }
        nums.sort()
        println(nums.toList())
        var leftCursor = 0
        var rightCursor = nums.lastIndex
        diff = nums[rightCursor] - nums[leftCursor]

        logic(nums, 0, rightCursor,0)

        return diff
    }
    fun logic(nums: IntArray, left: Int, right:Int, count: Int) {
//        println("${nums[right]} ${nums[left]} $diff")
        diff = min(nums[right] - nums[left], diff)
        if(count == 3) {
            return
        }
        val leftDiff = nums[left + 1] - nums[left]
        val rightDiff = nums[right] - nums[right-1]
        logic(nums, left+1, right, count+1)
        logic(nums, left, right-1, count+1)
//        if(leftDiff == rightDiff) {
//
//        } else if(leftDiff > rightDiff){
//            logic(nums, left+1, right, count+1)
//        } else {
//            logic(nums, left, right-1, count+1)
//        }
    }
}

fun main() {
    val sol = MinimumDifferenceBetweenLargestSmallestValueThreeMoves()
    println(sol.minDifference(intArrayOf(5,3,2,4)))
    println(sol.minDifference(intArrayOf(6,6,0,1,1,4,6)))
    println(sol.minDifference(intArrayOf(1,5,6,14,15)))
    println(sol.minDifference(intArrayOf(9,48,92,48,81,31)))
}


/**
한번 움직일때 선택 가능하다.
nums의 값을 다른 인자로 변경 가능하다.

최소한의 차이를 구하여라
최대 3번 변경했을 때 최소한의 차이를 구하여라
최대값과 최소값의 간격이 최소가 되도록 하여라
 nums의 길이는 10의 5승
1,5,6,14,15
  v       v
    v  v

 정렬을 진행할 경우. 최대와 최소는 시작과 끝으로 간다.
 최대 최소를 구하여야 하므로 직전값과의 차이가 큰쪽만 움직인다.
 0 1 1 4 6 6 6 -> 2
   v         v
  차이가 0이다. 그렇다면

 최소/최대값을 기준으로 움직임을 시작한다 총 3회 움직일 수 있다.
 좌,우를 기준으로 하여 차이가 많은 방향을 움직인다.
 만약 좌우의 차이가 같다면 그 다음 차이가 많은 쪽으로 움직인다.
 5 6 14 15 <- 각각 1씩 차이가 난다.
 그냥 무지성으로 검사한디치면 변경 횟수는 3이라 사실 상관없긴 하다. 앞에서 빼던 뒤에서 뺴던


 */