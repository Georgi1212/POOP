package com;

public class Stock {
    private String symbol; // symbol of the stock
    private String name; // name of the stock
    private double previousClosingPrice; // previous closing price of the stock
    private double currentPrice; // current price of the stock

    // construct a stock with a specified symbol and a name
    public Stock(String newSymbol, String newName) {
        name = newName;
        symbol = newSymbol;
    }

    // returns symbol of the stock
    public String getSymbol() {
        return this.symbol;
    }

    // returns name of the stock
    public String getName() {
        return this.name;
    }

    // returns previous closing price of the stock
    public double getPreviousClosingPrice() {
        return this.previousClosingPrice;
    }

    // returns current price of the stock
    public double getCurrentPrice() {
        return this.currentPrice;
    }

    // sets the previous closing price of the stock
    public void setPreviousClosingPrice(double price) {
        if (price < 0) {
            previousClosingPrice = 1;
        }
        else {
            previousClosingPrice = price;
        }
    }

    // sets the current price of the stock
    public void setCurrentPrice(double price) {
        if (price < 0) {
            currentPrice = 1;
        }
        else {
            currentPrice = price;
        }
    }

    // returns the percentage of change of the stock, positive for percentage increase and negative for percentage decrease
    public double changePercent() {
        return ((currentPrice - previousClosingPrice) * 100) / previousClosingPrice;
    }
}
