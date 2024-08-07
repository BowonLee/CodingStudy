package leetcode

import kotlin.math.floor

class MinimumPushes {
    fun minimumPushes(word: String): Int {
        var result = 0
        val hashMap = hashMapOf<Char,Int>()

        word.forEach {

            if(hashMap.contains(it)) {
                hashMap[it] = hashMap[it]!! + 1
            } else {
                hashMap[it] = 1
            }
        }

        println(hashMap.values.sorted())

        hashMap.values.sortedDescending().forEachIndexed { index, count ->
            result += count * (index/8 + 1)
        }


        return result
    }
}

fun main() {
    val sol = MinimumPushes()
    println(sol.minimumPushes("aabbccddeeffgghhiiiiii"))
}
/**
단어를 받는다.
휴대전화 기반과 대응하는 문자가 있다. 메핑을 어떻게 할 것이지는 자유롭게 하나, 중간에 바꿀 수는 없다.
대응되는 문자는 고정 몇번 누르는지에 따라 알파벳이 결정
2~9 사이에만 매핑이 가능함 총 8개
주어진 단어를 찾는 가장 적은 경우의 수
몇번 누르는지 구하여라
매핑은 자유
적게 누르기 위해서는 자주 등장하는 문자들이 앞에 있는편이 좋다.
각 단어 별 등장 횟수를 기록하자. -> n 타임 소모
알파벳의 개수는 어짜피 정해져있다.


 1. 각 알파벳 별 등장 횟수를 기록한다.
 2. 등장한 횟수가 많은 순서대로 나열한다.
 3. 8개 단위로 하나씩 더 눌러야 한다.
 */