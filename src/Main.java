import java.util.Scanner;

public class Main {
    private static Man someMan; // Переменная для хранения созданного человека

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;

        while (isRun) {
            System.out.print("Пожалуйста, введите команду: ('help', 'create-man', 'kill-man', 'talk', 'go' или 'exit'): ");
            String command = scanner.nextLine();

            switch (command) {
                case "help":
                    System.out.println("Вот перечень команд, которые вы можете использовать:");
                    System.out.println("---create-man---");
                    System.out.println("---kill-man---");
                    System.out.println("---talk---");
                    System.out.println("---go---");
                    System.out.println("---exit---");
                    break;
                case "exit":
                    isRun = false;
                    break;
                case "create-man":
                    System.out.print("Введите имя человека: ");
                    String name = scanner.nextLine();
                    someMan = new Man(name);
                    System.out.println("Человек с именем " + name + " успешно создан.");
                    break;
                case "kill-man":
                    if (someMan != null) {
                        someMan.kill();
                        System.out.println("Человек с именем " + someMan + " был убит.");
                    } else {
                        System.out.println("Человек не создан.");
                    }
                    break;
                case "talk":
                    if (someMan != null) {
                        someMan.talk();
                    } else {
                        System.out.println("Человек не создан.");
                    }
                    break;
                case "go":
                    if (someMan != null) {
                        someMan.go();
                    } else {
                        System.out.println("Человек не создан.");
                    }
                    break;
                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
        }
    }
}