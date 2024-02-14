public class SimpleHashCode implements Hash {
    @Override
    public Object hashcodeOrNull(Object value) {
        if (value == null) {
            return null;
        }

        int valueInt = (Integer) value;
        byte[] array = intToByteArray(valueInt);

        int hash = 0;
        for (byte b : array) {
            // 常に正の数がなるようにする
            if (b < 0) {
                b >>= 1;
            }

            hash += b;
        }

        return hash;
    }

    @Override
    public int calculateCollision() {
        final int TEST_RANGE = 1_000_000;
        int[] counts = new int[TEST_RANGE];

        for (int i = 0; i < TEST_RANGE; i++) {
            Integer value = (Integer) hashcodeOrNull(i);
            if (value == null) {
                return -1;
            }

            counts[i]++;
        }

        int collision = 0;
        for (int count : counts) {
            if (count > 1) {
                collision++;
            }
        }

        return collision;
    }

    private byte[] intToByteArray(int value) {
        return new byte[] {
                (byte)(value >>> 24),
                (byte)(value >>> 16),
                (byte)(value >>> 8),
                (byte)value};
    }
}
