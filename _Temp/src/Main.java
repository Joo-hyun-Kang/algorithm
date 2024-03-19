public class Main {
    public static void main(String[] args) {

        int temp = 0xffffffff >>> 1;
        System.out.println(temp);

        temp <<= 1;
        System.out.println(temp);
    }
}