package leetcode

class FindCenterStarGraph {
    fun findCenter(edges: Array<IntArray>): Int {
        var result = 0
        /**
         * centerNode의 조건은 모든 노드들과 연결되어있는 노드이다.
         * edges의 size -1
         * 등장하는 모든 숫자들을 비교한다면 구할 수 있다.
         * 순회하면서 등장하는 모든 숫자들을 검사한 뒤
         */

        val hashMap = hashMapOf<Int,Int>()

        edges.forEach {
            it.forEach {
                if(hashMap.contains(it)){
                    return it
                } else {
                    hashMap.set(it,1)
                }
            }
        }

        val temp = hashMap.filterValues { it == edges.size - 1 }

        for (i in 0..2) {
            edges[i].forEach {

            }
        }

        return 0
    }
}

fun main() {
    val sol = FindCenterStarGraph()


    println(sol.findCenter(arrayOf(intArrayOf(1,2),intArrayOf(2,3), intArrayOf(4,2))))
}


/**
트리는 1부터 n까지의 그레프이다. 센터에 해당하는 노드가 하나 있다.
센ㄴ터 노드는 모든 노드들과 연결되어 있는 노드이다. 이 노드를 구하여라
edge들의 배열이 주어진다.
 */