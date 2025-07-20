package com.elanyin.classificationserver.dto;

import com.elanyin.classificationserver.model.Device;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultWrapper<T> {

    private boolean success;
    private T data;
    private String message;

    public static <T> ResultWrapper<T> success(T data) {
        return new ResultWrapper<>(true, data, "OK");
    }

    public static <T> ResultWrapper<T> success(T data, String message) {
        return new ResultWrapper<>(true, data, message);
    }

    public static <T> ResultWrapper<T> failure(String message) {
        return new ResultWrapper<>(false, null, message);
    }
}
