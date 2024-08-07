package programers;

public class Q17682 {
    public int solution(String dartResult) {
        int answer = 0;

        int tempResult = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            if(isDigit(dartResult.charAt(i))) {

                if(isDigit(dartResult.charAt(i+1))) {
//                    tempResult = dartResult.
                }
                tempResult = dartResult.charAt(i);

            }

            /**
             *  일단 문자 하나씩 잘라가면서 비교
             *  숫자면 바로 다음 숫자까지 비교 후 숫자면 인덱스 증가 후 함해서 숫자로 파싱 후 임시 계산
             *  그 다음 문자열 보일 시 임시 계산 결과에 반영
             *  특수문자 나오면 * 은 합산 후 * 2
             *  # 은 임시 계산 결과만 - 후 합산
             */
        }


        return answer;
    }

    public boolean isDigit(char word) {

        return false;
    }

}
