class Solution {
    public String addStrings(String num1, String num2) {
        char[] arrayNum1 = num1.toCharArray();
        char[] arrayNum2 = num2.toCharArray();
        final int ASCII_TO_INTERGER_VALUE = 48;

        int posValue = 1;
        int res1 = 0;
        int res2 = 0;

        for (int i = arrayNum1.length - 1; i >= 0; i--) {
            res1 += (arrayNum1[i] - ASCII_TO_INTERGER_VALUE) * posValue;
            posValue *= 10;
        }

        posValue = 1;
        for (int i = arrayNum2.length - 1; i >= 0; i--) {
            res2 += (arrayNum2[i] - ASCII_TO_INTERGER_VALUE) * posValue;
            posValue *= 10;
        }

        long res = res1 + res2;
        if (res == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();

        while (res > 0) {
            builder.insert(0, (char) (ASCII_TO_INTERGER_VALUE + res % 10));
            res /= 10;
        }

        return builder.toString();
    }
}