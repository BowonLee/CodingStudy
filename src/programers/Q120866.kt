package programers

class Q120866 {
    fun solution(board: Array<IntArray>): Int {
        var answer: Int = 0
        val shadowBoard = board.map { it.clone() }.toTypedArray()
        val directions = arrayOf(intArrayOf(1,0), intArrayOf(1,1), intArrayOf(0,1), intArrayOf(-1,1),
            intArrayOf(-1,0), intArrayOf(-1,-1), intArrayOf(0,-1), intArrayOf(1,-1))

        board.forEachIndexed { indexY, row ->
            row.forEachIndexed { indexX, i ->
                if(i == 1) {
                    directions.forEach {
                        val x = indexX + it[0]
                        val y = indexY + it[1]
                        if(isEnable(x,y,board)) {
                            shadowBoard[y][x] = 1
                        }
                    }
                }
            }
        }

        shadowBoard.forEach {
            it.forEach {
                if(it == 0) {
                    answer++
                }
            }
        }
        return answer
    }

    // 0~index 까지
    /**
     * x와 y가 모두 0보다 크며 각각 인덱스보다 작은가
     */
    fun isEnable(x: Int, y:Int, board: Array<IntArray>): Boolean {
        return x >= 0 && y >= 0 && x <=board[0].lastIndex  && y<= board.lastIndex
    }
}

fun main () {
    val sol = Q120866()
    println(sol.solution(arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )))
}

// 안전지대 확인
// 지뢰 1 아니면 0
// 안전한 지역의 칸 수 반환
// 지뢰를 중심으로 상하좌우 대각 모든 방위는 위험지대