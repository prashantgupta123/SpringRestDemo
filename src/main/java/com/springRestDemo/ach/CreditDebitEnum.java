package com.springRestDemo.ach;

public enum CreditDebitEnum {
    credit("C"),
    debit("D");

    String val;

    CreditDebitEnum(String val) {
        this.val = val;
    }
}
