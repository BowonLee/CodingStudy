package leetcode

import java.util.PriorityQueue

class MinimumIncrementToMakeArrayUnique {
    fun minIncrementForUnique(nums: IntArray): Int {

        var result = 0
        var nextNumber = 0
        var blankNumbers : PriorityQueue<Int> = PriorityQueue<Int>()
        val numberSet : HashSet<Int> = hashSetOf()
        nums.sort()

        // make blankNumbers
        for (i in 1 .. nums.lastIndex) {
            if(nums[i] - nums[i-1] != 1) {
                for(j in nums[i - 1] + 1 .. nums[i] - 1) {
                    blankNumbers.add(j)
                }
            }
        }
        nums.forEach {
            if(numberSet.contains(it)) {
                while (true) {
                    if(blankNumbers.isNotEmpty()) {
                        nextNumber = blankNumbers.poll()
                    } else {
                        if(nums.last() > nextNumber) {
                            nextNumber = nums.last() + 1
                        } else {
                            nextNumber++
                        }
                    }

                    if(nextNumber > it) {
                        numberSet.add(nextNumber)
                        result += nextNumber - it
                        break
                    }
                }
            } else {
                numberSet.add(it)
            }
        }

        return result
    }

    fun minIncrementForUniqueFast(nums: IntArray): Int {
        val frequencies = IntArray(nums.size + nums.max())
        for (num in nums) {
            frequencies[num] = frequencies[num] + 1
        }

        var moves = 0
        for (i in frequencies.indices) {
            val frequency = frequencies[i]
            if (frequency <= 1) continue

            val duplicates = frequencies[i]-1
            frequencies[i+1] += duplicates
            moves += duplicates
        }

        return moves
    }
    /**
     * 해당 배열의 길이 + 가장 큰 배열의 인자 = 최종 배열의 길이? 1,2,2,2,2,2,2 -> 7 + 2 -> 9
     * 우선 배열의 길이만큼은 있어야 한다. 최대값 만큼 더 있어야 할 이유는? 수가 항상 처음부터 시작하지 않기에
     * index -> 해당 수, 인자 -> 등장 빈도
     * 우선 기존 배열의 인자 + 1을 준비시킨다. []
     * 해당 값이 중복되지 않는지를 확인한다.
     * 해당 수가 중복된다면 해당 수의 요소가 이동해야 한다.
     *
     */
}

fun main(){
    val sol = MinimumIncrementToMakeArrayUnique()

    println(sol.minIncrementForUnique(intArrayOf(2,2,2,1)))
    println(sol.minIncrementForUnique(intArrayOf(1,2,2)))
    println(sol.minIncrementForUnique(intArrayOf(4,1,4,30,31,15,31,27,25,24,6,18,13,31,5,5,21,5,3,16,26,19,24,8,9,14,32,23,31,17,18,32,6,25,26,27,24,5,21,30,18,11,31,18,13,20,26,7,0,17)))
}

/**
 * set을 활용하면 쉽게 판단이 가능하긴 하다.
 * 각각의 프로세스가 최소한이면 결론도 최소한이다.
 * 1 2 2 -> 1
 * 3,2,1,2,1,7 -> 1 2 3 7
 *
 * 커서를 찾는다. 최초의 커서는 가장 작은 값이다.
 *
 * 뭐가 먼저 들어오던 최소한 까지만 추가하면 답이 나올 것이다.
 * 해당 수를 전부 set에 집어넣은 뒤 1회 순회한다. 이러면 nlogn
 * 빈 값들에 해당하는 만큼 빼보자
 *
 * 증가할 수 밖에 없으니 다음 값부터 찾아야 한다.
 * 1. 숫자 배열을 우선 정렬시킨다.
 * 2. 비어있는 숫자들의 배열을 생성한다.
 * 3. 비어있는 숫자 배열의 인덱스를 cursor로 정의한다.
 * 4. 정렬된 숫자 배열을 순회하기 시작한다.
 * 5. 등장한 수를 set에 삽입한다.
 * 6. 만약 이미 해당 수가 존제한다면 cursor에 해당하는 수를 가져온다.
 * 7. cursor가 더 크다면 cursor를 하나 증가시키고 이전 cursor의 수를 set에 넣는다. answer에 cursor에서 해당 수를 뺀 값을 추가한다.
 * 8. cursor가 작다면 cursor를 하나 증가시킨다,
 * 9. cursor가 index를 넘어갔다면 최대값으로 치환하여 동일한 작업을 수행한다.
 */



// 정수 배열을 전달 받는다.
// 인덱스를 하나 선택하고 해당 값을 1 증가시킨다.
// 가장 최소한만 증가시켜서 해당 해열에 겹치는 수가 없도록 만드는 경우의 수의 횟수를 구하라
// 개별 항목은 10^5, 배열의 길이도 같다.
// nums는 중복도 있고 정렬되어 있지도 않다.