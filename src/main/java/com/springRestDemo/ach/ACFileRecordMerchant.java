package com.springRestDemo.ach;

// 1002
public class ACFileRecordMerchant extends ACRecord {

    private ACRecordStartEndLength<Integer> transactionIdentifier = new ACRecordStartEndLength<>(5, 11, Integer.class);
    private ACRecordStartEndLength<String> merchantName = new ACRecordStartEndLength<>(58, 87, String.class);
    private ACRecordStartEndLength<String> merchantAddress1 = new ACRecordStartEndLength<>(88, 127, String.class);
    private ACRecordStartEndLength<String> merchantAddress2 = new ACRecordStartEndLength<>(128, 167, String.class);
    private ACRecordStartEndLength<String> merchantCity = new ACRecordStartEndLength<>(168, 182, String.class);
    private ACRecordStartEndLength<String> merchantPostalCode = new ACRecordStartEndLength<>(183, 192, String.class);
    private ACRecordStartEndLength<String> merchantState = new ACRecordStartEndLength<>(193, 195, String.class);
    private ACRecordStartEndLength<String> customerIDOrSubAccountNumber = new ACRecordStartEndLength<>(487, 500, String.class);

    public ACFileRecordMerchant() {
    }

    public ACFileRecordMerchant(String record) {
        parseRecord(record);
    }

    private void parseRecord(String record) {
        transactionIdentifier.setValue(record);
        merchantName.setValue(record);
        merchantAddress1.setValue(record);
        merchantAddress2.setValue(record);
        merchantCity.setValue(record);
        merchantPostalCode.setValue(record);
        merchantState.setValue(record);
        customerIDOrSubAccountNumber.setValue(record);
    }

    public ACRecordStartEndLength<Integer> getTransactionIdentifier() {
        return transactionIdentifier;
    }

    public void setTransactionIdentifier(ACRecordStartEndLength<Integer> transactionIdentifier) {
        this.transactionIdentifier = transactionIdentifier;
    }

    public ACRecordStartEndLength<String> getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(ACRecordStartEndLength<String> merchantName) {
        this.merchantName = merchantName;
    }

    public ACRecordStartEndLength<String> getMerchantAddress1() {
        return merchantAddress1;
    }

    public void setMerchantAddress1(ACRecordStartEndLength<String> merchantAddress1) {
        this.merchantAddress1 = merchantAddress1;
    }

    public ACRecordStartEndLength<String> getMerchantAddress2() {
        return merchantAddress2;
    }

    public void setMerchantAddress2(ACRecordStartEndLength<String> merchantAddress2) {
        this.merchantAddress2 = merchantAddress2;
    }

    public ACRecordStartEndLength<String> getMerchantCity() {
        return merchantCity;
    }

    public void setMerchantCity(ACRecordStartEndLength<String> merchantCity) {
        this.merchantCity = merchantCity;
    }

    public ACRecordStartEndLength<String> getMerchantPostalCode() {
        return merchantPostalCode;
    }

    public void setMerchantPostalCode(ACRecordStartEndLength<String> merchantPostalCode) {
        this.merchantPostalCode = merchantPostalCode;
    }

    public ACRecordStartEndLength<String> getMerchantState() {
        return merchantState;
    }

    public void setMerchantState(ACRecordStartEndLength<String> merchantState) {
        this.merchantState = merchantState;
    }

    public ACRecordStartEndLength<String> getCustomerIDOrSubAccountNumber() {
        return customerIDOrSubAccountNumber;
    }

    public void setCustomerIDOrSubAccountNumber(ACRecordStartEndLength<String> customerIDOrSubAccountNumber) {
        this.customerIDOrSubAccountNumber = customerIDOrSubAccountNumber;
    }
}
