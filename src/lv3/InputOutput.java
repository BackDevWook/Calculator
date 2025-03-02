package lv3;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class InputOutput {
    CalculatorLv3 calculatorLv3; // 출력에 필요한 기능을 사용하기 위해 계산기lv3 객체 생성
    private double resultHistory; // 계산 기록 출력을 도와줄 변수

    // 생성자
    InputOutput(CalculatorLv3 calculatorLv3) {
        this.calculatorLv3 = calculatorLv3;
    }

    // 계산기 실행시 유의사항 및 환영인사
    public void welcome() {
        System.out.println("※ 계산기 Lv.2 에 오신 것을 환영합니다.");
        System.out.println("※ exit 타이핑 시 종료됩니다.");
        System.out.println("※ delete 타이핑 시 첫 번째 계산 기록이 삭제됩니다.");
        System.out.println("※ 양수, 음수, 실수까지 지원합니다. (괄호 사용 불가)");
        System.out.println("※ 항은 2개까지 사용 가능합니다.");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("※ 수식을 입력하세요...");
    }

    // 연산 결과 출력 및 기록 저장
    public void resultDisplayAndSave(double result) {
        // 결과 값이 실수일 경우 실수로, 아닐 경우 정수 형태로 출력
        DecimalFormat realNumResult = new DecimalFormat("#.###"); // 소수 셋째 자리까지 출력
        if (result % 1 != 0) { // 나머지가 0이 아닐 경우 --> 실수
            System.out.println("§ 계산 결과 : " + realNumResult.format(result));
            calculatorLv3.setResult(result);
        } else { // 실수가 아니라면 정수
            System.out.println("§ 계산 결과 : " + (int) result);
            calculatorLv3.setResult(result);
        }
    }

    /* 연산 기록 출력 */
    // 1. 로직 구현
    public void historyDisplayLogic(List resultList) { //
        System.out.print("§ 계산 기록 : ");
        DecimalFormat realNumResultList = new DecimalFormat("#.###"); // 소수 셋째 자리까지 출력
        for (int i = 0; i < resultList.size(); i++) { // 저장된 기록 수만큼 반복 출력
            this.resultHistory = (double) resultList.get(i);
            if(resultHistory % 1 != 0) {
                System.out.print(realNumResultList.format(resultHistory) + " "); // 나머지가 0이 아니라면 실수로 출력
            } else {
                System.out.print((int) resultHistory + " "); // 실수가 아니면 정수로 출력
            }
        }
        System.out.println(); // 연산 기록간의 줄바꿈 주기
        System.out.println("─────────────────────────────");
    }
    // 2. 출력 메서드
    public void historyDisplay() {
        historyDisplayLogic(calculatorLv3.getResultList());
    }

}
