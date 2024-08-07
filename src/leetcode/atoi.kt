package leetcode

class SolutionAtoi {
    fun myAtoi(s: String): Int {

        val originStr = s.trim()

        var sign = 1
        var isStarted = false
        var result = 0

        originStr.forEach {
            println(result)
            if(isStarted) {
                if(it == '+' || it == '-' ) {
                    return result * sign
                }
                if(!it.isDigit()) {
                    return result * sign
                } else {
                    if(sign == 1) {
                        if(Int.MAX_VALUE/10 < result || (Int.MAX_VALUE/10 == result && Int.MAX_VALUE%10 <= Character.getNumericValue(it))) {
                            return Int.MAX_VALUE
                        } else {
                            result = result * 10 + Character.getNumericValue(it)
                        }
                    } else {
                        if((Int.MIN_VALUE/10 * -1) < result || ((Int.MIN_VALUE/10 * - 1)== result && Int.MIN_VALUE%10* -1 <= Character.getNumericValue(it))) {
                            return Int.MIN_VALUE
                        } else {
                            result = result * 10 + Character.getNumericValue(it)
                        }
                    }



                }
            } else {
                if(it == '-' ) {
                    sign = -1
                    isStarted = true
                } else if (it == '+') {
                    isStarted = true
                } else if(it.isDigit()) {
                    result = Character.getNumericValue(it)
                    isStarted = true
                } else if(it == ' ' || it == '.') {
                    return result
                } else {
                    return result
                }

            }
        }

        return result * sign

    }
}

fun main() {
    val solution = SolutionAtoi()
//    println(solution.myAtoi("    -42-"))
//    println(solution.myAtoi("___-42"))
//    println(solution.myAtoi("42  and word"))
//    println(solution.myAtoi("words and 987"))
    println(solution.myAtoi("-21474836482"))
}