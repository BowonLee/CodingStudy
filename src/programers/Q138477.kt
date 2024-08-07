package programers

class Q138477 {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer = IntArray(score.size)


        val hallOfFame = mutableListOf<Int>()

        score.forEachIndexed { index, i ->
            hallOfFame.add(i)

            if(hallOfFame.size > k) {
                hallOfFame.remove(hallOfFame.min())
            }

            answer[index] = hallOfFame.min()

        }

        return answer
    }
}

fun main() {
    val sol = Q138477()
    println(sol.solution(3, intArrayOf(10, 100, 20, 150, 1, 100, 200)).toList())
//    println(sol.solution(4, intArrayOf(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000)).toList())
}
/**
 * score가 순차적으로 들어오며 항상 들어온 값 중 가장 상위의 k가지 항목만 저장
 * 매일매일의 가장 마지막 순위의 배열을 출력
 * 중복이 허용되어야 한다.
 */