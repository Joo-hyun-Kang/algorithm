class Solution {
    public boolean validUtf8(int[] data) {

        /* コードの i, UTFByteLengthの　依存性の解決する */

        int[] prefixUTF8FistByte = new int[]{0b11000, 0b11100, 0b11110};
        final int prefixUTF8 = 0b10000000;
        final int OVER_UTF_BITS_LANGE = 4;

        int i = 0;
        boolean isUTF8 = false;
        while (i < data.length) {
            isUTF8 = false;

            if (isAcsii(data[i])) {
                i++;
                isUTF8 = true;
                continue;
            }

            int followedUTFBytes = -1;
            int firstBitUTF8 = data[i++] >> 3;
            for (int j = 0; j < prefixUTF8FistByte.length; j++) {
                if (firstBitUTF8 == prefixUTF8FistByte[j]) {
                    followedUTFBytes = j + 1;
                    break;
                }
            }

            if (followedUTFBytes == -1) {
                break;
            }

            boolean isFollowedBytes = true;
            for (int j = followedUTFBytes; j > 0; j--) {
                int temp = data[i++] & prefixUTF8;

                if (temp != prefixUTF8) {
                    isFollowedBytes = false;
                    break;
                }
            }

            if (!isFollowedBytes) {
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