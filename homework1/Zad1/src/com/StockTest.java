package com;

import java.util.Scanner;

public class StockTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String symbol; // symbol of stock
        String name; // name of stock
        double previousClosingPrice; // previous closing price of stock
        double currentPrice; // current price of stock

        //the user inputs data
        System.out.print("Enter symbol of stock: ");
        symbol = input.nextLine();

        System.out.print("Enter name of stock: ");
        name = input.nextLine();

        System.out.print("Enter previous closing price of stock: ");
        previousClosingPrice = input.nextDouble();

        System.out.print("Enter current price of stock: ");
        currentPrice = input.nextDouble();

        Stock stock = new Stock(symbol, name);

        stock.setPreviousClosingPrice(previousClosingPrice);
        stock.setCurrentPrice(currentPrice);

        System.out.println("");
        System.out.println("Stock information:");
        System.out.printf("Symbol: %s %n", stock.getSymbol());
        System.out.printf("Name: %s %n", stock.getName());
        System.out.printf("Previous closing price: %.2f%n", stock.getPreviousClosingPrice());
        System.out.printf("Current price: %.2f%n", stock.getCurrentPrice());
        System.out.printf("Difference is: %.2f%s", stock.changePercent(), "%");
    }
}
