import java.util.Random;

public class Man {
    private String name; // Имя человека
    private boolean isAlive; // Жив ли человек
    private int age; // Возраст
    private int health; // Здоровье
    private Random random; // Генератор случайных чисел

    // Конструктор
    public Man(String name) {
        this.name = name;
        this.isAlive = true;
        this.random = new Random();
        this.age = getRandomInt(14, 101);
        this.health = getRandomInt(1, 101);
    }

    // Метод для разговора
    public void talk() {
        int randomTalk = getRandomInt(1, 4);
        String message = "";

        switch (randomTalk) {
            case 1:
                message = "Привет, меня зовут " + name;
                break;
            case 2:
                message = "Мне " + age + " лет, а тебе?";
                break;
            case 3:
                if (health > 50) {
                    message = "Да я здоров как бык!";
                } else {
                    message = "Со здоровьем у меня хреново, дожить бы до " + (age + 10);
                }
                break;
        }
        System.out.println(message);
    }

    // Метод передвижения
    public void go() {
        if (isAlive()) {
            if (health > 40) {
                System.out.println(name + " мирно прогуливается по городу");
            } else {
                System.out.println(name + " болен и не может гулять по городу");
            }
        } else {
            System.out.println(name + " не может идти, он же умер");
        }
    }

    // Метод для получения случайного числа
    private int getRandomInt(int min, int max) {
        return random.nextInt(max - min) + min; // Генерация случайного числа в пределах [min, max)
    }

    // Метод убить человека
    public void kill() {
        this.isAlive = false;
    }

    // Метод проверки, жив ли человек
    public boolean isAlive() {
        return this.isAlive;
    }

    // Тестовый метод main для проверки
    public static void main(String[] args) {
        Man man = new Man("Иван");
        man.talk();
        man.go();
        man.kill();
        man.go();
    }
}