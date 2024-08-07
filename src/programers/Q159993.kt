package programers

import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

class Q159993 {
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0

        var startCoordinate = Pair(0,0)
        var endCoordinate = Pair(0,0)
        var laborCoordinate = Pair(0,0)

        maps.forEachIndexed { indexY, s ->
            s.forEachIndexed { indexX, c ->
                if(c == 'S') {
                    startCoordinate = Pair(indexX,indexY)
                } else if (c == 'E') {
                    endCoordinate = Pair(indexX,indexY)
                } else if (c == 'L')
                    laborCoordinate = Pair(indexX,indexY)
            }
        }

        println("labor")
        val toLabor = move(maps.clone(), startCoordinate.first, startCoordinate.second ,laborCoordinate.first, laborCoordinate.second)

        println("exit")
        val toExit = move(maps.clone(), laborCoordinate.first, laborCoordinate.second ,endCoordinate.first, endCoordinate.second)

        println(toLabor)
        println(toExit)
        if(toLabor == -1 || toExit == -1) {
            return -1
        } else {
            return toLabor + toExit
        }
    }


    fun move(maps: Array<String>, startX: Int, startY: Int, destX: Int, destY:Int): Int {

        val directions = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0)
        )
        val distanceMap = Array(maps.size) { IntArray(maps.first().length) { 0 } }
        val visited = Array(maps.size) { BooleanArray(maps[0].length) { false } }

        val queue: Queue<Pair<Int,Int>> = LinkedList()
        visited[startY][startX] = true
        distanceMap[startY][startX] = 0
        queue.add(Pair(startX,startY))


        while (queue.isNotEmpty()) {
            val (currentX, currentY) = queue.poll()

            if (currentX == destX && currentY == destY) {
                printArr(distanceMap)
                return distanceMap[currentY][currentX]
            }

            for (direction in directions) {
                val movedX = currentX + direction[0]
                val movedY = currentY + direction[1]

                if (isMoveAble(maps, movedX, movedY) && !visited[movedY][movedX]) {
                    distanceMap[movedY][movedX] = distanceMap[currentY][currentX] + 1
                    queue.add(Pair(movedX, movedY))
                    visited[movedY][movedX] = true
                }
            }
        }
//            // 이미 다녀간 위치 체크
//            val newRow = maps[currentY].toCharArray().apply { this[currentX] = 'X' }.concatToString()
//            maps[currentY] = newRow
//
//            if(currentX == destX && currentY == destY) {
//                val distance = distanceMap[currentY][currentX]
//                printArr(distanceMap)
//                return distance
//            }
//
//            while (directionCount < 4 ){
//                val movedX = currentX + directions[directionCount][0]
//                val movedY = currentY + directions[directionCount][1]
//
//                if(isMoveAble(maps, movedX, movedY)) {
//                    distanceMap[movedY][movedX] = distanceMap[currentY][currentX] + 1
//                    queue.add(Pair(movedX, movedY))
//                }
//
//                directionCount++
//            }


        return -1
        /**
         * bfs 알고리즘
         * 큐에는 해당 지점까지의 최소거리가 항상 있음
         * 모든 가능성을 동일하게 순회하기에 가장 먼저 찾은 좌표가 최단거리이다.
         * 시작지점부터 움직이기 시작
         * 상하좌우 순서대로 순회, 움직일 수 없으면 종료
         * 맵과 동일한 크기를 가진 배열
         *
         * 1. 큐에 시작 좌표를 넣고 시작
         * 2. 큐에 더 이상 남은 좌표가 없을 때 까지 순회
         * 3. 해당 좌표에서 움직일 수 있는지 확인
         * 4. 해당 좌표에서 움직일 수 있는 모든 지점을 큐에 넣는다.
         * 5.
         *
         */


    }

    // 해당 좌표가 가능한지 확인
    fun isMoveAble(maps: Array<String>, x: Int, y: Int): Boolean {

        if(x < 0 || y < 0 || x > maps.lastIndex || y > maps.lastIndex) {
            return false
        } else if (maps[y][x] == 'X') {
            return false
        } else {
            return true
        }
    }

    fun isMoveAble2(maps: Array<String>, x: Int, y: Int): Boolean {
        return x in 0 until maps[0].length && y in 0 until maps.size && maps[y][x] != 'X'
    }

    fun printArr(array: Array<IntArray>) {
        array.forEach {
            println(it.toList())
        }
    }

}

fun main() {
    val sol = Q159993()
    println(sol.solution(arrayOf(
        "SOOOL",
        "XXXXO",
        "OOOOO",
        "OXXXX",
        "OOOOE"
    )))

}

/** S 시작, E 출구 L 레버 O 통로 X 벽
 * S에서 시작해서 L을 거친 뒤 E로 가야 한다
 * 가장 빠르게 가는 경우 걸리는 시간
 * 없으면 -1
 *
 * 문제를 주의깊게 읽자, 직사각형일 수 있다.
 *
*/