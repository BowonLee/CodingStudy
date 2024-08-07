package leetcode

class Q15ThreeSum {
    val result = mutableListOf<List<Int>>()
    fun threeSum(nums: IntArray): List<List<Int>> {


        nums.forEachIndexed { originIndex, i ->
            logic(nums.filterIndexed { index, i -> index != originIndex  }, listOf(i))
        }

        return result
    }

    private fun logic(baseList: List<Int>, sumList: List<Int>)  {
        if(sumList.size == 3) {
            if(sumList.sum() == 0) {
                result.add(sumList)
            }
            return
        }
        if(baseList.isEmpty()) {
            return
        }

        baseList.forEachIndexed { originIndex, i ->
            val temp = baseList.filterIndexed { index, i -> index != originIndex  }
            val tempSumList = mutableListOf(i)
            tempSumList.addAll(sumList)
            logic(temp, tempSumList)
        }
        // 3개의 합이
    }
}

fun main () {
    val temp =Q15ThreeSum()
    print(temp.threeSum(intArrayOf(-1,0,1,2,-1,-4)))
}