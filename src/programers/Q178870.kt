package programers

class Q178870 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()

        var left = 0
        var right = 0
        var sum = sequence[0]

        while (true) {
            if(sum == k) {
                if(answer.isNotEmpty()) {
                    if(right - left < (answer[1] - answer[0])) {
                        answer = intArrayOf(left,right)
                    }
                } else {
                    answer = intArrayOf(left, right)
                }
            }
            if(sum < k) {
                right++
                if(right>sequence.lastIndex) break
                sum+=sequence[right]
            } else {
                sum-=sequence[left]
                left++
                if(left>sequence.lastIndex) break
            }
        }
        return answer
    }

    fun sum(sequence: IntArray, start: Int, end: Int) : Int{
        var sum = 0
        for (i in start .. end) {
            sum += sequence[i]
        }
        return sum
    }
}
fun main() {
    val solution = Q178870()

//    println(solution.solution(intArrayOf(1, 2, 3, 4, 5), 7).toList())
    println(solution.solution(intArrayOf(1, 1, 1, 2, 3, 4, 5), 5).toList())
//    println(solution.solution(intArrayOf(2, 2, 2, 2, 2), 6).toList())

}
/**
 * 연속된 합이 k 인 부분집합
 * 1. 가능하다면 가장 짧을 것
 * 2. 길이가 동일하면 더 앞에 있을 것
 */