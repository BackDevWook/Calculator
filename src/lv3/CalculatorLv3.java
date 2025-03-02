package lv3;

import java.util.List;
import java.util.ArrayList;

public class CalculatorLv3 {

    // 계산 결과를 저장할 리스트
    private List<Double> resultList = new ArrayList<>();



    // 수식을 입력받을 메소드
    public String inputFomula(String formula) {
        return formula;
    }

    /* ────────────────────────────────────────────────────────────────────────────────────────────────────────*/
    // 연산

    // parseNumber 메서드를 통해 입력받은 수를 알맞은 타입으로 변환
    public static double parseNumber(String numStr) {
        return Double.valueOf(numStr); // 입력받은 수 모두 실수 형태로 반환
    }

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

    // 계산 결과 값 게터와 세터
    public double getResult(int idx) {
        return resultList.get(idx);
    }
    public void setResult(double result) {
        resultList.add(result);
    }

    // 리스트 게터
    public List<Double> getResultList() {
        return resultList;
    }

}
