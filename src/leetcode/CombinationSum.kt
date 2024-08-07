package leetcode

import kotlin.math.log

class CombinationSum {
    val resultList = mutableSetOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
//        candidates.forEachIndexed { index, pivot ->
//
//        }
        logic(listOf<Int>(), candidates, 0, target )
        return resultList.toList()
    }

    /**
     *
     * 합산배열의 합이 타겟과 같다면 해당 배열을 결과 배열에 추가한 뒤 탈출시킨다.
     * 만약 합산배열의 합이 더 크다면 그냥 탈출시킨다.
     *
     * 현제 인덱스에 해당하는 항목을 합산 배열에 추가한다.
     * 다음 배열을 하나씪 추가시킨다.
     *
     */
    fun logic(combinationList: List<Int>, candidates : IntArray, index: Int, target: Int) {
        if(combinationList.sum() == target) {
            resultList.add(combinationList)
            // 완성 탈출 조건
            return
        } else if(combinationList.sum() > target) {
            // 미완성 탈출
            return
        }

        for (i in index .. candidates.lastIndex) {
            val newList = combinationList.toMutableList()
            newList.add(candidates[i])
            logic(newList, candidates, i, target)
        }
    }
}

fun main() {
    val sol = CombinationSum()
    println(sol.combinationSum(intArrayOf(2,3,6,7), 7))
}
/***
 * 공백이 없는 정수 배열와 타겟 지점
 * 더해서 타겟이 되는 중복 없는 결합 리스트를 반환하여라
 * 모든 요소는 여러번 사용될 수 있다.
 *
 * 모든 경우의 수를 찾는 완전탐색이 필요하다.
 *
 * 앞에서부터 절반까지만 가면 되나?... n^2
 * 2, 3, 4   10
 * 2 2 2 2 2
 * 2 2 2 2 3
 * 2 2 2 3
 * 2 2 3 3 o
 * 2 2 3 4 x
 * 2 2 4
 * ...
 *
 * candidates.length < 40, target.length < 40
 * 1. 처음부터 순서대로 순회 시작
 * 2. 본인을 기준으로 다음에 등장하는 모든 요소를 0 ~ 한계치까지 넣어본다.
 *
 * 본인이 1~ 끝까지 가는 경우의 수 에서
 * 재귀적으로 뒤의 모든 항목이 동일하게
 *
 * 제귀식으로 가는 경우
 *
 * 반복문으로 가는 경우
 */
