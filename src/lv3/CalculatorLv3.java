package lv3;

public class CalculatorLv3 {

    // parseNumber 메서드를 통해 입력받은 수를 알맞은 타입으로 변환
    public static Number parseNumber(String numStr) {
        if(numStr.contains(".")) {
            return Double.valueOf(numStr); // 소수 점이 포함되어 있으면 double 형으로 반환
        } else {
            return Integer.valueOf(numStr); // 소수 점이 없다면 정수로 반환
        }
    }

}
