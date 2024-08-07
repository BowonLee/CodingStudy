package leetcode

/**
 * 앞뒤가 똑같은 문자열 찾기
 *
 * */

fun main () {
    val temp = LongestPalindromicSubstring5()
    temp.longestPalindrome("cbbd")
}
class LongestPalindromicSubstring5 {
    fun longestPalindrome(s: String): String {

        var result = "";

        (0..s.length).forEach {
            val target = s.substring(it, s.lastIndex)
            val temp = logic(target)
            if(result.length < temp.length) {
                result = temp
            }
        }


        return result
    }

    /**
     * 앞으로 한칸씩 전진
     * 바로 뒤 부터 끝까지 검사
     * */
   private fun logic(s: String): String {
        var result = "";
        (0 until s.length).forEach {
            val target = s.substring(it, s.lastIndex)
            if(isPalindromic(target)) {
                if(result.length < target.length) {
                    result = target
                }
            }
        }

        return result
    }

    private fun isPalindromic(target: String) : Boolean {
        return if(target.length % 2 == 0) {
            val front = target.substring(0..target.lastIndex/2)
            val back = target.substring(target.lastIndex/2 +1.. target.lastIndex)

            front.reversed() == back
        } else {
            val front = target.substring(0 until target.lastIndex/2)
            val back = target.substring(target.lastIndex/2 +1.. target.lastIndex)

            front.reversed() == back
        }
    }
}

/**
 * 앞으로 한칸씩 전진
 * n번째 문자열까지 Palindromic 인지 확인
 *
 * instant stack 을 구성 <- n의 시간이 걸리는 부분은 동일
 *
 * 검사해야하는 문자열이 짝수인 경우
 * 절반을 나누어 앞 뒤를 구분
 *
 * 검새해야하는 문자열이 홀수인 경우
 * 절반을 제외하고 비교
 *
 * */