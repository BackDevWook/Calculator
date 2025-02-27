package lv3;

import java.util.Scanner;

public class CalculatorLv3Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 수식을 입력받을 스캐너 객체 선언

        int operIdx = -1; // 연산자 위치 인덱스
        char operator = 0; // 연산자 초기화 변수
        int operCount = 0; // 연산자 갯수 카운팅 변수 -> 2개 이상일 경우 에러처리


        while (true) { // 계산기는 항상 실행
            operIdx = -1;
            operator = 0; // 반복 실행시 연산자와 인덱스 초기화

            String formula = sc.nextLine().trim(); // 수식 입력받을 곳


            // 연산자 위치 찾기
            for (int i = 0; i < formula.length(); i++) {
                Character findoper = formula.charAt(i);
                if(findoper.equals('+') || findoper.equals('-') || findoper.equals('*') || findoper.equals('/')) {
                    operator = findoper;
                    operCount++;
                    operIdx = i;
                    break; // 연산자를 찾았으면 반복문 빠져나가기
                }
            }

            // 연산자를 기준으로 수 나누기
            double number1 = CalculatorLv3.parseNumber(formula.substring(0, operIdx).trim()); // 첫 번째 수 입력
            double number2 = CalculatorLv3.parseNumber(formula.substring(operIdx+1).trim()); // 두 번째 수 입력

            double result = 0; // 연산 결과 변수 선언

            // 입력받은 수와 연산자를 enum에 반화하여 연산
            Operators oper = Operators.getOperators(operator); // Operators enum 에 연산자 반환
            if (oper != null) {
                result = oper.calculate(number1, number2);
                } else {
                System.out.println("연산자가 존재하지 않습니다.");
            }

            // 소수점이 있으면 실수로, 없으면 정수 형태로 결과값 출력
            if (result % 1 != 0) {
                System.out.println("계산 결과 : " + result);
            } else {
                System.out.println("계산 결과 : " + (int) result);
            }

        }

    }
}
