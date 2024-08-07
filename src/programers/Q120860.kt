package programers

import kotlin.math.abs

class Q120860 {
    fun solution(dots: Array<IntArray>): Int {
        var answer: Int = 0
        var x = 0
        var y = 0
        /**
         * x의 좌표가 달라지는 경우 차이의 절대값
         * y의 좌표가 달라지는 경우 차이의 절대값
         *
         */
        for (i in 1..dots.lastIndex) {
            if(dots[i][0] != dots[i-1][0]) {
                x = abs(dots[i][0] - dots[i-1][0])
            }

            if(dots[i][1] != dots[i-1][1]) {
                y = abs(dots[i][0] - dots[i-1][0])
            }
        }

        return x*y
    }
}

/**
 * 2차평면 기준으로 직사각형의 좌표 - 기울임은 없음
 * 넓이를 구하여라
 * [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
 * 대각이 아닌 좌표을의 차이만큼
 * [[1, 1], [2, 1], [2, 2], [1, 2]]
 * [[-1, -1], [1, 1], [1, -1], [-1, 1]]
 */
