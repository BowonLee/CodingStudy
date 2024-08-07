package leetcode

class ListNode(var `val`: Int) {
         var next: ListNode? = null
 }
class NodesBetweenCriticalPoints {
    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {

        /**
         * 다음 노드의 값만을 알 수 있다.
         * 내가 이전보다 크거나 작고
         *
         * 극점으로 판명되면 해당 값이 최소인 경우 최소에 할당, 최대인경우 최대에 할당한다.
         *
         * 1. 극점을 판명할 수 있어야 한다.
         * 2. 최대극점인지 최소극점인지 판명할 수 있어야 한다.
         *
         * 극댓값의 판명을 위해서는 직전값을 가지고 있어야 한다. 결과값
         * 시작 노드를 기점으로 다음노드 두개를 가지고 판단하면 가능은하다.
         *
         * 다만 결과적으로 선형적인 이동을 끝까지 해야하기에 반드시 재귀로 풀 이유는 없다
         *
         * head에서 시작하여 다음을 조회한다.
         * head의 직전값은 가지고 있는다.
         *
         * 1. 직전과 직후가 있다는 전제하에
         *
         * 1. 마지막까지 움직인다.
         */

        var currentNode = head
        var lastNode: ListNode? = null
        var minCriticalPoint = -1
        var maxCriticalPoint = -1
        while (currentNode!!.next != null) {
            if(currentNode.next?.`val`!! < currentNode.`val` && lastNode!!.`val`!! > currentNode.`val`) {

            }


            currentNode = currentNode.next
        }


        return intArrayOf(-1,-1)
    }

    fun logic(head: ListNode?) {

    }
}

/*
링크드 리스트의 최약점을 찾는다.
취약점이란 로컬의 최소값 혹은 최대값으로 정의한다.
해당 노드가 자신의 이전, 이후보다 크면 극댓값, 작으면 극소값

링크드 리스트를 순회하며 치명점을 찾아라,
[최소임계점, 최대임계점]
2개 이상을 만족하지 못하면  -1,-1을 반환하라

재귀적으로 돌면 n 안쪽으로 반환 가능할 수 있나?
*/

