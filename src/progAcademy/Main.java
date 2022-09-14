package progAcademy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double bitCoinPrice;
        double amountOfMoney;

        System.out.println("What is Bitcoin price today?");
        bitCoinPrice = getInputValue();
        System.out.println("How much $ do you have?");
        amountOfMoney = getInputValue();
        System.out.println("You can buy " + getCalculatedAmountOfBitcoin(amountOfMoney, bitCoinPrice) + " BTC");
    }

    private static double getInputValue() {
        Scanner scanner = new Scanner(System.in);
        double inputValue = 0;

        try {
            inputValue = scanner.nextDouble();

            if (inputValue <= 0) {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println("Incorrect format, please try again");
           return getInputValue();
        }
        return inputValue;
    }

    private static String getCalculatedAmountOfBitcoin(double amountOfMoney, double bitCoinPrice) {
        double amountOfBitcoin = amountOfMoney / bitCoinPrice;

        if (amountOfBitcoin % 1 != 0) {
            return String.format("%.7f", amountOfBitcoin);
        }

        return String.valueOf(amountOfBitcoin);
    }
}

