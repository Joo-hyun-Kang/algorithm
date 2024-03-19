class Solution {
    public String addStrings(String num1, String num2) {
        char[] arrayNum1 = num1.toCharArray();
        char[] arrayNum2 = num2.toCharArray();

        final int ASCII_TO_INTERGER_VALUE = 48;

        int len1 = arrayNum1.length - 1;
        int len2 = arrayNum2.length - 1;
        StringBuilder builder = new StringBuilder();
        int advanceValue = 0;

        while (len1 >= 0 || len2 >= 0) {
            int digit1 = len1 >= 0 ? (arrayNum1[len1] - ASCII_TO_INTERGER_VALUE) : 0;
            int digit2 = len2 >= 0 ? (arrayNum2[len2] - ASCII_TO_INTERGER_VALUE) : 0;

            int sum = digit1 + digit2 + advanceValue;

            advanceValue = 0;
            if (sum >= 10) {
                advanceValue = 1;
                sum -= 10;
            }

            builder.insert(0, (char) (ASCII_TO_INTERGER_VALUE + sum));

            len1--;
            len2--;
        }

        if (advanceValue == 1) {
            builder.insert(0, "1");
        }

        return builder.toString();
    }
}