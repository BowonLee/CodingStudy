package leetcode

class LetterCombinations {
    val resultList = mutableListOf<String>()
    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()
        val mappingArray = arrayOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")


        if(digits.isEmpty()){
            return resultList
        }

        logic(mappingArray, digits, 0, "")
        return resultList
    }

    fun logic(mappingArray: Array<String>, digits: String, cursor:Int, word: String) {
        if(cursor > digits.lastIndex) {
            resultList.add(word)
            return
        }

        mappingArray[digits[cursor].digitToInt() - 2].forEach {
            logic(mappingArray, digits, cursor + 1, word + it.toString())
        }
    }
}

fun main() {
    val sol = LetterCombinations()
    println(sol.letterCombinations("23"))
    println(sol.letterCombinations(""))
    println(sol.letterCombinations("2"))

}
/**
2~9 사이의 기판이 있다.
숫자가 주어진 경우 가능한 모든 조합을 반환하여라
 n중 반복을 하면 되는건가.
 2(abc) 3(def) 4(ghi)
 a b c
 a * b * c * d
 adg aeh afi adg aeh afi adg aeh afi
 adg adh adi aeg aeh aei afg afh afi

 발생 가능한 모든 경우를 체크해야 한다. 앞에서부터 차례대로 값을 집어넣는다.
 발생 가능한 모든 조합을 동적으로 체크한다.

 1. digit를 확인한 뒤 해당 배열에 대한 순회가 필요하다.
 */