class Solution {
    public boolean validUtf8(int[] data) {

        /* コードの i, UTFByteLengthの　依存性の解決する */

        int[] prefixUTF8FistByte = new int[]{0b11000, 0b11100, 0b11110};
        final int prefixUTF8 = 0b10000000;
        final int OVER_UTF_BITS = 4;
        boolean isUTF8 = false;

        int i = 0;
        while (i < data.length) {
            isUTF8 = false;

            if (isAcsii(data[i])) {
                i++;
                isUTF8 = true;
                continue;
            }

            int UTFByteLength = 0;
            int firstBitUTF8 = data[i] >> 3;
            while (UTFByteLength < prefixUTF8FistByte.length) {
                if (firstBitUTF8 == prefixUTF8FistByte[UTFByteLength]) {
                    break;
                }
                UTFByteLength++;
            }
            UTFByteLength++;

            if (UTFByteLength >= OVER_UTF_BITS) {
                break;
            }

            i++;
            while (UTFByteLength > 0 && i < data.length) {
                int temp = data[i] & prefixUTF8;
                i++;

                if (temp != prefixUTF8) {
                    break;
                }

                UTFByteLength--;
            }

            if (UTFByteLength <= 0) {
                isUTF8 = true;
            }
        }

        return isUTF8;
    }

    private boolean isAcsii(int data) {
        final int temp = 0b10000000 & data;
        return temp == 0;
    }
}