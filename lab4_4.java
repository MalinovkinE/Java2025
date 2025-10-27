//import java.util.Scanner;
//
//public class lab4_4 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int debt = 0; // остаток долга
//        int deposit = 0; // остаток на счете
//        int percent = 0; // процентная ставка
//        boolean mortgageActive = false; // Флаг активной ипотеки
//        boolean percentSet = false; // Флаг установки процента
//
//        System.out.println("Вводите данные (процент, сумму ипотеки, платежи) или 'stop' для завершения:");
//
//        while (true) {
//            String input = scanner.nextLine().trim();
//
//            // Проверка на команду stop
//            if (input.equalsIgnoreCase("stop")) {
//                if (debt > 0) {
//                    System.out.println("Debt amount " + debt);
//                } else if (deposit > 0) {
//                    System.out.println("Deposit amount " + deposit);
//                }
//                break;
//            }
//
//            // Проверка на процент (строка содержит %)
//            if (input.contains("%")) {
//                try {
//                    // Извлекаем число перед символом %
//                    String percentStr = input.substring(0, input.indexOf("%")).trim();
//                    int newPercent = Integer.parseInt(percentStr);
//
//                    if (percentSet) {
//                        // Если процент уже был установлен, игнорируем новый процент
//                        System.out.println("Процент игнорируется - процент уже установлен");
//                    } else {
//                        percent = newPercent;
//                        percentSet = true;
//                        System.out.println("Установлен процент: " + percent + "%");
//                    }
//                } catch (NumberFormatException e) {
//                    // Неверный формат процента - игнорируем
//                    System.out.println("Неверный формат процента");
//                }
//                continue;
//            }
//
//            // Проверка на число
//            try {
//                int value = Integer.parseInt(input);
//
//                if (!mortgageActive) {
//                    // Первое число после процента - сумма ипотеки
//                    debt = value;
//                    mortgageActive = true;
//                    System.out.println("Начальная сумма ипотеки: " + debt + ", процент: " + percent + "%");
//                } else {
//                    // Последующие числа - платежи
//                    int payment = value;
//
//                    // Если есть остаток на счете, используем его для платежа
//                    if (deposit > 0) {
//                        if (deposit >= payment) {
//                            // Хватает средств на счете
//                            deposit -= payment;
//                            System.out.println("Платеж " + payment + " списан со счета. Остаток на счете: " + deposit);
//                        } else {
//                            // Не хватает средств на счете
//                            payment -= deposit;
//                            deposit = 0;
//                            System.out.println("Часть платежа списана со счета. Оставшийся платеж: " + payment);
//                        }
//                    }
//
//                    // Проверяет, нужно ли делать платеж извне
//                    if (payment > 0) {
//                        if (payment >= debt) {
//                            // Платеж закрывает ипотеку
//                            deposit = payment - debt;
//                            debt = 0;
//                            System.out.println("Home! Sweet Home");
//                            System.out.println("Остаток на счете: " + deposit);
//                            mortgageActive = false;
//                            percentSet = false; // Сбрасываем флаг процента после погашения ипотеки
//                        } else {
//                            // Частичный платеж
//                            debt -= payment;
//
//                            // Начисляем проценты (округление вверх)
//                            if (debt > 0 && percent > 0) {
//                                double interest = debt * (percent / 100.0);
//                                int roundedInterest = (int) Math.ceil(interest);
//                                debt += roundedInterest;
//                                System.out.println("Начислены проценты: " + roundedInterest);
//                            }
//                            System.out.println("Остаток долга: " + debt);
//                        }
//                    }
//                }
//            } catch (NumberFormatException e) {
//                // Если ввод не является числом и не командой stop - игнорируем
//                System.out.println("Неверный формат ввода. Ожидается число или 'stop'");
//            }
//        }
//
//        scanner.close();
//        System.out.println("Программа завершена.");
//    }
//}

import java.util.Scanner;

public class lab4_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int debt = 0; // остаток долга
        int deposit = 0; // остаток на счете
        int percent = 0; // процентная ставка
        boolean mortgageActive = false; // Флаг активной ипотеки
        boolean percentSet = false; // Флаг установки процента

        System.out.println("Вводите данные (процент, сумму ипотеки, платежи) или 'stop' для завершения:");

        while (true) {
            String input = scanner.nextLine().trim();

            // Проверка на команду stop
            if (input.equalsIgnoreCase("stop")) {
                if (debt > 0) {
                    System.out.println("Debt amount " + debt);
                } else if (deposit > 0) {
                    System.out.println("Deposit amount " + deposit);
                }
                break;
            }

            // Проверка на процент (строка содержит %)
            if (input.contains("%")) {
                try {
                    // Извлекаем число перед символом %
                    String percentStr = input.substring(0, input.indexOf("%")).trim();
                    int newPercent = Integer.parseInt(percentStr);

                    if (percentSet) {
                        // Если процент уже был установлен, игнорируем новый процент
                        System.out.println("Процент игнорируется - процент уже установлен");
                    } else {
                        percent = newPercent;
                        percentSet = true;
                        System.out.println("Установлен процент: " + percent + "%");
                    }
                } catch (NumberFormatException e) {
                    // Неверный формат процента - игнорируем
                    System.out.println("Неверный формат процента");
                }
                continue;
            }

            // Проверка на число
            try {
                int value = Integer.parseInt(input);

                if (!mortgageActive) {
                    // Первое число после процента - сумма ипотеки
                    int mortgageAmount = value;

                    // Используем остаток на счете для новой ипотеки
                    if (deposit > 0) {
                        if (deposit >= mortgageAmount) {
                            // Хватает средств на счете для полной оплаты ипотеки
                            deposit -= mortgageAmount;
                            debt = 0;
                            System.out.println("Ипотека полностью оплачена со счета! Остаток на счете: " + deposit);
                            System.out.println("Home! Sweet Home");
                        } else {
                            // Частичная оплата ипотеки со счета
                            debt = mortgageAmount - deposit;
                            deposit = 0;
                            mortgageActive = true;
                            System.out.println("Часть ипотеки оплачена со счета. Начальная сумма ипотеки: " + debt + ", процент: " + percent + "%");
                        }
                    } else {
                        // Нет средств на счете - обычная ипотека
                        debt = mortgageAmount;
                        mortgageActive = true;
                        System.out.println("Начальная сумма ипотеки: " + debt + ", процент: " + percent + "%");
                    }
                } else {
                    // Последующие числа - платежи
                    int payment = value;

                    // Если есть остаток на счете, используем его для платежа
                    if (deposit > 0) {
                        if (deposit >= payment) {
                            // Хватает средств на счете
                            deposit -= payment;
                            System.out.println("Платеж " + payment + " списан со счета. Остаток на счете: " + deposit);
                        } else {
                            // Не хватает средств на счете
                            payment -= deposit;
                            deposit = 0;
                            System.out.println("Часть платежа списана со счета. Оставшийся платеж: " + payment);
                        }
                    }

                    // Проверяет, нужно ли делать платеж извне
                    if (payment > 0) {
                        if (payment >= debt) {
                            // Платеж закрывает ипотеку
                            deposit = payment - debt; // Остаток идет на счет
                            debt = 0;
                            System.out.println("Home! Sweet Home");
                            System.out.println("Остаток на счете: " + deposit);
                            mortgageActive = false;
                            percentSet = false; // Сбрасываем флаг процента после погашения ипотеки
                        } else {
                            // Частичный платеж
                            debt -= payment;

                            // Начисляем проценты (округление вверх)
                            if (debt > 0 && percent > 0) {
                                double interest = debt * (percent / 100.0);
                                int roundedInterest = (int) Math.ceil(interest);
                                debt += roundedInterest;
                                System.out.println("Начислены проценты: " + roundedInterest);
                            }
                            System.out.println("Остаток долга: " + debt);
                        }
                    }
                }
            } catch (NumberFormatException e) {
                // Если ввод не является числом и не командой stop - игнорируем
                System.out.println("Неверный формат ввода. Ожидается число или 'stop'");
            }
        }

        scanner.close();
        System.out.println("Программа завершена.");
    }
}