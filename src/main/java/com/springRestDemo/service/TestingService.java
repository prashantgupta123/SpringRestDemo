package com.springRestDemo.service;

import com.springRestDemo.ach.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestingService {

    public ACFile parseFile(String filename) throws Exception {
        File achFile = new File(filename);
        if (!achFile.exists()) {
            throw new Exception("File " + achFile.getPath() + " does not exist");
        }
        if (!achFile.isFile()) {
            throw new Exception("File " + achFile.getPath() + " is not a file");
        }
        if (!achFile.canRead()) {
            throw new Exception("File " + achFile.getPath() + " cannot be read");
        }

        BufferedReader achReader = null;
        try {
            achReader = new BufferedReader(new FileReader(achFile.getPath()));
        } catch (FileNotFoundException ex) {
            throw new Exception("File " + achFile.getPath()
                    + " could not be opened. Reason " + ex.getMessage());
        }
        return parse(achReader);
    }

    private ACFile parse(BufferedReader achReader) throws Exception {
        ACFile acFile = new ACFile();
        try {
            String record = achReader.readLine();
            List<ACFileRecord> fileRecords = new ArrayList<>();
            ACFileRecord acFileRecord = null;
            int count = 1;
            int numberOfRecord = 4;
            while (record != null) {
                ACRecord achRecord = new ACRecord(record);

                if (achRecord.isFileHeaderType()) {
                    acFile.setFileHeader((ACFileHeader) ACRecord.parseACRecord(achRecord, record));
                }
                if (achRecord.isFileTrailerType()) {
                    acFile.setFileTrailer((ACFileTrailer) ACRecord.parseACRecord(achRecord, record));
                }

                if (count <= numberOfRecord) {
                    if (acFileRecord == null) {
                        acFileRecord = new ACFileRecord();
                    }

                    if (achRecord.isFileSummaryType() && count == 1) {
                        count++;
                        acFileRecord.setFileRecordSummaries((ACFileRecordSummary) ACRecord.parseACRecord(achRecord, record));
                    }
                    if (achRecord.isFileMerchantType() && count == 2) {
                        count++;
                        acFileRecord.setFileRecordMerchants((ACFileRecordMerchant) ACRecord.parseACRecord(achRecord, record));
                    }
                    if (achRecord.isFileCardVehicleType() && count == 3) {
                        count++;
                        acFileRecord.setFileRecordCardVehicles((ACFileRecordCardVehicle) ACRecord.parseACRecord(achRecord, record));
                    }
                    if (achRecord.isFileProductDetailType() && count == 4) {
                        count++;
                        acFileRecord.setFileRecordProductDetail((ACFileRecordProductDetail) ACRecord.parseACRecord(achRecord, record));
                    }
                }

                if (count > numberOfRecord) {
                    fileRecords.add(acFileRecord);
                    count = 1;
                    acFileRecord = null;
                }

                record = achReader.readLine();
            }
            acFile.setFileRecords(fileRecords);
        } catch (Exception e) {
            System.out.println("Exception in parse buffer");
        }
        return acFile;
    }
}
