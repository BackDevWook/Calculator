package lv3;

import org.w3c.dom.ls.LSOutput;

public enum Operators {

    // 사칙연산에 사용할 열거형과 메서드
    ADD('+') {
        public <T extends Number> T add(T a, T b) {
            return add(a, b);
        }
    },
    SUBSTRACT('-') {
        public <T extends Number> T subtract(T a, T b) {
            return subtract(a, b);
        }
    },
    MULTIPLE('*') {
        public <T extends Number> T multiply(T a, T b) {
            return multiply(a, b);
        }
    },
    DIVIDE('/') {
        public <T extends Number> T divide(T a, T b) {
            return divide(a, b);
        }
    };

    // 인스턴스 변수
    private final char operator;

    // 생성자
    Operators(char oper) {
        this.operator = oper;
    }

    // 연산자 게터
    public char getOperator() {
        return operator;
    }


    /* 사칙연산 메서드

    ※ 공통규칙
    실수 + 실수, 실수 + 정수로 입력받았다면 실수로 계산한 뒤 리턴
    정수 + 정수로 입력받았다면 정수로 계산한 뒤 리턴
     */

    // 더하기
    public <T extends Number> T add(T num1, T num2) {
        if(num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf((Integer) num1 + (Integer) num2);
        } else {
            return (T) Double.valueOf((Double) num1 + (Double) num2);
        }
    }

    // 빼기
    public <T extends Number> T subtract(T num1, T num2) {
        if(num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf((Integer) num1 - (Integer) num2);
        } else {
            return (T) Double.valueOf((Double) num1 - (Double) num2);
        }
    }

    // 곱하기
    public <T extends Number> T multiply(T num1, T num2) {
        if(num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf((Integer) num1 * (Integer) num2);
        } else {
            return (T) Double.valueOf((Double) num1 * (Double) num2);
        }
    }

    // 나누기
    public <T extends Number> T divide(T num1, T num2) {
        if(num2.doubleValue() == 0) {
            throw new NumberFormatException("0으로 나눌 수 없습니다."); // 두 번째 숫자가 0일 경우 에러처리
        }
        if(num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf((Integer) num1 / (Integer) num2);
        } else {
            return (T) Double.valueOf((Double) num1 / (Double) num2);
        }
    }
}
