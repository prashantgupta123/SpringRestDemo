package com.springRestDemo.ach;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.StringUtils;

public class ACRecordStartEndLength<T> {

    private int from = 0;
    private int to = 0;
    private int length = 0;
    private T value;
    private Class<T> clazz;

    public ACRecordStartEndLength() {
    }

    public ACRecordStartEndLength(int from, int to, int length) {
        this.from = from;
        this.to = to;
        this.length = length;
    }

    public ACRecordStartEndLength(int from, int to, Class<T> clazz) {
        this.from = from;
        this.to = to;
        this.length = to - from + 1;
        this.clazz = clazz;
    }

    @JsonIgnore
    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    @JsonIgnore
    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @JsonIgnore
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public T getValue() {
        return value;
    }

    @SuppressWarnings("unchecked")
    public void setValue(String input) {
        String parsedRecord = parseToString(input);
        if (parsedRecord != null) {
            if (clazz.isAssignableFrom(String.class)) {
                value = (T) parsedRecord;
            } else if (clazz.isAssignableFrom(Integer.class)) {
                value = (T) Integer.valueOf(parsedRecord);
            } else if (clazz.isAssignableFrom(Boolean.class)) {
                value = (T) Boolean.valueOf(parsedRecord);
            } else if (clazz.isAssignableFrom(Double.class)) {
                value = (T) Double.valueOf(parsedRecord);
            } else {
                System.out.println("Exception while setting value");
                throw new IllegalArgumentException("Bad type.");
            }
        }
    }

    private String parseToString(String record) {
        String parsedRecord = null;
        if (!StringUtils.isEmpty(record) && record.length() > from) {
            if (to > record.length()) {
                parsedRecord = record.substring(from - 1, record.length());
            } else {
                parsedRecord = record.substring(from - 1, to);
            }
        } else {
            parsedRecord = "";
        }
        return parsedRecord.replaceAll("\\s+$", "");
    }
}
