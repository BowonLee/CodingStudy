package programers

class Q120956 {

    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        val enableWords = arrayOf("aya", "ye", "woo", "ma" )

        babbling.forEach {
            if(logic(it, enableWords)) {
                answer++
            }

        }

        return answer
    }

    fun logic(targetWord: String, enableWords: Array<String>) : Boolean {
        if(targetWord.isEmpty()) {
            return true
        }

        enableWords.forEach {
            if(targetWord.length >= it.length && targetWord.slice(0..it.length - 1) == it) {
               return logic(targetWord.slice(it.length..targetWord.length - 1), enableWords)
            }
        }


        return false
    }
}

fun main() {
    val temp = Q120956()
    temp.solution(arrayOf("ayaye", "uuuma", "ye", "yemawoo", "ayaa"));
}
/***
 *
 * 1. 정석정인 방법
 * 그래프를 순회한다
 * 인자로 받은 리스트를 제귀적으로 순회한다.
 * 불가능하면 하나씩 빼면서 진행
 * 문자열을 인자로 받은 뒤 하나씩 비교하면서 들어간다.
 *
 * 2. 이상한 방법
 * 가능한 모든 조합을 찾아놓은 뒤 순회한다.
 */