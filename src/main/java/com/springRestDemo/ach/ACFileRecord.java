package com.springRestDemo.ach;

public class ACFileRecord {

    private ACFileRecordSummary fileRecordSummaries = new ACFileRecordSummary();
    private ACFileRecordMerchant fileRecordMerchants = new ACFileRecordMerchant();
    private ACFileRecordCardVehicle fileRecordCardVehicles = new ACFileRecordCardVehicle();
    private ACFileRecordProductDetail fileRecordProductDetail = new ACFileRecordProductDetail();

    public ACFileRecordSummary getFileRecordSummaries() {
        return fileRecordSummaries;
    }

    public void setFileRecordSummaries(ACFileRecordSummary fileRecordSummaries) {
        this.fileRecordSummaries = fileRecordSummaries;
    }

    public ACFileRecordMerchant getFileRecordMerchants() {
        return fileRecordMerchants;
    }

    public void setFileRecordMerchants(ACFileRecordMerchant fileRecordMerchants) {
        this.fileRecordMerchants = fileRecordMerchants;
    }

    public ACFileRecordCardVehicle getFileRecordCardVehicles() {
        return fileRecordCardVehicles;
    }

    public void setFileRecordCardVehicles(ACFileRecordCardVehicle fileRecordCardVehicles) {
        this.fileRecordCardVehicles = fileRecordCardVehicles;
    }

    public ACFileRecordProductDetail getFileRecordProductDetail() {
        return fileRecordProductDetail;
    }

    public void setFileRecordProductDetail(ACFileRecordProductDetail fileRecordProductDetail) {
        this.fileRecordProductDetail = fileRecordProductDetail;
    }
}
