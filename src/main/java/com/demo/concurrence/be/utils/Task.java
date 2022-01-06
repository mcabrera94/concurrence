package com.demo.concurrence.be.utils;

public class Task extends Thread {

    private int id;

    private int[] listNumbers;

    private String operator;

    private double value;

    double product = 1;

    boolean flag;

    public Task(int id, int[] listNumbers, String operator){
        this.id = id;
        this.listNumbers = listNumbers;
        this.operator = operator;
    }

    @Override
    public void run() {
        for (int i = 0; i < listNumbers.length ; i++  ) {
            switch (operator){
                case "+":
                    value += listNumbers[i];
                    break;
                case "-":
                    product = (!flag) ? listNumbers[0] : product;
                    int subPos = i + 1;
                    if (listNumbers.length > subPos) {
                        product = product - listNumbers[i + 1];
                        value =  (float) product;
                        flag = true;
                    }
                    break;
                case "*":
                    if (value == 0) {
                        for(float value : listNumbers) { product *= value; }
                        value = product;
                    }
                    break;
                case "/":
                    product = (!flag) ? listNumbers[0] : product;
                    int divPos = i + 1;
                    if (listNumbers.length > divPos) {
                        product = product / listNumbers[i + 1];
                        value =  (float) product;
                        flag = true;
                    }
                    break;
            }
        }
    }

    public double getValue() {
        return value;
    }



}
