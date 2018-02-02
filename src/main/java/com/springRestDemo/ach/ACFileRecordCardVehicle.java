package com.springRestDemo.ach;

// 1003
public class ACFileRecordCardVehicle extends ACRecord {

    private ACRecordStartEndLength<Integer> transactionIdentifier = new ACRecordStartEndLength<>(5, 11, Integer.class);
    private ACRecordStartEndLength<String> cardAssignedEmployeeNumber = new ACRecordStartEndLength<>(48, 63, String.class);
    private ACRecordStartEndLength<String> miscHash1 = new ACRecordStartEndLength<>(220, 234, String.class);
    private ACRecordStartEndLength<String> customerIdOrSubAccountNumber = new ACRecordStartEndLength<>(487, 500, String.class);

    public ACFileRecordCardVehicle() {
    }

    public ACFileRecordCardVehicle(String record) {
        parseRecord(record);
    }

    private void parseRecord(String record) {
        transactionIdentifier.setValue(record);
        cardAssignedEmployeeNumber.setValue(record);
        miscHash1.setValue(record);
        customerIdOrSubAccountNumber.setValue(record);
    }

    public ACRecordStartEndLength<Integer> getTransactionIdentifier() {
        return transactionIdentifier;
    }

    public void setTransactionIdentifier(ACRecordStartEndLength<Integer> transactionIdentifier) {
        this.transactionIdentifier = transactionIdentifier;
    }

    public ACRecordStartEndLength<String> getCardAssignedEmployeeNumber() {
        return cardAssignedEmployeeNumber;
    }

    public void setCardAssignedEmployeeNumber(ACRecordStartEndLength<String> cardAssignedEmployeeNumber) {
        this.cardAssignedEmployeeNumber = cardAssignedEmployeeNumber;
    }

    public ACRecordStartEndLength<String> getMiscHash1() {
        return miscHash1;
    }

    public void setMiscHash1(ACRecordStartEndLength<String> miscHash1) {
        this.miscHash1 = miscHash1;
    }

    public ACRecordStartEndLength<String> getCustomerIdOrSubAccountNumber() {
        return customerIdOrSubAccountNumber;
    }

    public void setCustomerIdOrSubAccountNumber(ACRecordStartEndLength<String> customerIdOrSubAccountNumber) {
        this.customerIdOrSubAccountNumber = customerIdOrSubAccountNumber;
    }
}
