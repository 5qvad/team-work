import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] products = new String[]{"Хлеб", "Яблоки", "Молоко", "Сахар", "Соль"}; // сахар и соль по скидке
        int[] prices = new int[]{50, 20, 80, 60, 30};
        int[] purchasesCount = new int[products.length];

        out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            out.println((i
                    + 1)
                    + ". "
                    + products[i]
                    + " "
                    + prices[i]
                    + " руб/шт");
        }
        int sumProducts = 0;
        int productNumber;
        int productCount = 0;
        int sum;
        while (true) {
            out.println("Выберите товар и количество или введите `end` ");
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                out.println("Некорректный ввод 2 значений, нужно ввести 2 числа");
                continue;
            }
            try {
                productNumber = Integer.parseInt(parts[0]) - 1;
                productCount = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                out.println("Неверный формат ввода");
                continue;
            }

            if (productNumber > products.length - 1 || productNumber < 0) {
                out.println("Неверный продукт");
                continue;
            } else if (productCount == 0) {
                purchasesCount[productNumber] = 0;
                out.println("Вы полностью убрали из корзины: " + products[productNumber]);
                continue;
            } else if (productCount < 0) {
                purchasesCount[productNumber] += productCount;
                if (purchasesCount[productNumber] < 0) {
                    purchasesCount[productNumber] = 0;
                    out.println("Вы полностью убрали из корзины: " + products[productNumber]);
                } else
                    out.println("Количество продукта " + products[productNumber] + " уменьшено на " + productCount + " шт.");
                continue;
            }
            out.println(products[productNumber]
                    + " "
                    + (productCount + purchasesCount[productNumber])
                    + " шт.");
            purchasesCount[productNumber] += productCount;

        }
        out.println("Ваша корзина: ");
        for (int i = 0; i < products.length; i++) {
            if (purchasesCount[i] != 0) {
                if ((i == 3 || i == 4) && (purchasesCount[i] + productCount >= 3)) { // где 3 и 4 номера продуктов по акции (сахар и соль)
                    sum = (2 * (purchasesCount[i] / 3) + purchasesCount[i] % 3) * prices[i];
                } else {
                    sum = prices[i] * purchasesCount[i];
                }
                sumProducts += sum;
                out.println(
                        products[i]
                                + " - "
                                + purchasesCount[i]
                                + " шт. "
                                + "("
                                + prices[i]
                                + " руб/шт): "
                                + sum
                                + " руб в сумме");
            }
        }
        out.println("Итого: " + sumProducts + " руб");          
    }
}
