import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> values = new ArrayList<Integer>(Collections.nCopies(num1.length() + num2.length() - 1, 0));

        if (num1.length() == 1 && num1.charAt(0) - '0' == 0) {
            return builder.append(0).toString();
        }

        if (num2.length() == 1 && num2.charAt(0) - '0' == 0) {
            return builder.append(0).toString();
        }

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

                values.set(pos, values.get(pos) + result);
                digitPos2++;
                len2--;
            }

            digitPos1++;
            len1--;
        }

        int rest = 0;
        for (Integer value : values) {
            value += rest;
            builder.append(value % 10);
            rest = value / 10;
        }

        while (rest != 0) {
            builder.append(rest % 10);
            rest /= 10;
        }

        return builder.reverse().toString();
    }
}