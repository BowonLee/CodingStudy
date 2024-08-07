package programers

class Q120871 {
    fun solution(n: Int): Int {
        var answer: Int = n
        var plus = 0
        var cursor = 1


        while (cursor <= answer + plus) {
            if(cursor%3==0 || cursor.toString().contains("3")) {
                plus++
            }
            cursor++
        }

        println(" [$plus]")
        return n + plus
    }
    fun isThree(n: Int) :Boolean{
        if(n%3==0 || n.toString().contains("3")) {
            print(" $n ")

            return true
        }
        return false

    }
}

fun main() {
    val sol = Q120871()
    (15..15).forEach {
        print("$it  ")
        println(sol.solution(it))    }


}

/**
 * 3의 배수와 3을 건너뛴다.
 * 3의배수만큼 +, 3이 들어가는 만큼 +
 * 늘어나는 만큼 최대치도 늘어남
 *
 * 1 1 (+0)
 * 2 2 (+0)
 * 3 4 (+1)
 * 4 5 (+1)
 * 5 7 (+2)
 * 6 8 (+2)
 * 7 10 (+3)
 * 8 11 (+3)
 * 9 14 (+5)
 * 10 17 (+7)
 *
 */