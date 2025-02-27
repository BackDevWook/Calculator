package lv3;

public class CalculatorLv3 {

    // parseNumber 메서드를 통해 입력받은 수를 알맞은 타입으로 변환
    public static double parseNumber(String numStr) {
        return Double.valueOf(numStr); // 입력받은 수 모두 실수 형태로 반환
    }
}
