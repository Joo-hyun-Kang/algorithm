class Solution {

    public String addStrings(String num1, String num2) {
        final int ASCII_TO_INTERGER_VALUE = 48;

        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder builder = new StringBuilder();
        int advanceValue = 0;

        while (len1 >= 0 || len2 >= 0) {
            int digit1 = len1 >= 0 ? (num1.charAt(len1) - ASCII_TO_INTERGER_VALUE) : 0;
            int digit2 = len2 >= 0 ? (num2.charAt(len2) - ASCII_TO_INTERGER_VALUE) : 0;

            int sum = digit1 + digit2 + advanceValue;
            builder.append((char) (ASCII_TO_INTERGER_VALUE + sum % 10));

            advanceValue = sum / 10;

            len1--;
            len2--;
        }

        if (advanceValue == 1) {
            builder.append("1");
        }

        return builder.reverse().toString();
    }
}