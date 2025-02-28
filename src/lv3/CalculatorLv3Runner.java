package lv3;

import java.util.Scanner;

public class CalculatorLv3Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 수식을 입력받을 스캐너 객체 선언
        CalculatorLv3 calculatorLv3 = new CalculatorLv3(); // CalculatorLv3 클래스 호출

        int operIdx = -1; // 연산자 위치 인덱스
        char operator = 0; // 연산자 초기화 변수
        int count = 0; // 연산 횟수 카운팅
        double resultDisplay; // 연산 기록 출력을 위한 변수

        System.out.println("※ 계산기 Lv.2 에 오신 것을 환영합니다.");
        System.out.println("※ exit 타이핑 시 종료됩니다.");
        System.out.println("※ delete 타이핑 시 첫 번째 계산 기록이 삭제됩니다.");
        System.out.println("※ 양수, 음수, 실수까지 지원합니다. (괄호 사용 불가)");
        System.out.println("※ 항은 2개까지 사용 가능합니다.");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("※ 수식을 입력하세요...");

        while (true) { // 계산기는 항상 실행
            operIdx = -1;
            operator = 0; // 반복 실행시 연산자와 인덱스 초기화

            try { // 예외가 발생하면 계산기 다시 실행
                String formula = sc.nextLine().trim(); // 수식 입력받을 곳

                // 연산자 위치 찾기
                for (int i = 1; i < formula.length(); i++) { // 음수 입력도 가능하기 위해 '1'인덱스 부터 탐색
                    Character findoper = formula.charAt(i);
                    if (findoper.equals('+') || findoper.equals('-') || findoper.equals('*') || findoper.equals('/')) {
                        operator = findoper;
                        operIdx = i;
                        break; // 연산자를 찾았으면 반복문 빠져나가기
                    }
                }

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
                    calculatorLv3.removeResult(); // 첫번째 연산 기록 삭제 메서드
                    count--; // 삭제할 때마다 연산 카운팅 1 감소

                    System.out.print("§ 계산 기록 : "); // 삭제 된 연산기록 재출력
                    for (int i = 0; i < count; i++) {
                        resultDisplay = calculatorLv3.getResult(i);
                        if (resultDisplay % 1 == 0) {
                            System.out.print((int) resultDisplay + " ");
                        } else {
                            System.out.print(resultDisplay + " ");
                        }
                    }
                    System.out.println(); // 연산 기록간의 줄바꿈 주기
                    continue; // 연산 삭제 실행 후 계산기 다시 실행
                }


                // 연산자를 기준으로 수 나누기
                double number1 = CalculatorLv3.parseNumber(formula.substring(0, operIdx).trim()); // 첫 번째 수 입력
                double number2 = CalculatorLv3.parseNumber(formula.substring(operIdx + 1).trim()); // 두 번째 수 입력

                double result = 0; // 연산 결과 변수 선언

                // 입력받은 수와 연산자를 enum에 반화하여 연산
                Operators oper = Operators.getOperators(operator); // Operators enum 에 연산자 반환
                if (oper != null) {
                    result = oper.calculate(number1, number2);
                }
                // 소수점이 있으면 실수로, 없으면 정수 형태로 결과값 출력
                if (result % 1 != 0) {
                    System.out.println("§ 계산 결과 : " + result);
                    calculatorLv3.setResult(result);
                } else {
                    System.out.println("§ 계산 결과 : " + (int) result);
                    calculatorLv3.setResult(result);
                }

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("괄호 잘못된 수식입니다. 다시 입력하세요.");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 수식입니다. 다시 입력하세요.");
                continue;
            }

            count++; // 연산이 끝나면 연산 횟수 1 증가
            // 계산 기록 출력
            System.out.print("§ 계산 기록 : ");
            for (int i = 0; i < count; i++) {
                resultDisplay = calculatorLv3.getResult(i);
                if(resultDisplay % 1 == 0) {
                    System.out.print((int) resultDisplay + " ");
                } else {
                    System.out.print(resultDisplay + " ");
                }
            }
            System.out.println(); // 연산 기록간의 줄바꿈 주기
            System.out.println("─────────────────────────────");
        } // while 코드블럭


    }
}
