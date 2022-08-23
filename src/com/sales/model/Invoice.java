package com.sales.model;

import java.util.ArrayList;

public class Invoice {

    private int num;
    private String date;
    private String customer;
    private double invoiceTotal;
    private ArrayList<Line> lines;

    public Invoice() {
    }

    public Invoice(int num, String date, String customer) {
        this.num = num;
        this.date = date;
        this.customer = customer;
    }

    public ArrayList<Line> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public double getInvoiceTotal() {
        double total = 0.0;
        for (Line line : getLines()) {
            total = total + line.getLineTotal();
        }
        return total;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" + "num=" + num + ", date=" + date + ", customer=" + customer + '}';
    }

    /**
     *
     * @return
     */
    public String getAsCSV() {
        return num + "," + date + "," + customer;
    }
}
