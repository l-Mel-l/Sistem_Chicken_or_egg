class Chicken implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            ChickenOrEgg.lastWord = "Курица";
            System.out.println(ChickenOrEgg.lastWord);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }
}

class Egg implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            ChickenOrEgg.lastWord = "Яйцо";
            System.out.println(ChickenOrEgg.lastWord);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }
}

public class ChickenOrEgg {
    public static String lastWord = "";
    public static void main(String[] args) {
        Thread chicken = new Thread(new Chicken());
        Thread egg = new Thread(new Egg());
        chicken.start();
        egg.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Спор Окночен!");
        System.out.println(lastWord + " - это последнее слово");
    }
}