package backjun

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 백준 1058
 */
class Solution1058 {
    fun solution(arr: Array<String>): Int {
        var result = 0;

        /**
         * 1 친구 : 해당 row에서 Y인 친구
         * 2 친구 : 1친구의 Y인 친구
         */

        (0 .. arr.lastIndex).forEach { my ->
            val friendSet = mutableSetOf<Int>()
            arr[my].forEachIndexed { first, c ->
                // 1 친구 검색
                if(c == 'Y') {
                    friendSet.add(first)
                    arr[first].forEachIndexed{ second, yn ->
                        if(yn == 'Y') {
                            if(second != my) {
                                friendSet.add(second)
                            }
                        }
                    }
                }
            }
            if(friendSet.size>result) {
                result = friendSet.size
            }
        }


        return  result
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`)))  {
    val sol = Solution1058()

    val inputCount = readLine().toInt()

    val arr = Array<String>(inputCount) { "" }

    for(i in 0 until inputCount) {
        val input = readLine()
        arr[i] = input
    }

    print(sol.solution(arr))
}