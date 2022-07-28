import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] products = new String[]{"Хлеб", "Яблоки", "Молоко", "Сахар", "Соль"};
        int[] prices = new int[]{50, 20, 80, 60, 30};
        int[] purchasesCount = new int[5];

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
        int totalSumProducts;
        int sumProducts = 0;
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

        }
        out.println("Ваша корзина: ");
        for (int i = 0; i < products.length; i++) {
            if (purchasesCount[i] != 0) {
                sumProducts += prices[i] * purchasesCount[i];
                out.println(
                        products[i]
                                + " - "
                                + purchasesCount[i]
                                + " шт. "
                                + "("
                                + prices[i]
                                + " руб/шт): "
                                + purchasesCount[i] * prices[i]
                                + " руб в сумме");
            }
        }

        out.println("Итого: " + sumProducts + " руб");

        String[] saleProducts = new String[]{"Пельмени", "Майонез", "Масло"};
        int[] salePrices = new int[]{400, 150, 100};
        int[] salePurchasesCount = new int[3];

        out.println("Товары по скидке 3 по цене 2");
        for (int i = 0; i < saleProducts.length; i++) {
            out.println((i
                    + 1)
                    + ". "
                    + saleProducts[i]
                    + " "
                    + salePrices[i]
                    + " руб/шт");
        }
        int saleSumProducts = 0;
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

            if (productNumber > saleProducts.length - 1 || productNumber < 0) {
                out.println("Неверный продукт");
                continue;
            }

            if (productCount <= 0) {
                out.println("Неверное количество");
                continue;
            }
            out.println(saleProducts[productNumber]
                    + " "
                    + (productCount + salePurchasesCount[productNumber])
                    + " шт.");
            salePurchasesCount[productNumber] += productCount;
        }
        out.println("Ваша корзина со скидкой: ");
        for (int i = 0; i < saleProducts.length; i++) {
            if (salePurchasesCount[i] != 0) {
                int sum = (2 * (salePurchasesCount[i] / 3) + salePurchasesCount[i] % 3) * salePrices[i];
                saleSumProducts += sum;
                out.println(saleProducts[i]
                        + " - "
                        + salePurchasesCount[i]
                        + " шт. "
                        + "("
                        + salePrices[i]
                        + " руб/шт): "
                        + sum
                        + " руб в сумме");
            }
        }
        out.println("Итого со скидкой: " + saleSumProducts + " руб");
        totalSumProducts = sumProducts + saleSumProducts;
        out.println("Полная корзина: " + (totalSumProducts) + " руб");
    }
}