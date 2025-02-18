package com.jinelei.iotgenius.view;

import java.util.Optional;

/**
 * @Author: jinelei
 * @Description:
 * @Date: 2024/3/13 21:55
 * @Version: 1.0.0
 */
public interface Feature {
    String getFeature();

    default boolean equals(Feature viewFeature) {
        return Optional.ofNullable(viewFeature).map(Feature::getFeature).map(getFeature()::equals).orElse(false);
    }
}
