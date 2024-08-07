package leetcode

import java.util.Stack

class GetDirections {
    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {

        var result = ""

        // find start or dest
        // find another
        // must
        var startNode = root
        var startDest = false
        while (true) {
            if(root==null) {continue}
            if(startNode!!.`val` == startValue) {
                break
            } else if (startNode!!.`val` == destValue) {
                startDest = true
                break
            }
        }

        var stack = Stack<Int>()
        while (true) {


        }



        /**
         * root가 null
         */

        if(startDest) {
            result = result.reversed()
        }
        return result
    }
}



/**
이진트리의 루트가 주어짐 각가의 노드는 고유한 정수값을 가진다. 시작값와 목적값을 준다.
두 값 사이의 최단경로를 구하여라
각각 이동할 때마다 L,R,U 를 문자열에 추가한다. 최종 문자열을 반환하여라
이진트리는 딱히 정리되지는 않았다.
시작노드와 종료노드의 위치는 모른다.

전위순회든 후위순회든 중위순회든 어느쪽이던 돌리면 찾기는 찾는다. 어디있는지 모르니 찾기는 뭘로 돌리던 차이는 없다.

1. 순회를 돌려 시작 노드를 찾는다. 전위로
2. 시작 노드에서 종료 노드를 찾는다?. 전부 돌리면서 찾는건 비효율적 2N의 시간이 걸릴 수 있음

1. root를 기준으로 시작 노드, 종료 노드의 위치를 찾아야 한다. N
2. 시작 노드를 기준으로 종료노드를 찾는다. N

종료노드 찾는 과정
1. 전위순회 방식으로 찾는다. 좌 , 우, 부모

1. 문자열을 차례대로 넣고, 만약 자신을 2번 보는 경우 전부 지운다.

반환을 통해 부모로 올라갈 방법이 있어야 한다.



 */