package lv3;

import java.util.Scanner;

public class CalculatorLv3Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 수식을 입력받을 스캐너 객체 선언
        CalculatorLv3 calculatorLv3 = new CalculatorLv3(); // 연산을 도와줄 클래스 호울
        InputOutput IO = new InputOutput(calculatorLv3); // 입출력을 도와줄 클래스 호출

        int operIdx = -1; // 연산자 위치 인덱스
        char operator = 0; // 연산자 초기화 변수
        int count = 0; // 연산 횟수 카운팅

        IO.welcome();

        while (true) { // 계산기는 항상 실행
            operIdx = -1;
            operator = 0; // 반복 실행시 연산자와 인덱스 초기화

            try { // 예외가 발생하면 계산기 다시 실행
                String formula = sc.nextLine(); // 수식 입력받을 곳

                // 연산자 위치 찾기
                operator = calculatorLv3.findOperator(formula);
                operIdx = calculatorLv3.findOperIdx(formula);

                // 계산기 종료하기
                if (formula.equals("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                }

                // 연산 기록 삭제
                if (formula.equals("del")) {
                    if(count <= 0) { // 계산 기록이 없을 경우 계산기 다시 실행
                        System.out.println("삭제할 기록이 없습니다.");
                        continue;
                    }
                    calculatorLv3.removeResultFirst(); // 첫번째 연산 기록 삭제 메서드
                    count--; // 삭제할 때마다 연산 카운팅 1 감소
                    IO.historyDisplay(); // 계산 기록 출력 메서드
                    continue; // 연산 삭제 실행 후 계산기 다시 실행
                }


                // 연산자를 기준으로 수 나누기
                double number1 = Double.parseDouble(formula.substring(0, operIdx).trim()); // 첫 번째 수 입력
                double number2 = Double.parseDouble(formula.substring(operIdx + 1).trim()); // 두 번째 수 입력

                double result = 0; // 연산 결과 변수 선언

                // 입력받은 수와 연산자를 enum에 반화하여 연산
                Operators oper = Operators.getOperators(operator); // Operators enum 에 연산자 반환
                if (oper != null) {
                    result = oper.calculate(number1, number2);
                }

                // 계산 결과 출력 및 계산 기록 리스트에 저장
                IO.resultDisplayAndSave(result);

            } catch (NumberFormatException e) {
                System.out.println("잘못된 수식입니다. 다시 입력하세요.");
                continue;
            }

            count++; // 연산이 끝나면 연산 횟수 1 증가

            // 계산 기록 출력
            IO.historyDisplay();

        } // while 코드블럭

        sc.close(); // 스캐너 객체 닫기
    }
}
