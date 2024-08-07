package leetcode

class SortArray {
    fun sortArray(nums: IntArray): IntArray {
        logic(nums, 0 , nums.lastIndex)
        return nums
    }

    fun logic(nums: IntArray, left: Int, right: Int) {

        if(left >= right) {
            return
        }
        println("${nums.toList()} $left $right")

//        if(nums[left] > nums[right]) {
//            val temp = nums[left]
//            nums[left] = nums[right]
//            nums[right] = temp
//        }

        val pivot = (left + right) /2



        logic(nums, left, pivot)
        logic(nums, pivot+1, right)

    }
}

fun main() {
    val sol = SortArray()
    println(sol.sortArray(intArrayOf(5,1,1,2,0,0)))
}

/**
 * 내장함수 쓰지 말고 정렬, 시간, 공간 복잡도를 적게 사용할 것 nLogn 으로 해결하여라
 * 중복값있고 정렬되지 않음
 * 퀵소트나 머지소트 사용하면 해결이 가능하려나
 */

/**
 * 퀵소트 알고리즘
 * 중앙을 피벗으로 설정한다.
 * 왼쪽과 오른쪽을 비교했을 때 우변이 좌변보다 크면 두 원소의 위치를 바꾼다.
 *
 */