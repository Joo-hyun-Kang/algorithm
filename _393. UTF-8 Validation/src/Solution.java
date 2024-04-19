class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        boolean isUTF8 = false;
        while (i < data.length) {
            isUTF8 = false;

            if (isAcsii(data[i])) {
                i++;
                isUTF8 = true;
                continue;
            }

            int followedUTFBytes = GetUTFBytes(data[i]);

            if (followedUTFBytes == -1 || followedUTFBytes > (data.length - 1) - i) {
                break;
            }

            boolean isFollowedBytes = true;
            final int prefixUTF8 = 0b10000000;
            for (int j = followedUTFBytes; j > 0; j--) {
                int temp = data[++i] & prefixUTF8;

                if (temp != prefixUTF8) {
                    isFollowedBytes = false;
                    break;
                }

                temp = data[i] << 1 & prefixUTF8 << 1;

                if (temp != 0b00000000) {
                    isFollowedBytes = false;
                    break;
                }
            }

            if (isFollowedBytes) {
                isUTF8 = true;
            } else {
                break;
            }

            i++;
        }

        return isUTF8;
    }

    private boolean isAcsii(int data) {
        final int temp = 0b10000000 & data;
        return temp == 0;
    }

    private int GetUTFBytes(int num) {
        StringBuilder builder = new StringBuilder();

        if (num == 0) {
            return -1;
        }

        while (num > 0) {
            if (num % 2 == 0) {
                builder.append("0");
            } else {
                builder.append("1");
            }

            num /= 2;
        }

        // 1100
        String value = builder.reverse().toString();
        String[] prefixUTF8FistByte = {new String("110"), new String("1110"), new String("11110")};

        int isUTF8 = -1;
        for (int i = 0; i < prefixUTF8FistByte.length; i++) {
            boolean isEqual = true;
            for (int j = 0; j < prefixUTF8FistByte[i].length(); j++) {
                if (value.charAt(j) != prefixUTF8FistByte[i].charAt(j)) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) {
                isUTF8 = i + 1;
                break;
            }
        }
        
        return isUTF8;
    }
}