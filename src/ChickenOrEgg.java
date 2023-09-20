public class ChickenOrEgg {
    public static void main(String[] args) throws InterruptedException {
        Thread chickenThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Курица");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread eggThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Яйцо");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        chickenThread.start();
        eggThread.start();

        while (chickenThread.isAlive() || eggThread.isAlive()) {
            Thread.sleep(100);
        }

        System.out.println("Спор окончен!");
        if (chickenThread.isAlive()) {
            System.out.println("Победила курица!");
        } else {
            System.out.println("Победило яйцо!");
        }
    }
}