import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] products = new String[]{"Хлеб", "Яблоки", "Молоко"};
        int[] prices = new int[]{50, 20, 80};
        int[] purchasesCount = new int[3];

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
        int totalSumProducts = 0;
        int currentPrice;
        int sumProducts;
        int productNumber;
        int productCount;
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
            }

            if (productCount <= 0) {
                out.println("Неверное количество");
                continue;
            }
            out.println(products[productNumber]
                    + " "
                    + (productCount + purchasesCount[productNumber])
                    + " шт.");
            purchasesCount[productNumber] += productCount;
            currentPrice = prices[productNumber];
            sumProducts = currentPrice * productCount;
            totalSumProducts += sumProducts;
        }
        System.out.println("Ваша корзина: ");
        for (int i = 0; i < products.length; i++) {
            if (purchasesCount[i] != 0) {
                out.println(
                        products[i]
                                + " - "
                                + purchasesCount[i]
                                + " шт. "
                                + "("
                                + prices[i]
                                + " руб/шт): "
                                + (purchasesCount[i] * prices[i])
                                + " руб в сумме");
            }
        }
        out.println("Итого: " + totalSumProducts + " руб");
    }
}
