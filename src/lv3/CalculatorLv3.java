package lv3;

import java.util.List;
import java.util.ArrayList;

public class CalculatorLv3 {

    // 계산 결과를 저장할 리스트
    private List<Number> resultList = new ArrayList<>();

    // 계산 결과 값 게터
    public <T extends Number> T getResult(int idx) {
        return (T) resultList.get(idx);
    }

    // 세터
    public void setResult(Number result) {
        resultList.add(result);
    }

    // 연산 기록 삭제
    public void removeResult() {
        resultList.remove(0);
    }

    // parseNumber 메서드를 통해 입력받은 수를 알맞은 타입으로 변환
    public static double parseNumber(String numStr) {
        return Double.valueOf(numStr); // 입력받은 수 모두 실수 형태로 반환
    }


}
