package leetcode

class TeemoAttack {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        var result = 0

        timeSeries.sort()

        for (i in 1..timeSeries.lastIndex) {
            var diff = timeSeries[i] - timeSeries[i-1]
            if(diff > duration) {
                result += duration
            } else {
                result += diff
            }
        }

        result += duration

        return result
    }
}

/**
duration만큼 중독
중독시간 전에 다시 공격 시 중독시간 갱신

공격받은 시간의 배열

중독된 모든 시간을 구하라
 */