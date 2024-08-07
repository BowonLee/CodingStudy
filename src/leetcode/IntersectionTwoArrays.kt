package leetcode

class IntersectionTwoArrays {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        var resultList = mutableListOf<Int>()
        var cursor = 0
        while (cursor < nums1.lastIndex) {
            if(nums2.contains(nums1[cursor])) {
                val tempList = mutableListOf(nums1[cursor])
                var cursorMove = 1
                for (j in cursor+1..nums2.lastIndex) {
                    if(nums1[j] == nums2[j]) {
                        tempList.add(nums2[j])
                        cursorMove++
                    } else {
                        break
                    }
                }
                cursor+=cursorMove
                if(tempList.size > resultList.size) {
                    resultList = tempList
                }
            } else {
                cursor++
            }
        }

        println(resultList)
        return resultList.toIntArray()
    }
}

fun main() {
    val sol = IntersectionTwoArrays()
    println(sol.intersect(intArrayOf(1,2,2,1), intArrayOf(2,2)))
    println(sol.intersect(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)))
}


/**
두개의 배열이 주어집니다. 두 배열의 공통섹션을 구하시오 겹쳐도 순서는 상관 없습니다.
반환값은 무조건 존제합니다.
4,9,5  9,4,9,8,4
4,9 혹은 9,4
 각 배열의 크기는 1~1000까지, 내부 값의 크기도 동일함, 순서는 정렬되지 않았으며 중복 가능
 어떤 배열이 더 클지는 모름

 한쪽을 기준으로 다른 한쪽을 검사할 수 있다. 이 경우 1,000 * 1,000인 n제곱이 발생
  nums1을 기준으로 하나씩 검사해야 하나 연속된 배열을 검사해야 한다면

 어느쪽이던 한번만 보면 되긴 한다.


 1. 한쪽을 기준으로 하여 요소 중 단일 숫자가 다른쪽에서 등장하는지 확인한다.
 2. 특정한 숫자가 등장한다면 다음 숫자도 동일하게 검사한다.

 1. 한쪽을 기준으로하여 반복을 시작한다.
 2. 해당 숫자가 다음 행렬에서 등장한다면 그 다음 숫자를 포함한 행렬이 등장하는지 확인한다.
 3. 등장하지 않는다면 한칸을 이동하고 등장했다면 이동한 거리만큼 이동한다.

 */