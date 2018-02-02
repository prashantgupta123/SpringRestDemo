package com.springRestDemo.ach;

public enum CreditDebitEnum {
    CREDIT("C"),
    DEBIT("D");

    String value;

    CreditDebitEnum(String value) {
        this.value = value;
    }

    public static CreditDebitEnum findByCurrencyIndicator(String val) {
        for (CreditDebitEnum v : values()) {
            if (v.getValue().equals(val)) {
                return v;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
