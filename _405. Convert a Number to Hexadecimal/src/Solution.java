import java.util.HashMap;

public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return new String("0");
        }

        StringBuilder builder = new StringBuilder();
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(10, 'a');
        map.put(11, 'b');
        map.put(12, 'c');
        map.put(13, 'd');
        map.put(14, 'e');
        map.put(15, 'f');

        while (num > 0) {
            int base16 = num % 16;

            if (base16 >= 10) {
                builder.insert(0, map.get(base16));
            } else {
                builder.insert(0, base16);
            }

            num /= 16;
        }

        return builder.toString();
    }
}