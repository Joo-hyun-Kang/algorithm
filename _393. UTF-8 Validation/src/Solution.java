class Solution {
    public boolean validUtf8(int[] data) {
        int[] prefixUTF8FistByte = new int[]{0b1100, 0b1110, 0b1111};
        final int prefixUTF8 = 0b10000000;
        boolean isUTF8 = true;

        int i = 0;
        while (i < data.length) {
            if (isAcsii(data[i])) {
                i++;
                continue;
            }

            int UTFByteLength = 0;
            int firstBitUTF8 = data[i] >> 4;
            while (UTFByteLength < prefixUTF8FistByte.length) {
                if (firstBitUTF8 == prefixUTF8FistByte[UTFByteLength]) {
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