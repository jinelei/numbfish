package com.jinelei.iotgenius.view;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Optional;

/**
 * @Author: jinelei
 * @Description:
 * @Date: 2023/7/21
 * @Version: 1.0.0
 */
@ApiResponse(description = "基础响应")
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BaseView<T> implements Serializable {
    protected final Integer code;
    protected final String message;
    protected final T data;

    public static <T> BaseView<T> success(String message, T data) {
        return new BaseView<>(200, message, data);
    }

    public static BaseView<String> success(String message) {
        return new BaseView<>(200, message, "");
    }

    public static BaseView<String> failure(Integer code, Throwable e) {
        return new BaseView<>(
                Optional.ofNullable(code).orElse(999999),
                e.getMessage(),
                Optional.ofNullable(e.getCause()).map(Throwable::getMessage).orElseGet(() -> {
                    final ByteArrayOutputStream out = new ByteArrayOutputStream();
                    e.printStackTrace(new PrintWriter(out));
                    return out.toString();
                }));
    }

    public static BaseView<String> failure(Integer code, String message, Throwable e) {
        return new BaseView<>(
                Optional.ofNullable(code).orElse(999999),
                Optional.ofNullable(message).orElse(e.getMessage()),
                Optional.ofNullable(e.getCause()).map(Throwable::getMessage).orElseGet(() -> {
                    final ByteArrayOutputStream out = new ByteArrayOutputStream();
                    e.printStackTrace(new PrintWriter(out));
                    return out.toString();
                }));
    }
}
