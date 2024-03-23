import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String multiply(String num1, String num2) {

        /*
            advance
            最初の位置

            "23"
            "456"
         */

        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> values = new ArrayList<Integer>(Collections.nCopies(num1.length() + num2.length() - 1, 0));

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

        for (Integer value : values) {
            System.out.println(value);
        }

        return builder.reverse().toString();
    }
}