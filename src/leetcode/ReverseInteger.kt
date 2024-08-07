package leetcode

import kotlin.math.abs

class ReverseInteger {
    fun reverse(x: Int): Int {
        var result = 0
        var mutableX = x


        while (abs(mutableX)  > 0) {
            if(isOutRange32Int(result)) {
                result = 0;
                break
            }
            result = result * 10 + mutableX % 10
            mutableX /=10


        }

        return result
    }

    /**
     * 최대치를 초과할지 예측해야한다.
     * 어짜피 10을 곱할거니 곱하기 전 숫자 비교 후 1의자리만 추가로 비교한다.
     * 이게 미디엄?...
     * */
    fun isOutRange32Int(num : Int): Boolean {
        if (Int.MAX_VALUE / 10 < num || Int.MIN_VALUE/10 > num) {
            return true;
        }

        return false
    }
}
// 1534236469, 1563847412 and -1563847412
fun main() {
    val temp = ReverseInteger()

    println(temp.reverse(1534236469))
//    println(temp.reverse(-1563847412))

}


/**
 * 32비트 정수 타입으로 표현하라, 범위를 벗어나면 0 반환
 * 10 씩 기준으로
 *
 */