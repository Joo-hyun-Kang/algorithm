public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return new String("0");
        }

        StringBuilder builder = new StringBuilder();

        char[] hexChars = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};

        int bitwise = (int) Math.pow(2, 4) - 1;

        while (num != 0) {
            int intToByte = num & bitwise;

            if (intToByte >= 10) {
                builder.insert(0, hexChars[intToByte % 16 - 10]);
            } else {
                builder.insert(0, intToByte);
            }

            num >>>= 4;
        }

        return builder.toString();
    }
}