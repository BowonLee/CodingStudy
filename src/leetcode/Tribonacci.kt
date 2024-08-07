package leetcode

class Tribonacci {
    fun tribonacci(n: Int): Int {

        return logic(n)
    }

    fun logic(num: Int): Int {

        if(num == 0) {
            return 0
        } else if(num == 1 || num == 2) {
            return 1
        } else if (num == 3) {
            return 2
        } else if (num == 4) {
            return 4
        }

        return logic(num - 1) + logic(num - 2) + logic(num - 3)
    }
    private lateinit var cache: IntArray

    /**
     * 생각하자. 단순한 공식의 경우 미리 값을 계산하는 방식이 더 빠를 수 있다.
     * 에라토네스의 체의 교훈을 잊지 말자.
     */
    fun goodSolution(n:Int): Int {
        if (n < 3) {
            return if (n == 0) 0 else 1
        }

        cache = IntArray(n + 1) { -1 }
        cache[0] = 0
        cache[1] = 1
        cache[2] = 1

        for (i in 3..n) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3]
        }
        return cache[n]
    }
}

fun main() {
    val sol = Tribonacci()
    println(sol.tribonacci(25))
    println(sol.tribonacci(36))
    println(sol.tribonacci(37))
    println(sol.tribonacci(0))
    println(sol.tribonacci(1))
}
/**
 * T(N) = T(N-1) + T(N-2) + T(N-3)
 *
 * T =
 *
 * 1
 *
 *
 * 수의 합이 쌓이는 형태이다.
 */
/**
 * 자신 이전 수 3개의 합을 구하여라
 * n -> 1 ~ 37
 * 0 = 0
 * 1 = 1
 * 2 = 0 + 1
 * 3 = 0 + 1 + 1
 * 4 = 1 + 1 + 2
 * ...
 */