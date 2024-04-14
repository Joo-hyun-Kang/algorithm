class Solution {
    public boolean validUtf8(int[] data) {
        // 129
        // 1000 0001
        // 1000 0000
        // 0
        // isAscii

        /*
        1          |   0xxxxxxx
        2          |   110xxxxx 10xxxxxx
        3          |   1110xxxx 10xxxxxx 10xxxxxx
        4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
        */

        //1110 1011 1000 1100 0000 0100.
        int[] prefixUTF8FistByte = new int[]{0b11000000, 0b11100000, 0b11110000};
        final int prefixUTF8 = 0b10000000;
        boolean isUTF8 = true;

        int i = 0;
        while (i < data.length) {
            if (isAcsii(data[i])) {
                i++;
                continue;
            }

            int UTFByteLength = 0;
            while (UTFByteLength < prefixUTF8FistByte.length) {
                int temp = prefixUTF8FistByte[UTFByteLength] & data[i];
                if (temp == prefixUTF8FistByte[UTFByteLength]) {
                    i++;
                    break;
                }
                UTFByteLength++;
            }

            if (UTFByteLength == prefixUTF8FistByte.length) {
                isUTF8 = false;
                break;
            }

            while (UTFByteLength >= 0) {
                int temp = data[i] & prefixUTF8;
                if (temp != prefixUTF8) {
                    isUTF8 = false;
                    break;
                }
                i++;
                UTFByteLength--;
            }

            if (!isUTF8) {
                break;
            }

        }

        return isUTF8;
    }

    private boolean isAcsii(int data) {
        final int temp = 0b10000000 & data;
        return temp == 0;
    }
}