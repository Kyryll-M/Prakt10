import java.util.Scanner;

class UserAuthSystem {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - Додати користувача");
            System.out.println("2 - Видалити користувача");
            System.out.println("3 - Підтвердження користувача");
            System.out.println("4 - Вийти");
            System.out.print("Оберіть опцію: ");

            if (!scanner.hasNextInt()){
                System.out.println("Помилка: введіть число від 1 - 4 .");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Введіть ім'я користувача: ");
                        String username = scanner.nextLine();
                        System.out.print("Введіть пароль: ");
                        String password = scanner.nextLine();
                        userManager.registerUser(username, password);
                        System.out.println("Користувача зареєстровано!");
                        break;

                    case 2:
                        System.out.print("Введіть ім'я користувача для видалення: ");
                        String userToRemove = scanner.nextLine();
                        userManager.removeUser(userToRemove);
                        System.out.println("Користувача видалено!");
                        break;

                    case 3:
                        System.out.print("Введіть ім'я користувача: ");
                        String authUser = scanner.nextLine();
                        System.out.print("Введіть пароль: ");
                        String authPass = scanner.nextLine();
                        userManager.authenticateUser(authUser, authPass);
                        System.out.println("Перевірка успішна!");
                        break;

                    case 4:
                        System.out.println("Вихід...");
                        return;

                    default:
                        System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }
}