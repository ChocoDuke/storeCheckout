import java.util.Scanner;
public class storeCheckout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mousePrice = 20;
        int keyboardPrice = 40;
        int headphonesPrice = 50;
        int standPrice = 30;

        // Кол-во каждого продукта
        int mouseCount = 0;
        int keyboardCount = 0;
        int headphonesCount = 0;
        int standCount = 0;

        // Стоимость перед покупкой
        double mouseSubtotal = 0;
        double keyboardSubtotal = 0;
        double headphonesSubtotal = 0;
        double standSubtotal = 0;

        // подсчет кол-ва повторений и накопления изменяющейся суммы
        int choice = 0;
        int itemsPurchased = 0;
        double subtotal = 0;

        // меню магазина
        while (choice != 5) {
            System.out.println();
            System.out.println("\n\n\tM A Г A З И Н\n");
            System.out.println("1. Mouse - $20");
            System.out.println("2. Keyboard - $40");
            System.out.println("3. Headphones - $50");
            System.out.println("4. Laptop Stand - $30");
            System.out.println("5.Checkout");

            System.out.print("Выберите товар: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                String productName = "";
                int price = 0;

                if (choice == 1) {
                    productName = "Mouse";
                    price = mousePrice;
                } else if (choice == 2) {
                    productName = "Keyboard";
                    price = keyboardPrice;
                } else if (choice == 3) {
                    productName = "Headphones";
                    price = headphonesPrice;
                } else {
                    productName = "Laptop Stand";
                    price = standPrice;
                }

                System.out.println("Вы выбрали: " + productName);
                System.out.println("Цена: $" + price);

                System.out.print("Укажите количество: ");
                int quantity = scanner.nextInt();

                if (quantity > 0) {
                    double itemCost = price * quantity;

                    subtotal = subtotal + itemCost;
                    itemsPurchased = itemsPurchased + quantity;

                    // Бонус 3: подсчёт кол-ва товаров каждого вида
                    if (choice == 1) {
                        mouseCount = mouseCount + quantity;
                        mouseSubtotal = mouseSubtotal + itemCost;
                    } else if (choice == 2) {
                        keyboardCount = keyboardCount + quantity;
                        keyboardSubtotal = keyboardSubtotal + itemCost;
                    } else if (choice == 3) {
                        headphonesCount = headphonesCount + quantity;
                        headphonesSubtotal = headphonesSubtotal + itemCost;
                    } else {
                        standCount = standCount + quantity;
                        standSubtotal = standSubtotal + itemCost;
                    }

                    System.out.println("Добавлено в корзину!");
                    System.out.printf("Нынешняя стоимость: $%.2f%n", subtotal);
                } else {
                    System.out.println("Недействительное количество.");
                    System.out.println("Колчиство товаров должно быть больше 0.");
                }

            } else if (choice == 5) {
                System.out.println("Запуск процесса оплаты...");
            } else {
                System.out.println("Некорректная опция.");
                System.out.println("Пожалуйста, выберите число от 1 до 5.");
            }
        }

        // BONUS 3: Показать количество каждого товара
        System.out.println();
        System.out.println("**** КУПЛЕННЫЕ ТОВАРЫ ****");
        System.out.println("Mouse: " + mouseCount);
        System.out.println("Keyboard: " + keyboardCount);
        System.out.println("Headphones: " + headphonesCount);
        System.out.println("Laptop Stand: " + standCount);

        //  ОФОРМЛЕНИЕ ЗАКАЗА
        System.out.println();
        System.out.println("**** ОФОРМЛЕНИЕ ЗАКАЗА ****");
        System.out.println("Купленные товары: " + itemsPurchased);
        System.out.printf("Subtotal: $%.2f%n", subtotal);

        // Бонус1: Предоставить скидку 5% на тип товара, если было куплено 5 или более единиц этого товара
        double productDiscount = 0;

        if (mouseCount >= 5) {
            productDiscount = productDiscount + mouseSubtotal * 0.05;
        }

        if (keyboardCount >= 5) {
            productDiscount = productDiscount + keyboardSubtotal * 0.05;
        }

        if (headphonesCount >= 5) {
            productDiscount = productDiscount + headphonesSubtotal * 0.05;
        }

        if (standCount >= 5) {
            productDiscount = productDiscount + standSubtotal * 0.05;
        }

        System.out.printf("Скидка на товар: $%.2f%n", productDiscount);

        // BONUS 2: Общие уровни скидок
        double generalDiscount = 0;

        if (subtotal >= 200) {
            generalDiscount = subtotal * 0.15;
        } else if (subtotal >= 100) {
            generalDiscount = subtotal * 0.10;
        }

        System.out.printf("General discount: $%.2f%n", generalDiscount);

        // Рассчитать итоговую сумму
        double totalDiscount = productDiscount + generalDiscount;
        double finalTotal = subtotal - totalDiscount;

        System.out.printf("Общая скидка: $%.2f%n", totalDiscount);
        System.out.printf("Итого к оплате: $%.2f%n", finalTotal);

        // Оплата:повторять до тех пор, пока не будет введено достаточно денег
        double payment = 0;

        while (payment < finalTotal) {
            System.out.print("Введите сумму оплаты: $");
            payment = scanner.nextDouble();

            if (payment < finalTotal) {
                double remaining = finalTotal - payment;
                System.out.println("Недостаточно средств для оплаты.");
                System.out.printf("Вам все еще нужно оплатить: $%.2f%n", remaining);
            }
        }

        // Рассчитать сдачу
        double change = payment - finalTotal;

        System.out.println("Оплата прошла успешно!");

        // БОНУС 4: Найти самый покупаемый товар
        // В задании сказано предположить, что совпадений по количеству нет.
        String mostPurchasedProduct = "";
        int highestQuantity = 0;

        if (mouseCount > highestQuantity) {
            highestQuantity = mouseCount;
            mostPurchasedProduct = "Mouse";
        }

        if (keyboardCount > highestQuantity) {
            highestQuantity = keyboardCount;
            mostPurchasedProduct = "Keyboard";
        }

        if (headphonesCount > highestQuantity) {
            highestQuantity = headphonesCount;
            mostPurchasedProduct = "Headphones";
        }

        if (standCount > highestQuantity) {
            highestQuantity = standCount;
            mostPurchasedProduct = "Laptop Stand";
        }

        System.out.println();
        System.out.println("**** САМЫЙ ПОКУПАЕМЫЙ ТОВАР ****");
        if (highestQuantity > 0) {
            System.out.println("Самый покупаемый товар: " + mostPurchasedProduct);
            System.out.println("Количество: " + highestQuantity);
        } else {
            System.out.println("Ни один товар не был куплен.");
        }

        // Final receipt
        System.out.println();
        System.out.println("========================");
        System.out.println("     ЛУЧШИЙ МАГАЗИН");
        System.out.println("========================");
        System.out.println("Куплено товаров: " + itemsPurchased);
        System.out.printf("Промежуточный итог: $%.2f%n", subtotal);
        System.out.printf("Скидка на товар: $%.2f%n", productDiscount);
        System.out.printf("Общая скидка (уровень): $%.2f%n", generalDiscount);
        System.out.printf("Сумма всех скидок: $%.2f%n", totalDiscount);
        System.out.printf("Итого к оплате: $%.2f%n", finalTotal);
        System.out.printf("Оплачено: $%.2f%n", payment);
        System.out.printf("Сдача: $%.2f%n", change);

        // БОНУС 5: Награда за покупку 10 или более единиц товара
        if (itemsPurchased >= 10) {
            System.out.println();
            System.out.println("Вы заработали купон на $10 для следующего визита!");
        }

        System.out.println("========================");
        System.out.println("Спасибо за покупку!");
        System.out.println("========================");

        scanner.close();
    }
}


