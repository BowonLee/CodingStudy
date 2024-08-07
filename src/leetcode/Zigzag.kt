package leetcode

class Zigzag {
    fun convert(s: String, numRows: Int): String {

        if(numRows == 1) {
            return s
        }
        var result = ""

        for (i in 1 ..  numRows) {
            for(j in i .. s.length step 2 * numRows -2) {
                result += s[j-1]
                print(" $j ")
                if(i != 1 && i != numRows) {
                    if(j + 2 * numRows - i * 2  <= s.length) {
                        result += s[j + 2 * numRows - i * 2 - 1]
                        print(" ${j + 2 * numRows - i * 2} ")
                    }
                }
            }


            println()
        }

        return result;
    }
}

fun main() {
    val temp = Zigzag()
    println(temp.convert("ABCD",3))
}



/**
 * leet 6 zigzag
 * s가 주어진 경우
 * abcdefg 3
 * a   e
 * b d f
 * c   g
 * PAHNAPLSIIGYIR
 * PAHNAPLSIIGYIR
 *
 * PINALSIYAHRPI
 * PINALSIGYAHRPI
 * PINALSIGYAHRPI
 * aebdfcg
 * 배열을 정직하게 순회하면 n제곱이 튀어나올 수 있다. 수식으로 풀면 n으로 풀 수 있을 것 같다.
 * 배열은 아래로 진행한다
 * 수식으로 계산하면 풀리긴 한다.
 *
 * PAHNAPLSIIGYIR
 *
 * ALIGYIRPSI
 */