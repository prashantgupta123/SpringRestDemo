package com.springRestDemo.ach;

// 1006
public class ACFileRecordProductDetail extends ACRecord {

    private ACRecordStartEndLength<Integer> transactionIdentifier = new ACRecordStartEndLength<>(5, 11, Integer.class);
    private ACRecordStartEndLength<String> creditOrDebit = new ACRecordStartEndLength<>(12, 12, String.class);
    private ACRecordStartEndLength<String> productCode = new ACRecordStartEndLength<>(15, 29, String.class);
    private ACRecordStartEndLength<String> productDescription = new ACRecordStartEndLength<>(30, 64, String.class);
    private ACRecordStartEndLength<Integer> productQuantity = new ACRecordStartEndLength<>(65, 76, Integer.class);
    private ACRecordStartEndLength<Integer> productPriceNetDue = new ACRecordStartEndLength<>(77, 86, Integer.class);
    private ACRecordStartEndLength<Integer> productTotalCostNetDue = new ACRecordStartEndLength<>(87, 95, Integer.class);
    private ACRecordStartEndLength<String> merchantDiscountIndicator = new ACRecordStartEndLength<>(96, 96, String.class);
    private ACRecordStartEndLength<Integer> merchantDiscountAmountNet = new ACRecordStartEndLength<>(97, 105, Integer.class);
    private ACRecordStartEndLength<Integer> grossPrice = new ACRecordStartEndLength<>(312, 323, Integer.class);
    private ACRecordStartEndLength<Integer> grossTotalCost = new ACRecordStartEndLength<>(324, 333, Integer.class);
    private ACRecordStartEndLength<String> rebateIndicator = new ACRecordStartEndLength<>(473, 473, String.class);
    private ACRecordStartEndLength<Integer> rebateAmountNet = new ACRecordStartEndLength<>(474, 482, Integer.class);
    private ACRecordStartEndLength<String> customerIDOrSubAccountNumber = new ACRecordStartEndLength<>(487, 500, String.class);

    public ACFileRecordProductDetail() {
    }

    public ACFileRecordProductDetail(String record) {
        parseRecord(record);
    }

    private void parseRecord(String record) {
        transactionIdentifier.setValue(record);
        creditOrDebit.setValue(record);
        productCode.setValue(record);
        productDescription.setValue(record);
        productQuantity.setValue(record);
        productPriceNetDue.setValue(record);
        productTotalCostNetDue.setValue(record);
        merchantDiscountIndicator.setValue(record);
        merchantDiscountAmountNet.setValue(record);
        grossPrice.setValue(record);
        grossTotalCost.setValue(record);
        rebateIndicator.setValue(record);
        rebateAmountNet.setValue(record);
        customerIDOrSubAccountNumber.setValue(record);
    }

    public ACRecordStartEndLength<Integer> getTransactionIdentifier() {
        return transactionIdentifier;
    }

    public void setTransactionIdentifier(ACRecordStartEndLength<Integer> transactionIdentifier) {
        this.transactionIdentifier = transactionIdentifier;
    }

    public ACRecordStartEndLength<String> getCreditOrDebit() {
        return creditOrDebit;
    }

    public void setCreditOrDebit(ACRecordStartEndLength<String> creditOrDebit) {
        this.creditOrDebit = creditOrDebit;
    }

    public ACRecordStartEndLength<String> getProductCode() {
        return productCode;
    }

    public void setProductCode(ACRecordStartEndLength<String> productCode) {
        this.productCode = productCode;
    }

    public ACRecordStartEndLength<String> getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ACRecordStartEndLength<String> productDescription) {
        this.productDescription = productDescription;
    }

    public ACRecordStartEndLength<Integer> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(ACRecordStartEndLength<Integer> productQuantity) {
        this.productQuantity = productQuantity;
    }

    public ACRecordStartEndLength<Integer> getProductPriceNetDue() {
        return productPriceNetDue;
    }

    public void setProductPriceNetDue(ACRecordStartEndLength<Integer> productPriceNetDue) {
        this.productPriceNetDue = productPriceNetDue;
    }

    public ACRecordStartEndLength<Integer> getProductTotalCostNetDue() {
        return productTotalCostNetDue;
    }

    public void setProductTotalCostNetDue(ACRecordStartEndLength<Integer> productTotalCostNetDue) {
        this.productTotalCostNetDue = productTotalCostNetDue;
    }

    public ACRecordStartEndLength<String> getMerchantDiscountIndicator() {
        return merchantDiscountIndicator;
    }

    public void setMerchantDiscountIndicator(ACRecordStartEndLength<String> merchantDiscountIndicator) {
        this.merchantDiscountIndicator = merchantDiscountIndicator;
    }

    public ACRecordStartEndLength<Integer> getMerchantDiscountAmountNet() {
        return merchantDiscountAmountNet;
    }

    public void setMerchantDiscountAmountNet(ACRecordStartEndLength<Integer> merchantDiscountAmountNet) {
        this.merchantDiscountAmountNet = merchantDiscountAmountNet;
    }

    public ACRecordStartEndLength<Integer> getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(ACRecordStartEndLength<Integer> grossPrice) {
        this.grossPrice = grossPrice;
    }

    public ACRecordStartEndLength<Integer> getGrossTotalCost() {
        return grossTotalCost;
    }

    public void setGrossTotalCost(ACRecordStartEndLength<Integer> grossTotalCost) {
        this.grossTotalCost = grossTotalCost;
    }

    public ACRecordStartEndLength<String> getRebateIndicator() {
        return rebateIndicator;
    }

    public void setRebateIndicator(ACRecordStartEndLength<String> rebateIndicator) {
        this.rebateIndicator = rebateIndicator;
    }

    public ACRecordStartEndLength<Integer> getRebateAmountNet() {
        return rebateAmountNet;
    }

    public void setRebateAmountNet(ACRecordStartEndLength<Integer> rebateAmountNet) {
        this.rebateAmountNet = rebateAmountNet;
    }

    public ACRecordStartEndLength<String> getCustomerIDOrSubAccountNumber() {
        return customerIDOrSubAccountNumber;
    }

    public void setCustomerIDOrSubAccountNumber(ACRecordStartEndLength<String> customerIDOrSubAccountNumber) {
        this.customerIDOrSubAccountNumber = customerIDOrSubAccountNumber;
    }
}
