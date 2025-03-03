package lv2;

import java.util.Scanner;

public class CalculatorLv2Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자에게 입력받기 위해 스캐너 객체 생성
        CalculatorLv2 calculator = new CalculatorLv2(); // Calculator 클래스 사용을 위한 객체 생성

        // 초기 세팅
        char operator = 0; // 연산자로 다시 초기화할 예정
        int operatorCnt = 0; // 연산자가 2개 이상 입력되있을 때 오류를 방지할 변수
        int idx = -1; // 연산자의 인덱스
        boolean isInteger = true; // 기본 결과값은 정수로 설정
        int count = 0; // 계산 횟수 카운팅


        System.out.println("계산기 Lv.2 에 오신 것을 환영합니다.");
        System.out.println("exit 타이핑 시 종료됩니다.");
        System.out.println("delete 타이핑 시 첫 번째 계산 기록이 삭제됩니다.");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("수식을 입력하세요... (항은 2개까지 지원합니다. ex: 43+25)"); // 수식 입력 알리는 신호

        while (true) { // 계산기는 항상 실행

            // 반복 실행시 초기화
            operatorCnt = 0;
            operator = 0;
            idx = -1;

            String formula = sc.nextLine().trim(); // 수식을 입력받는 변수, trim으로 입력시 앞 뒤 공백 제거

            if (formula.trim().equalsIgnoreCase("exit")) { // exit 입력시 계산기 종료 (대소문자, 앞 뒤 공백 무시)
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if (formula.trim().equalsIgnoreCase("del")) { // 계산 첫번째 기록부터 삭제 (대소문자, 앞 뒤 공백 무시)
                if (count == 0) { // 기록이 없을 경우 인덱스 범위 초과 에러 방지
                    System.out.println("삭제할 기록이 없습니다.");
                    System.out.println("수식을 입력하세요... (항은 2개까지 지원합니다. ex: 43+25)");
                    continue;
                }
                calculator.removeResults(); // 기록 삭제 메서드
                count--; // 기록 출력을 위한 카운팅 1 감소
                System.out.println("삭제 완료.\n.\n.\n.");

                // 삭제 된 기록 재출력
                System.out.print("계산 기록 : ");
                for (int i = 0; i < count; i++) { // 카운팅 된 계산횟수 만큼 기록 출력
                    if (calculator.getResults(i) % 1 != 0) { // 결과 값이 실수일 경우
                        System.out.print(calculator.getResults(i) + " ");
                    } else { // 정수일 경우
                        System.out.print((int) calculator.getResults(i) + " ");
                    }
                }
                System.out.println(); // 줄바꿈 용
                System.out.println("─────────────────────────");
                System.out.println("수식을 입력하세요... (항은 2개까지 지원합니다. ex: 43+25)");

                continue;
            }

            // 연산자 찾기
            for (int i = 0; i < formula.length(); i++) {
                Character find = formula.charAt(i); // 한 글자씩 검사하기
                if (find == '+' || find == '-' || find == '*' || find == '/') {
                    operator = find; // 사용할 연산자 초기화
                    idx = i; // 연산자 인덱스 초기화
                    operatorCnt++; // 연산자가 2개 이상일 경우 아래에서 오류 처리
                    break;
                } else if (!Character.isDigit(find)) { // 숫자가 아닌 녀석이 있는지 찾기
                    idx = -1;
                }
            }

            // 연산자가 없거나 잘못된 수식일 경우 처음부터 다시 시작
            if (idx == -1 || operatorCnt >= 2) {
                System.out.println("잘못된 수식입니다, 다시 입력해주세요.");
                continue;
            }

            // 연산자의 인덱스를 기준으로 숫자 나누기
            int num1 = Integer.parseInt(formula.substring(0, idx).trim()); // 0번째 부터 연산자 기호 전까지
            int num2 = Integer.parseInt(formula.substring(idx + 1).trim()); // 연산자 기호 이후부터

            double result = 0; // 결과값 저장할 변수 초기화

            switch (operator) { // 연산자에 따른 사칙연산
                case '+':
                    result = calculator.sum(num1, num2);
                    break;
                case '-':
                    result = calculator.sub(num1, num2);
                    break;
                case '*':
                    result = calculator.multiple(num1, num2);
                    break;
                case '/':
                    if (num2 == 0) { // 0으로 나눌 시 계산기 다시 실행
                        System.out.println("0으로 나눌 수 없습니다, 다시 입력하세요.");
                        continue;
                    } else {
                        result = calculator.divide(num1, num2);
                        isInteger = (num1 % num2 == 0); // 정수인지 소수점이 있는지 판별
                    }
                    break;
            }

            if (isInteger) {
                System.out.println("계산 결과 : " + (int) result);
                calculator.setResultsList(result); // 결과 값은 double 인 상태로 저장
            } else {
                System.out.println("계산 결과 : " + result);
                calculator.setResultsList(result);
            }
            count++; // 1회 계산이 완료되면 계산횟수 카운팅

            // 계산 기록 출력
            System.out.print("계산 기록 : ");
            for (int i = 0; i < count; i++) { // 카운팅 된 계산횟수 만큼 기록 출력
                if (calculator.getResults(i) % 1 != 0) { // 결과 값이 실수일 경우
                    System.out.print(calculator.getResults(i) + " ");
                } else { // 정수일 경우
                    System.out.print((int) calculator.getResults(i) + " ");
                }
            }
            System.out.println();
            System.out.println("─────────────────────────"); // 경계선 밑 줄바꿈
            System.out.println("수식을 입력하세요... (항은 2개까지 지원합니다. ex: 43+25)");
        }
        sc.close(); // 스캐너 객체 닫기
    }
}
