package com.springRestDemo.service;

import com.springRestDemo.constant.ApplicationConstant;
import com.springRestDemo.util.MicroServiceUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class SpringRestClientService {

    public Map getRestDataUsingBasicAuthentication() {
        String url = ApplicationConstant.REST_API_URL;
        Map data = null;

        Map<String, String> headers = basicAuthentication(ApplicationConstant.BASIC_CREDENTIAL);

        LinkedHashMap jsonObject = MicroServiceUtil.jsonGetForObject(url, LinkedHashMap.class, headers);

        if (jsonObject != null) {
            if (jsonObject.containsKey("data")) {
                data = (Map) jsonObject.get("data");
            }
        }
        return data;
    }

    private Map<String, String> basicAuthentication(String plainCredentials) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + basicAuthenticationCode(plainCredentials));
        return headers;
    }

    private String basicAuthenticationCode(String plainCredentials) {
        return new String(Base64.encodeBase64(plainCredentials.getBytes()));
    }

    public Map getRestDataUsingTokenAuthentication() {
        String url = ApplicationConstant.REST_API_URL;
        Map data = null;

        Map<String, String> headers = new HashMap<>();
        headers.put(ApplicationConstant.TOKEN_HEADER, ApplicationConstant.TOKEN);

        LinkedHashMap jsonObject = MicroServiceUtil.jsonGetForObject(url, LinkedHashMap.class, headers);

        if (jsonObject != null) {
            if (jsonObject.containsKey("data")) {
                data = (Map) jsonObject.get("data");
            }
        }
        return data;
    }

    public Map getRestDataUsingUsernamePasswordTokenAuthentication() {
        String url = ApplicationConstant.REST_API_LOGIN_URL;
        Map data = null;

        Map<String, String> pastData = new HashMap<>();
        pastData.put("username", ApplicationConstant.USERNAME);
        pastData.put("password", ApplicationConstant.PASSWORD);

        ResponseEntity responseEntity = MicroServiceUtil.jsonRequestForObjectEntity(url, HttpMethod.POST, pastData, LinkedHashMap.class, null);

        if (responseEntity.getStatusCode() != HttpStatus.NOT_FOUND) {

            Map<String, String> headers = new HashMap<>();
            String token = responseEntity.getHeaders().get(ApplicationConstant.TOKEN_HEADER).get(0);
            headers.put(ApplicationConstant.TOKEN_HEADER, token);

            url = ApplicationConstant.REST_API_URL;
            LinkedHashMap jsonObject = MicroServiceUtil.jsonGetForObject(url, LinkedHashMap.class, headers);

            if (jsonObject != null) {
                if (jsonObject.containsKey("data")) {
                    data = (Map) jsonObject.get("data");
                }
            }
        }
        return data;
    }
}
