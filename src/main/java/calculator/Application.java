package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder("ddd");
//        System.out.println(sb.charAt(2));

        //일단 입력받아
        String str = Console.readLine();

        //커스텀 구분자를 지정하는지 먼저 판단
        char customChar = 0;
        if (str.length() >= 5 && str.substring(0, 5).matches("//.\\\\n")) {
            customChar = str.charAt(2);
//            System.out.println("커스텀 구분자를 지정하려합니다. 구분자는 " + customChar + " 입니다.");
            str = str.substring(5);
        }
        String[] strArr = str.split("[,;" + customChar + "]",-1);

        int sum = 0;

        for (String s : strArr) {
            if (s.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력이 있습니다: 마지막에 구분자가 있습니다.");
            }
            int tmp = Integer.parseInt(s);

            if (tmp<=0) {
                throw new IllegalArgumentException("잘못된 입력이 있습니다: 양의 정수가 아니라요");
            }

            sum += tmp;
        }


        System.out.println("결과 : " + sum);
    }
}
