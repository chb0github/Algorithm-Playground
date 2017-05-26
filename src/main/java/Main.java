public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < 2; j++) {
                System.out.println("j = " + j);
                for (int k = 0; k < 2; k++) {
                    System.out.println("k = " + k);
                    if (i == 1) {
                        System.out.println("here");
                        break;
                    }
                }
            }
            System.out.println("---");
        }
    }
}