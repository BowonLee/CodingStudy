package leetcode

class MatchPlayersAndTrainers {
    fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        var result = 0
        players.sort()
        trainers.sort()

        /**
         * 양측 모두 정렬 해 놓는다.
         * 이 후 플레이어와 같거나 크면 cursor를 이동시킨다음 넘어간다.
         */

        var cursor = 0
        for(i in players.indices) {
            while (cursor <= trainers.lastIndex) {
                if(players[i] <= trainers[cursor]) {
                    result++
                    cursor++
                    break
                } else {
                    cursor++
                }
            }
        }


        return result
    }
}



/**
단일 인덱스의 배열을 전달 받음, 값은 능력치 , 트레이너 역량
걱 풀래아어는 트레이너와 매칭되며 역량은 능력보다 좋아야 함
트레이너는 한번만 사용됨
매칭 가능한 최대한의 경우의 수를 구하시오
 */