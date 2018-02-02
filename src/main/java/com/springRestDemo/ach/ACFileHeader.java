package com.springRestDemo.ach;

// 1000
public class ACFileHeader extends ACRecord {

    private ACRecordStartEndLength<String> customerAccountCode = new ACRecordStartEndLength<>(5, 18, String.class);
    private ACRecordStartEndLength<String> accountName = new ACRecordStartEndLength<>(19, 48, String.class);
    private ACRecordStartEndLength<Integer> processDate = new ACRecordStartEndLength<>(49, 54, Integer.class);

    public ACFileHeader() {

    }

    public ACFileHeader(String record) {
        parseRecord(record);
    }

    private void parseRecord(String record) {
        customerAccountCode.setValue(record);
        accountName.setValue(record);
        processDate.setValue(record);
    }

    public ACRecordStartEndLength<String> getCustomerAccountCode() {
        return customerAccountCode;
    }

    public void setCustomerAccountCode(ACRecordStartEndLength<String> customerAccountCode) {
        this.customerAccountCode = customerAccountCode;
    }

    public ACRecordStartEndLength<String> getAccountName() {
        return accountName;
    }

    public void setAccountName(ACRecordStartEndLength<String> accountName) {
        this.accountName = accountName;
    }

    public ACRecordStartEndLength<Integer> getProcessDate() {
        return processDate;
    }

    public void setProcessDate(ACRecordStartEndLength<Integer> processDate) {
        this.processDate = processDate;
    }
}
