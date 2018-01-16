package com.springRestDemo.util;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class MicroServiceUtil {

    public static <T> T jsonPutForObject(String url, final Object co, Class<T> clazz, Map<String, String> headers) {
        return jsonRequestForObject(url, HttpMethod.PUT, co, clazz, headers);
    }

    public static <T> T jsonDeleteForObject(String url, Class<T> clazz, Map<String, String> headers) {
        return jsonRequestForObject(url, HttpMethod.DELETE, null, clazz, headers);
    }

    public static <T> T jsonPostForObject(String url, final Object co, Class<T> clazz, Map<String, String> headers) {
        return jsonRequestForObject(url, HttpMethod.POST, co, clazz, headers);
    }

    public static <T> T jsonGetForObject(String url, Class<T> clazz, Map<String, String> headers) {
        return jsonRequestForObject(url, HttpMethod.GET, null, clazz, headers);
    }

    private static <T> T jsonRequestForObject(String url, HttpMethod method, final Object co, Class<T> clazz, Map<String, String> headers) {

        ResponseEntity<T> response = jsonRequestForObjectEntity(url, method, co, clazz, headers);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }

        return null;
    }

    public static <T> ResponseEntity<T> jsonRequestForObjectEntity(String url, HttpMethod method, final Object co, Class<T> clazz, Map<String, String> headers) {

        System.out.println("MicroServiceUtils -> URL : " + url);
        System.out.println("MicroServiceUtils -> Method : " + method);
        System.out.println("MicroServiceUtils -> Headers : " + headers);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeader = new HttpHeaders();

        httpHeader.setContentType(MediaType.APPLICATION_JSON);
        if (headers != null) {
            addHeadersToRequest(headers, httpHeader);
        }
        HttpEntity<?> httpEntity = new HttpEntity<>(co, httpHeader);
        ResponseEntity<T> response;
        try {
            response = restTemplate.exchange(url, method, httpEntity, clazz);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response;
            }
        } catch (HttpClientErrorException e) {
            System.out.println("MicroServiceUtils -> HttpClientErrorException occur : " + e + " : " + e.getResponseBodyAsString());
        } catch (Exception e) {
            System.out.println("MicroServiceUtils -> Exception occur : " + e);
        }
        response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return response;
    }

    static private void addHeadersToRequest(Map<String, String> map, HttpHeaders httpHeaders) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpHeaders.add(entry.getKey(), entry.getValue());
        }
    }

}
