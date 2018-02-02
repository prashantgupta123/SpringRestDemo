package com.springRestDemo.ach;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ACRecord {

    private String recordTypeCode = "    ";

    public final static String FILE_HEADER = "1000";
    public final static String FILE_SUMMARY = "1001";
    public final static String FILE_MERCHANT = "1002";
    public final static String FILE_CARD_VEHICLE = "1003";
    public final static String FILE_PRODUCT_DETAIL = "1006";
    public final static String FILE_TRAILER = "9999";

    public ACRecord() {

    }

    public static ACRecord parseACRecord(ACRecord achRecord, String record) {
        if (achRecord.isFileHeaderType()) {
            return new ACFileHeader(record);
        } else if (achRecord.isFileSummaryType()) {
            return new ACFileRecordSummary(record);
        } else if (achRecord.isFileMerchantType()) {
            return new ACFileRecordMerchant(record);
        } else if (achRecord.isFileCardVehicleType()) {
            return new ACFileRecordCardVehicle(record);
        } else if (achRecord.isFileProductDetailType()) {
            return new ACFileRecordProductDetail(record);
        } else if (achRecord.isFileTrailerType()) {
            return new ACFileTrailer(record);
        }
        return achRecord;
    }

    public ACRecord(String record) {
        if (record == null || record.length() == 0) {
            return;
        }
        setRecordTypeCode(record.substring(0, 4));
    }

    public void setRecordTypeCode(String recordTypeCode) {
        this.recordTypeCode = recordTypeCode;
    }

    @JsonIgnore
    public String getRecordTypeCode() {
        return recordTypeCode;
    }

    @JsonIgnore
    public boolean isFileHeaderType() {
        return recordTypeCode.equals(FILE_HEADER);
    }

    @JsonIgnore
    public boolean isFileSummaryType() {
        return recordTypeCode.equals(FILE_SUMMARY);
    }

    @JsonIgnore
    public boolean isFileMerchantType() {
        return recordTypeCode.equals(FILE_MERCHANT);
    }

    @JsonIgnore
    public boolean isFileCardVehicleType() {
        return recordTypeCode.equals(FILE_CARD_VEHICLE);
    }

    @JsonIgnore
    public boolean isFileProductDetailType() {
        return recordTypeCode.equals(FILE_PRODUCT_DETAIL);
    }

    @JsonIgnore
    public boolean isFileTrailerType() {
        return recordTypeCode.equals(FILE_TRAILER);
    }
}
