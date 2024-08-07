package leetcode

    import java.util.SortedMap
    import java.util.TreeMap

class ReplaceWords648 {
    fun replaceWords(dictionary: List<String>, sentence: String): String {

        val cacheMap: SortedMap<String, String> = TreeMap()
        val sortedDictionary = dictionary.sortedBy { it.length }

        return sentence.split(' ').map {word ->
            val isCached = cacheMap.contains(word)
            if(isCached) {
                return@map cacheMap.get(word)!!
            } else {
                sortedDictionary.forEach { root ->
                    if(root.length > word.length) {
                        return@map word
                    } else {
                        if (word.take(root.length) == root) {
                            cacheMap.set(word,root)
                            return@map root
                        }
                    }
                }
                word
            }
        }.joinToString(" ")

    }


}

fun main() {
    val sol = ReplaceWords648()
    println(sol.replaceWords(listOf("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"))
}
/**
 * 문장을 사전의 단어들을 사용해서 압축하여라
 * 각 문장은 최대 100자
 * 사전의 크기는 1000까지
 * sentence는 10^6 의 길이
 * 더 짧은 root로 변경
 *
 * 흠 sentence의 단어들으
 * 정직하게 한다고 하면
 * 100 * 1000
 *
 *
 */


// dictionary 가 주어진다.
// 해당 단어들은 root에 속함
// 문장이 주어지면 문장에 속한 단어들을 확인하여 행심어로
// 핵심어는 특정 단어의 앞에 속하는 단어
//