package programers

import java.util.Stack

class Q176962 {
    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer: Array<String> = arrayOf()
        var completeList= mutableListOf<String>()
        val workStack = Stack<Pair<Int,String>>()
        plans.sortBy { it[1] }

        println(plans.map { it.toList() }.toList())
        var prevTime = "00:00"

        plans.forEachIndexed { index, i ->
            if(workStack.isEmpty()) {
                println("push ${i[0]}")
                workStack.push(Pair(i[2].toInt(),i[0]))
            } else {
                var timePeriod = timeToMinute(i[1]) - timeToMinute(prevTime)
                println("$timePeriod ${i[0]} ${i[2]}")
                var recent = workStack.pop()

                if(timePeriod < recent.first) {
                    // 작업 다 못끝내서 다시 넣어야 함
                    workStack.push(Pair(recent.first-timePeriod,recent.second))

                    while (timePeriod > 0 && workStack.isNotEmpty()) {

                        timePeriod = timeToMinute(i[1]) - timeToMinute(prevTime)
                        if(timePeriod >= recent.first) {
                            timePeriod-=recent.first
                            completeList.add(recent.second)

                        } else {

                            timePeriod = 0
                        }
                    }
                } else {
                    // 작업 다 끝내고 다음 작업도 확인
                    completeList.add(recent.second)
                    timePeriod = timePeriod-recent.first
                    while (timePeriod>0 && workStack.isNotEmpty()) {
                        recent = workStack.pop()
                        if(timePeriod < recent.first ) {
                            workStack.push(Pair(recent.first - timePeriod,recent.second))
                            timePeriod = 0
                        } else {
                            completeList.add(recent.second)
                            timePeriod-=recent.first
                        }
                    }
                }
                workStack.push(Pair(i[2].toInt(),i[0]))
            }
            prevTime = i[1]
        }

        while (workStack.isNotEmpty()) {
            completeList.add(workStack.pop().second)
        }

        return completeList.toTypedArray()

    }

    fun timeToMinute(timeStr:String):Int {
        val tempArr = timeStr.split(":").map { it.toInt() }
        return tempArr[0] * 60 + tempArr[1]
    }
}

fun main() {
    val sol = Q176962()

    println(sol.solution(arrayOf(arrayOf("korean", "11:40", "30")
        ,arrayOf("english", "12:10", "20"),arrayOf("math", "12:30", "40"))).toList())

}

// [["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]

/**
 * 1. 배열을 시간 순으로 정렬 한다.
 * 2. 새로운 인자가 들어오는 경우 직전 시간과의 차이인 사이 시간을 구한다
 * 3. 사이 시간만큼 이전 작업들을 수행한다.
 * *. plans가 빈 경우 순서대로 pop 한다
 */
// 배열은 시간 순으로 정렬되어 있지 않음
// 시작 시간이 되면 시작
// 기존 작업은 중단
// 끝나면 가장 직전에 멈춘 것 부터 시작
// name, 시작, 소요시간
// 과제가 끝난 순서대로
// 스택 구조 활용 시간에 따라 가장 최근에 들어온 작업을 먼저 처리한 후 직전 작업 수행