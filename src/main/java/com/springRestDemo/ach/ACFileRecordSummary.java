package com.springRestDemo.ach;

import org.springframework.util.StringUtils;

// 1001
public class ACFileRecordSummary extends ACRecord {

    private ACRecordStartEndLength<Integer> transactionIdentifier = new ACRecordStartEndLength<>(5, 11, Integer.class);
    private ACRecordStartEndLength<String> customerAccountCode = new ACRecordStartEndLength<>(27, 40, String.class);
    private ACRecordStartEndLength<String> customerIDOrSubAccountNumber = new ACRecordStartEndLength<>(41, 54, String.class);
    private ACRecordStartEndLength<String> creditOrDebit = new ACRecordStartEndLength<>(55, 55, String.class);
    private ACRecordStartEndLength<Integer> conversionRate = new ACRecordStartEndLength<>(63, 72, Integer.class);
    private ACRecordStartEndLength<Integer> transactionDate = new ACRecordStartEndLength<>(74, 79, Integer.class);
    private ACRecordStartEndLength<Integer> transactionTime = new ACRecordStartEndLength<>(80, 85, Integer.class);
    private ACRecordStartEndLength<Integer> postedDate = new ACRecordStartEndLength<>(86, 91, Integer.class);
    private ACRecordStartEndLength<Integer> postedTime = new ACRecordStartEndLength<>(92, 97, Integer.class);
    private ACRecordStartEndLength<Integer> totalAmountDueNet = new ACRecordStartEndLength<>(173, 183, Integer.class);
    private ACRecordStartEndLength<Integer> legacyDiscountAmount = new ACRecordStartEndLength<>(184, 190, Integer.class);
    private ACRecordStartEndLength<Integer> transactionFees = new ACRecordStartEndLength<>(191, 198, Integer.class);
    private ACRecordStartEndLength<String> cardNumber = new ACRecordStartEndLength<>(200, 215, String.class);
    private ACRecordStartEndLength<String> idMatchNumber = new ACRecordStartEndLength<>(236, 245, String.class);
    private ACRecordStartEndLength<String> transactionTimeIndicator = new ACRecordStartEndLength<>(448, 450, String.class);
    private ACRecordStartEndLength<String> cardToken = new ACRecordStartEndLength<>(470, 479, String.class);

    public ACFileRecordSummary() {
    }

    public ACFileRecordSummary(String record) {
        parseRecord(record);
    }

    private void parseRecord(String record) {
        transactionIdentifier.setValue(record);
        customerAccountCode.setValue(record);
        customerIDOrSubAccountNumber.setValue(record);
        creditOrDebit.setValue(record);
        conversionRate.setValue(record);
        transactionDate.setValue(record);
        transactionTime.setValue(record);
        postedDate.setValue(record);
        postedTime.setValue(record);
        totalAmountDueNet.setValue(record);
        legacyDiscountAmount.setValue(record);
        transactionFees.setValue(record);
        cardNumber.setValue(record);
        idMatchNumber.setValue(record);
        transactionTimeIndicator.setValue(record);
        cardToken.setValue(record);
        examineValue();
    }

    private void examineValue() {
        if (creditOrDebit.getValue() != null || !StringUtils.isEmpty(creditOrDebit.getValue())) {
            CreditDebitEnum creditDebitEnum = CreditDebitEnum.findByCurrencyIndicator(creditOrDebit.getValue());
            if (creditDebitEnum == null) {
                creditOrDebit.setValue("");
            }
        }
    }

    public ACRecordStartEndLength<Integer> getTransactionIdentifier() {
        return transactionIdentifier;
    }

    public void setTransactionIdentifier(ACRecordStartEndLength<Integer> transactionIdentifier) {
        this.transactionIdentifier = transactionIdentifier;
    }

    public ACRecordStartEndLength<String> getCustomerAccountCode() {
        return customerAccountCode;
    }

    public void setCustomerAccountCode(ACRecordStartEndLength<String> customerAccountCode) {
        this.customerAccountCode = customerAccountCode;
    }

    public ACRecordStartEndLength<String> getCustomerIDOrSubAccountNumber() {
        return customerIDOrSubAccountNumber;
    }

    public void setCustomerIDOrSubAccountNumber(ACRecordStartEndLength<String> customerIDOrSubAccountNumber) {
        this.customerIDOrSubAccountNumber = customerIDOrSubAccountNumber;
    }

    public ACRecordStartEndLength<String> getCreditOrDebit() {
        return creditOrDebit;
    }

    public void setCreditOrDebit(ACRecordStartEndLength<String> creditOrDebit) {
        this.creditOrDebit = creditOrDebit;
    }

    public ACRecordStartEndLength<Integer> getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(ACRecordStartEndLength<Integer> conversionRate) {
        this.conversionRate = conversionRate;
    }

    public ACRecordStartEndLength<Integer> getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(ACRecordStartEndLength<Integer> transactionDate) {
        this.transactionDate = transactionDate;
    }

    public ACRecordStartEndLength<Integer> getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(ACRecordStartEndLength<Integer> transactionTime) {
        this.transactionTime = transactionTime;
    }

    public ACRecordStartEndLength<Integer> getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(ACRecordStartEndLength<Integer> postedDate) {
        this.postedDate = postedDate;
    }

    public ACRecordStartEndLength<Integer> getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(ACRecordStartEndLength<Integer> postedTime) {
        this.postedTime = postedTime;
    }

    public ACRecordStartEndLength<Integer> getTotalAmountDueNet() {
        return totalAmountDueNet;
    }

    public void setTotalAmountDueNet(ACRecordStartEndLength<Integer> totalAmountDueNet) {
        this.totalAmountDueNet = totalAmountDueNet;
    }

    public ACRecordStartEndLength<Integer> getLegacyDiscountAmount() {
        return legacyDiscountAmount;
    }

    public void setLegacyDiscountAmount(ACRecordStartEndLength<Integer> legacyDiscountAmount) {
        this.legacyDiscountAmount = legacyDiscountAmount;
    }

    public ACRecordStartEndLength<Integer> getTransactionFees() {
        return transactionFees;
    }

    public void setTransactionFees(ACRecordStartEndLength<Integer> transactionFees) {
        this.transactionFees = transactionFees;
    }

    public ACRecordStartEndLength<String> getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(ACRecordStartEndLength<String> cardNumber) {
        this.cardNumber = cardNumber;
    }

    public ACRecordStartEndLength<String> getIdMatchNumber() {
        return idMatchNumber;
    }

    public void setIdMatchNumber(ACRecordStartEndLength<String> idMatchNumber) {
        this.idMatchNumber = idMatchNumber;
    }

    public ACRecordStartEndLength<String> getTransactionTimeIndicator() {
        return transactionTimeIndicator;
    }

    public void setTransactionTimeIndicator(ACRecordStartEndLength<String> transactionTimeIndicator) {
        this.transactionTimeIndicator = transactionTimeIndicator;
    }

    public ACRecordStartEndLength<String> getCardToken() {
        return cardToken;
    }

    public void setCardToken(ACRecordStartEndLength<String> cardToken) {
        this.cardToken = cardToken;
    }
}
