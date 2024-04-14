class Solution {
    public boolean validUtf8(int[] data) {
        int[] prefixUTF8FistByte = new int[]{0b1100, 0b1110, 0b1111};
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
            int firstBitUTF8 = data[i] >> 4;
            while (UTFByteLength < prefixUTF8FistByte.length) {
                if (firstBitUTF8 == prefixUTF8FistByte[UTFByteLength]) {
                    break;
                }
                UTFByteLength++;
            }

            if (UTFByteLength == OVER_UTF_BITS) {
                break;
            }

            i++;
            while (UTFByteLength >= 0 && i < data.length) {
                int temp = data[i++] & prefixUTF8;
                if (temp != prefixUTF8) {
                    break;
                }
                UTFByteLength--;
            }
        }

        return isUTF8;
    }

    private boolean isAcsii(int data) {
        final int temp = 0b10000000 & data;
        return temp == 0;
    }
}