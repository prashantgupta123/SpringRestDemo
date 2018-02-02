package com.springRestDemo.controller;

import com.springRestDemo.ach.ACFile;
import com.springRestDemo.dto.response.AbstractResponseDto;
import com.springRestDemo.service.TestingService;
import com.springRestDemo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestingController {

    @Autowired
    private TestingService testingService;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<AbstractResponseDto> home(@RequestParam String filename) {
        ACFile parseFileData = new ACFile();
        try {
            parseFileData = testingService.parseFile(filename);
        } catch (Exception e) {
            System.out.println("Exception in parsing file");
        }
        Map<String, String> map = new HashMap<>();
        map.put("1", "ONE");
        map.put("2", "TWO");
        map.put("3", "THREE");
        return ResponseUtil.success().body(parseFileData).send(HttpStatus.OK, "Response map fetch successfully");
    }
}
