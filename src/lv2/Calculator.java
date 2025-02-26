package lv2;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<Double> resultsList = new ArrayList<>(); // 연산 결과를 저장할 리스트 생성

    // 사칙연산
    public double sum(int num1, int num2) { // 덧셈
        return num1 + num2;
    }

    public double sub(int num1, int num2) { // 뺄셈
        return num1 - num2;
    }

    public double multiple(int num1, int num2) { // 곱하기
        return num1 * num2;
    }

    public double divide(int num1, int num2) { // 나누기
        return (double) num1 / num2;
    }

    // 결과 값 Getter 와 Setter
    public void setResultsList(double result) { // 결과 값 저장
        this.resultsList.add(result);
    }

    public double getResults(int idx) { // 결과 값 호출
        return this.resultsList.get(idx);
    }

    // 결과값 첫 번째 기록부터 삭제
    public void removeResults() {
        this.resultsList.remove(0);
    }
}



