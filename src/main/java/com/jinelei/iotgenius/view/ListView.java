package com.jinelei.iotgenius.view;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: jinelei
 * @Description:
 * @Date: 2024/3/12 22:25
 * @Version: 1.0.0
 */
@ApiResponse(description = "列表响应")
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ListView<T> extends BaseView<List<T>> {
    /**
     * 记录总数量
     */
    protected final Long total;

    public ListView(Integer code, String message, List<T> data, Long total) {
        super(Optional.ofNullable(code).orElse(200),
                Optional.ofNullable(message).orElse("success"),
                Optional.ofNullable(data).orElse(new ArrayList<>()));
        this.total = total;
    }

    public static <T> ListView<T> success(String message, List<T> data) {
        return new ListView<>(200, message, data, Optional.ofNullable(data).map(List::size).map(Long::valueOf).orElse(0L));
    }
}