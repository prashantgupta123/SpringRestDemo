package com.springRestDemo.controller;

import com.springRestDemo.dto.response.AbstractResponseDto;
import com.springRestDemo.service.SpringRestClientService;
import com.springRestDemo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private SpringRestClientService springRestClientService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<AbstractResponseDto> home() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "ONE");
        map.put("2", "TWO");
        map.put("3", "THREE");
        return ResponseUtil.success().body(map).send(HttpStatus.OK, "Response map fetch successfully");
    }

    @RequestMapping(value = "/basic", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getRestDataUsingBasicAuthentication() {
        return springRestClientService.getRestDataUsingBasicAuthentication();
    }

    @RequestMapping(value = "/token", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getRestDataUsingTokenAuthentication() {
        return springRestClientService.getRestDataUsingTokenAuthentication();
    }

    @RequestMapping(value = "/userToken", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getRestDataUsingUsernamePasswordTokenAuthentication() {
        return springRestClientService.getRestDataUsingUsernamePasswordTokenAuthentication();
    }

}
