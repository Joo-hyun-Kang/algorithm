import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String multiply(String num1, String num2) {
        // 配列に取り換える
        //　aiさんのループの仕方を齎す
        //　最適な回答を確かめる


        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] values = new int[num1.length() + num2.length()];
        // ArrayList<Integer> values = new ArrayList<Integer>(Collections.nCopies(num1.length() + num2.length(), 0));

        int len1 = num1.length() - 1;
        int digitPos1 = 0;

        while (len1 >= 0) {
            int digit1 = (num1.charAt(len1) - '0');

            int len2 = num2.length() - 1;
            int digitPos2 = 0;
            while (len2 >= 0) {
                int digit2 = (num2.charAt(len2) - '0');

                int result = digit1 * digit2;
                int pos = digitPos1 + digitPos2;

                values[pos] = values[pos] + result;
                digitPos2++;
                len2--;
            }

            digitPos1++;
            len1--;
        }

        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < values.length - 1; i++) {
            values[i] += carry;
            builder.append(values[i] % 10);
            carry = values[i] / 10;
        }

        while (carry != 0) {
            builder.append(carry % 10);
            carry /= 10;
        }

        return builder.reverse().toString();
    }
}