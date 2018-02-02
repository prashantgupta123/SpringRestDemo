package com.springRestDemo.ach;

// 9999
public class ACFileTrailer extends ACRecord {

    private ACRecordStartEndLength<Integer> transactionCount = new ACRecordStartEndLength<>(71, 77, Integer.class);
    private ACRecordStartEndLength<Integer> recordCount = new ACRecordStartEndLength<>(78, 84, Integer.class);
    private ACRecordStartEndLength<Integer> usdBaseBillingCurrency = new ACRecordStartEndLength<>(85, 95, Integer.class);
    private ACRecordStartEndLength<String> usdBaseBillingCurrencyIndicator = new ACRecordStartEndLength<>(96, 96, String.class);
    private ACRecordStartEndLength<Integer> nonUsdBaseBillingCurrency = new ACRecordStartEndLength<>(97, 107, Integer.class);
    private ACRecordStartEndLength<String> nonUsdBaseBillingCurrencyIndicator = new ACRecordStartEndLength<>(108, 108, String.class);

    public ACFileTrailer() {
    }

    public ACFileTrailer(String record) {
        parseRecord(record);
    }

    private void parseRecord(String record) {
        transactionCount.setValue(record);
        recordCount.setValue(record);
        usdBaseBillingCurrency.setValue(record);
        usdBaseBillingCurrencyIndicator.setValue(record);
        nonUsdBaseBillingCurrency.setValue(record);
        nonUsdBaseBillingCurrencyIndicator.setValue(record);
    }

    public ACRecordStartEndLength<Integer> getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(ACRecordStartEndLength<Integer> transactionCount) {
        this.transactionCount = transactionCount;
    }

    public ACRecordStartEndLength<Integer> getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(ACRecordStartEndLength<Integer> recordCount) {
        this.recordCount = recordCount;
    }

    public ACRecordStartEndLength<Integer> getUsdBaseBillingCurrency() {
        return usdBaseBillingCurrency;
    }

    public void setUsdBaseBillingCurrency(ACRecordStartEndLength<Integer> usdBaseBillingCurrency) {
        this.usdBaseBillingCurrency = usdBaseBillingCurrency;
    }

    public ACRecordStartEndLength<String> getUsdBaseBillingCurrencyIndicator() {
        return usdBaseBillingCurrencyIndicator;
    }

    public void setUsdBaseBillingCurrencyIndicator(ACRecordStartEndLength<String> usdBaseBillingCurrencyIndicator) {
        this.usdBaseBillingCurrencyIndicator = usdBaseBillingCurrencyIndicator;
    }

    public ACRecordStartEndLength<Integer> getNonUsdBaseBillingCurrency() {
        return nonUsdBaseBillingCurrency;
    }

    public void setNonUsdBaseBillingCurrency(ACRecordStartEndLength<Integer> nonUsdBaseBillingCurrency) {
        this.nonUsdBaseBillingCurrency = nonUsdBaseBillingCurrency;
    }

    public ACRecordStartEndLength<String> getNonUsdBaseBillingCurrencyIndicator() {
        return nonUsdBaseBillingCurrencyIndicator;
    }

    public void setNonUsdBaseBillingCurrencyIndicator(ACRecordStartEndLength<String> nonUsdBaseBillingCurrencyIndicator) {
        this.nonUsdBaseBillingCurrencyIndicator = nonUsdBaseBillingCurrencyIndicator;
    }
}
