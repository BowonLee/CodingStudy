class MaximumGain {
    fun maximumGain(s: String, x: Int, y: Int): Int {

        if(!s.contains(Regex("ab|ba"))) {
            return 0
        }

        if(x >= y) {
            val regex = Regex("ab")
            var modifiedString = s
            var matches = regex.findAll(s).toList()
            var unit = x
            var point = 0

            if(matches.isEmpty()) {
                unit = y
                matches = Regex("ba").findAll(s).toList()
            }

            matches.reversed().toList().forEach {
                modifiedString = modifiedString.removeRange(it.range)
                point += unit
            }
            return maximumGain(modifiedString, x,y) + point

        } else {
            val regex = Regex("ba")
            var modifiedString = s
            var matches = regex.findAll(s).toList()
            var point = 0
            var unit = y

            if(matches.isEmpty()) {
                unit = x
                matches = Regex("ab").findAll(s).toList()
            }

            matches.reversed().toList().forEach {
                modifiedString = modifiedString.removeRange(it.range)
                point += unit
            }
            return maximumGain(modifiedString, x,y) + point
        }

        return 0
    }
}

fun main() {
    val sol = MaximumGain()
    println("cdbcbbaaabab".removeRange(0,2))
    println(sol.maximumGain("cdbcbbaaabab", 4,5))
    println(sol.maximumGain("aabbaaxybbaabb", 5,4))
}

/**
ab 문자열을 제가하면 x포인트를 적립
ba 문자열을 제거하면 y포인트를 적립
s에 대해 작업을 수행한 결과 적립되는 최대 포인트를 반환
 1. 더 큰쪽을 우선으로 진행
 2. 가능한 모든 부분 탐색
 */