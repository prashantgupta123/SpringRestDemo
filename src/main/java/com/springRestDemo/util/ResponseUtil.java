package com.springRestDemo.util;

import com.springRestDemo.dto.response.ErrorResponseDto;
import com.springRestDemo.dto.response.SuccessResponseDto;

public class ResponseUtil {

    public static SuccessResponseDto success() {
        return new SuccessResponseDto();
    }

    public static ErrorResponseDto error() {
        return new ErrorResponseDto();
    }

}
