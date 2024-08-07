package leetcode

/**
 * O(n) 의 시간만 소모하며 자신을 자신의 위치를 제외하고 모두 곱한 결과를 배열로 구성
 * 나누기는 쓰지 말것
 */
class Q238 {
    fun productExceptSelf(nums: IntArray): IntArray {

        val left = IntArray(nums.size )

        val right = IntArray(nums.size)


        for ( i in 0 .. nums.lastIndex ) {
            if(i == 0) {
                left[i] = nums[i]
                right[i] = nums[nums.lastIndex - i]
            } else {
                left[i] = left[i-1] * nums[i]
                right[i] = right[i-1] * nums[nums.lastIndex -  i]
            }
        }

        right.reverse()

        val tempList = nums.mapIndexed { index, i ->
            if(index == 0) {
                right[index + 1]
            } else if(index == nums.lastIndex) {
                left[index - 1]
            } else {
                left[index - 1 ] * right[index + 1]
            }

        }


        println(tempList)
        return tempList.toIntArray()
    }
}
fun main() {

    val temp = Q238()
    temp.productExceptSelf(intArrayOf(1,2,3,4,5))
    temp.productExceptSelf(intArrayOf(-1,1,0,-3,3))
}