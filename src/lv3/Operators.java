package lv3;

import org.w3c.dom.ls.LSOutput;

public enum Operators {

    // 사칙연산에 사용할 열거형과 메서드
    ADD('+') {
        public double calculate(double num1, double num2) {
            return add(num1, num2);
        }
    },
    SUBSTRACT('-') {
        public double calculate(double num1, double num2) {
            return subtract(num1, num2);
        }
    },
    MULTIPLE('*') {
        public double calculate(double num1, double num2) {
            return multiply(num1, num2);
        }
    },
    DIVIDE('/') {
        public double calculate(double num1, double num2) {
            return divide(num1, num2);
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

    정수 + 정수로 입력받았다면 정수로 계산한 뒤 리턴
     */

    // 더하기
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    // 빼기
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // 곱하기
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // 나누기
    public double divide(double num1,double num2) {
        if (num2 == 0) {
            throw new NumberFormatException("0으로 나눌 수 없습니다."); // 두 번째 숫자가 0일 경우 에러처리
        }
        return num1 / num2;
    }

    public abstract double calculate(double a,double b); // 열거형의 calculate 메서드를 사용하기 위해 추상 메서드를 선언

    // Runner에서 받은 연산자를 enum에 반환
    public static Operators getOperators(char operator) {
        for (Operators oper : Operators.values()) { // 열거된 연산자들
            if (oper.getOperator() == operator) { //
                return oper;
            }
        }
        return null; // 연산자가 없을 경우 null 반환
    }
}
