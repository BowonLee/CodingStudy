package programers

class Q135808 {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0

        val sortedList = score.sortedDescending()


        for (i in m-1 until score.size step m){
            answer += sortedList[i] * m
        }

        return answer
    }
}

fun main() {
    val sol = Q135808()
    println(sol.solution(3,4, intArrayOf(1, 2, 3, 1, 2, 3, 1)))
    println(sol.solution(4,3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)))
}

/**
 * k = 최대점수
 * m = 상자당 사과
 * score = 사과 개별 가격
 * 상자에 못들어가면 안판다.
 * 크기순으로 정렬 후 m만큼 잘라서 m번째 곱하기 해당 수
 *
 */