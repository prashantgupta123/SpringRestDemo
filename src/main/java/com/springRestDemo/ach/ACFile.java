package com.springRestDemo.ach;

import java.util.ArrayList;
import java.util.List;

public class ACFile {

    private ACFileHeader fileHeader = new ACFileHeader();
    private List<ACFileRecord> fileRecords = new ArrayList<>();
    private ACFileTrailer fileTrailer = new ACFileTrailer();

    public ACFileHeader getFileHeader() {
        return fileHeader;
    }

    public void setFileHeader(ACFileHeader fileHeader) {
        this.fileHeader = fileHeader;
    }

    public List<ACFileRecord> getFileRecords() {
        return fileRecords;
    }

    public void setFileRecords(List<ACFileRecord> fileRecords) {
        this.fileRecords = fileRecords;
    }

    public ACFileTrailer getFileTrailer() {
        return fileTrailer;
    }

    public void setFileTrailer(ACFileTrailer fileTrailer) {
        this.fileTrailer = fileTrailer;
    }

}
