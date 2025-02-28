package lv1;

import java.util.Scanner;

public class CalculatorLevelOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 스캐너 객체 추가

        char operator = 0; // 연산자로 다시 초기화할 예정
        int idx = -1; // 연산자의 인덱스
        boolean isInteger = true; // 기본 결과값은 정수로 설정
        int operCount = 0; // 연산자 갯수 카운팅 변수 -> 2개 이상일 경우 에러처리

        System.out.println("계산기 Lv.1 에 오신 것을 환영합니다.");
        System.out.println("exit 타이핑 시 종료됩니다.");
        System.out.println("수식을 입력하세요... (항은 2개까지 지원합니다. ex: 43+25)"); // 수식 입력 알리는 신호


        while (true) { // 계산기는 항상 실행

            // 반복 실행시 초기값 초기화
            operator = 0;
            idx = -1;

            String formula = sc.nextLine().trim(); // 수식을 입력받는 변수, trim으로 입력시 앞 뒤 공백 제거

            if (formula.equalsIgnoreCase("exit")) { // exit 입력시 계산기 종료 (대소문자 무시)
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            // 연산자 찾기
            for (int i = 0; i < formula.length(); i++) {
                Character find = formula.charAt(i); // 한 글자씩 검사하기
                if (find == '+' || find == '-' || find == '*' || find == '/') {
                    operator = find; // 사용할 연산자 초기화
                    idx = i; // 연산자 인덱스 초기화
                    operCount++;
                } else if (!Character.isDigit(find)) { // 숫자가 아닌 녀석이 있는지 찾기
                    idx = -1;
                    break;
                }
            }

            // 연산자가 없거나 잘못된 수식일 경우 처음부터 다시 시작
            if (idx == -1 || operCount >= 2) {
                System.out.println("다시 입력해주세요.");
                continue;
            }

            // 연산자의 인덱스를 기준으로 숫자 나누기
            double num1 = Integer.parseInt(formula.substring(0, idx).trim()); // 0번째 부터 연산자 기호 전까지
            double num2 = Integer.parseInt(formula.substring(idx + 1).trim()); // 연산자 기호 이후부터

            double result = 0; // 결과값 저장할 변수 초기화


            switch (operator) { // 기호에 따른 사칙연산
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
                        continue;
                    } else {
                        result = num1 / num2;
                        isInteger = (num1 % num2 == 0); // 정수인지 실수인지 판별
                    }
                    break;
            }

            if(isInteger) {
                System.out.println("계산 결과 : " + (int) result);
            } else {
                System.out.println("계산 결과 : " + result);
            }

        }
    }
}
