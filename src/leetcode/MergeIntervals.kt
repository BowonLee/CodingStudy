package leetcode

import kotlin.math.max

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        var result = mutableListOf<IntArray>()

        intervals.sortBy { it[0] }
        for (i in intervals.indices) {
            if(result.isEmpty()) {
                result.add(intervals[i])
                continue
            }

            if(intervals[i][0] < result.last()[1]) {
                result.last()[1] = max(result.last()[1], intervals[i][1])
            } else {
                result.add(intervals[i])
            }
        }

        /**
         * 시작과 종료를 기준으로 둔다
         * 다음 시작 시간이 이전 종료시간 이전이라면 병합대상이다.
         * 병합대상이 선정되는 경우
         *
         */


        return result.toTypedArray()
    }
}


/**
시작정보와 종료정보가 묶인 interval의 배열이 주어진다.
겹치는 모든 인터벌을 합쳐라
 [1,3] , [2,5] - > [1,5]

정렬되어있는지는 명시되지 않음
시작시간을 기준으로 정렬되어있다고 한다면 순차적 병합이 가능함
비정렬을 기준으로 한다면


 */