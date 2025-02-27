package lv3;

import java.util.Scanner;

public class CalculatorLv3Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 수식을 입력받을 스캐너 객체 선언

        int operIdx = -1; // 연산자 위치 인덱스
        char operator = 0; // 연산자 초기화 변수
        int operCount = 0; // 연산자 갯수 카운팅 변수 -> 2개 이상일 경우 에러처리


        while (true) { // 계산기는 항상 실행
            operIdx = -1; // 연산자 위치 인덱스
            operator = 0; // 연산자 초기화 변수

            String formula = sc.nextLine().trim(); // 수식 입력받을 곳


            // 연산자 위치 찾기
            for (int i = 0; i < formula.length(); i++) {
                Character findoper = formula.charAt(i);
                if(findoper.equals('+') || findoper.equals('-') || findoper.equals('*') || findoper.equals('/')) {
                    operator = findoper;
                    operCount++;
                    operIdx = i;
                    break;
                }
            }

            // 연산자를 기준으로 수 나누기
            Number number1 = CalculatorLv3.parseNumber(formula.substring(0, operIdx).trim()); // 첫 번째 수 입력
            Number number2 = CalculatorLv3.parseNumber(formula.substring(operIdx+1).trim()); // 두 번째 수 입력

            double result = 0; // 연산 결과 변수 선언

            // 찾은 연산자, 숫자를 Operators enum에 반환하여 계산

            Operators oper = Operators.getOperator(operator);
            if (oper != null) {
                if ((double) oper.calculate(number1, number2) % 1 != 0) { // 나머지가 0이 아니면 실수로 결과값 반환
                    result = (double) oper.calculate(number1, number2);
                    System.out.println("계산 결과 : " + result);
                } else { // 그게 아니면 정수로 결과값 반환
                    double result1 = (double) oper.calculate(number1, number2);
                    result = (int) result1;
                    System.out.println("계산 결과 = " + (int) result);
                }
            }

        }

    }
}
