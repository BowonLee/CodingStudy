package leetcode
 class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
     }
class BinarySearchTreeToGreaterSumTree {

    var currentSum = 0
    fun bstToGst(root: TreeNode?): TreeNode? {

        if(root == null) {return null}

        bstToGst(root.right)

        currentSum += root.`val`

        root.`val` = currentSum

        bstToGst(root.left)

        return root
    }
}
/**
 * 자신보다 큰 값을 자신에게 더해야 한다.
 * 오른쪽은 자신보다 큰 값 왼쪽은 자신보다 작은 값이다.
 * 자신의 오른쪽항 중 가장 왼쪽항이 자신의 직전값이다.
 * 오른쪽 먼저 이동한다면
 * 1. 오른쪽이 있다면오른쪽으로 이동한다. 더 이상 없다면 끝.
 * 2. 왼쪽이 있다면 왼쪽으로 이동한다. 왼쪽의 값은
 *
 * 왼쪽부터 이동하는 경우의 수 <- 2번 돌아야 함 왼쪽값들은 오른쪽 값의 영향을 받아야 한다.
 *
 * 오른쪽 이동 후 왼쪽 이동은 맞음
 * 오른쪽 이동 후 반환값을 받는다. 왼쪾으로 이동 시 그 자신 + 오른쪽항의 값 을 인쪽항에 더한다.
 *
 * 오른쪽 값을 자신에게 더한 뒤 왼쪽의 값을 자신 + 왼쪽으로 한다.
 * 자신의 오른쪽으로 순회할 시
 *
 *                5
 *          3           9
 *     1       4    7      11
 *
 *
 *             32
 *
 *      39            20 (9 + 11)
 *   40      36     27    11
 *                  (9 + 11 + 7)
 */

/**
 * 이진 탐색 트리가 구조와 root가 주어진다. 이 트리는 불완전 이진 트리이다.
 * 이걸 변경해야 한다. 각 노드는 자신보다 같거나 큰 모든 값들의 합이다
 * [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 시작 노드가 주어진다 끝까지 순회할 수 있다.
 * 이진 트리이기 떄문에 제귀순회를 고쳐야 한다.
 * 후위순회 알고리즘을 구성하여야 한다.
 * 후위순회를 하면서 본인을 바꾸고 계속 전달해야 한다.
 *
 */