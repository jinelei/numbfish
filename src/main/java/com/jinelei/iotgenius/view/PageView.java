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
@SuppressWarnings("unused")
@ApiResponse(description = "分页响应")
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PageView<T> extends ListView<T> {
    /**
     * 当前页码
     */
    protected final Integer page;
    /**
     * 当前页大小
     */
    protected final Integer size;

    public PageView(Integer code, String message, List<T> data, Long total, Integer page, Integer size) {
        super(Optional.ofNullable(code).orElse(200),
                Optional.ofNullable(message).orElse("success"),
                Optional.ofNullable(data).orElse(new ArrayList<>()),
                Optional.ofNullable(total).orElse(0L));
        this.page = Optional.ofNullable(page).orElse(0);
        this.size = Optional.ofNullable(size).orElse(0);
    }
//
//    public static <T> PageView<T> success(Page<T> data) {
//        return new PageView<>(null, null,
//                Optional.of(data).map(Slice::getContent).orElse(null),
//                Optional.of(data).map(Page::getTotalElements).orElse(null),
//                Optional.of(data).map(Slice::getPageable).map(Pageable::getPageNumber).orElse(null),
//                Optional.of(data).map(Slice::getPageable).map(Pageable::getPageSize).orElse(null));
//    }
//
//    public static <T> PageView<T> success(String message, Page<T> data) {
//        return new PageView<>(null, message,
//                Optional.of(data).map(Slice::getContent).orElse(null),
//                Optional.of(data).map(Page::getTotalElements).orElse(null),
//                Optional.of(data).map(Slice::getPageable).map(Pageable::getPageNumber).orElse(null),
//                Optional.of(data).map(Slice::getPageable).map(Pageable::getPageSize).orElse(null));
//    }
}