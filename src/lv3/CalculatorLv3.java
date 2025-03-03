package lv3;

import java.util.List;
import java.util.ArrayList;

public class CalculatorLv3 {

    // 계산 결과를 저장할 리스트
    private List<Double> resultList = new ArrayList<>();

    /* ────────────────────────────────────────────────────────────────────────────────────────────────────────*/
    // 연산

    // 연산자 찾기
    public char findOperator(String formula) {
        for (int i = 1; i < formula.length(); i++) {
            Character operator = formula.charAt(i);
            if(operator.equals('+') || operator.equals('-') || operator.equals('*') || operator.equals('/')) {
                return operator;
            }
        }
        return 0;
    }

    // 연산자 인덱스 찾기
    public int findOperIdx(String formula) {
        for (int i = 1; i < formula.length(); i++) {
            Character operator = formula.charAt(i);
            if(operator.equals('+') || operator.equals('-') || operator.equals('*') || operator.equals('/')) {
                return i;
            }
        }
        return 0;
    }

    /* ────────────────────────────────────────────────────────────────────────────────────────────────────────*/
    // 유틸리티

    // 연산 기록 삭제
    public void removeResultFirst() {
        resultList.removeFirst(); // 첫번째 요소 삭제 메서드
    }

    // 계산 결과 값 세터
    public void setResult(double result) {
        resultList.add(result);
    }

    // 리스트 게터
    public List<Double> getResultList() {
        return resultList;
    }

}
