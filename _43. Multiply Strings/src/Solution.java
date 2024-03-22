class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int len1 = num1.length() - 1;
        final int DIGITPOS_TO_DECIAML = 10;

        int digitPos1 = 1;
        while (len1 >= 0) {
            // 返っていく時、このループにも進みながら１０倍をかけないと。
            // 一旦、　23 * 456
            int convert1 = (num1.charAt(len1) - '0') * digitPos1;
            int len2 = num2.length() - 1;

            int digitPos2 = 1;
            int advance = 0;
            while (convert1 != 0 && len2 >= 0) {
                int convert2 = (num2.charAt(len2) - '0') * digitPos2;

                advance += convert1 * convert2;
                int result = advance % (digitPos2 * DIGITPOS_TO_DECIAML);
                advance -= result;

                builder.append(result / digitPos2);

                digitPos2 *= 10;
                len2--;
            }

            if (advance > 0) {
                builder.append(advance / digitPos2);
            }

            digitPos1 *= 10;
            len1--;
        }

        return builder.reverse().toString();
    }
}