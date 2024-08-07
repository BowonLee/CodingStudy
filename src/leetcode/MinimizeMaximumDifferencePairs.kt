package leetcode

import java.util.SortedMap

class MinimizeMaximumDifferencePairs {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        if(p==0) {return 0}
        nums.sort()
        val diffMap:SortedMap<Int,MutableList<List<Int>>> = sortedMapOf() // diff, listOf IndexPair
        val usedMap = Array(nums.size, {false})
        for (i in 1..nums.lastIndex-1) {
            val preDiff = nums[i] - nums[i-1]
            val postDiff = nums[i+1] - nums[i]

            if(diffMap.contains(preDiff)) {
                diffMap.get(preDiff)?.add(listOf(i,i-1))
            } else {
                diffMap.set(preDiff, mutableListOf(listOf(i,i-1)))
            }

            if(diffMap.contains(postDiff)) {
                diffMap.get(postDiff)?.add(listOf(i,i-1))
            } else {
                diffMap.set(postDiff, mutableListOf(listOf(i,i-1)))
            }
        }

        diffMap.keys.forEach{
            val list = diffMap.get(it)!!

            list.forEach {
                if(usedMap[it[0]] || usedMap[it[1]]) {

                }
            }

        }



        return 0
    }
}
fun main() {
    val sol = MinimizeMaximumDifferencePairs()
    println(sol.minimizeMax(intArrayOf(4,2,1,2),1))
    println(sol.minimizeMax(intArrayOf(10,1,2,7,1,3),2))
    println(sol.minimizeMax(intArrayOf(3,4,2,3,2,1,2),3))
    println(sol.minimizeMax(intArrayOf(3,3,5,1,0,5,6,6),4))
}
/**
배열과 숫자가 주어짐 nums에서 p만큼의 페어를 찾아라??
페어는 가장 큰 차이가 발생하는 숫자??
페어 사이의 차이는 절대값
최소 차이가 발생하는 쌍을 구하라는건가
p = 2
0  1 2 3 4 5
10,1,2,7,1,3

특정 인자를 기준으로 하는 경우 가장 앞과 가장 뒤를 제외하면 자신의 좌, 우 모두 빼야한다.

   최소 차이 = 0 , 1
   p 만큼의 페어를 만든다.
  페어는 두 원소의 차이가 최소가 되도록 한다.
  원소는 중복사용될 수 없다.
  이렇게 구한 차이 중 최소를 구하라
  원소는 중복될 수 있다.
  인덱스를 신경쓰지 않고 값만 비교한다.

 우선 정렬부터 시키고
 두 인자 사이의 차이가 가장 적은 것들만 고른다. -> O n
 인자 차이가 적은
1 3 5 7 9 ..... 2n-1


10,1,2,7,1,3
 1 1 2 3 7 10
 0 1 1 4 3
 인덱스 하나를 고르면 다음 인덱스는 넘기고 다음 인덱스로 가야한다.
 0 2 4 2*ㅔ

 p = 2 -> 1
 p = 3 -> 4
 */