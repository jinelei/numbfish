package com.jinelei.iotgenius.domain;

import cn.jinelei.core.business.TreeObject;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

/**
 * @Author: jinelei
 * @Description: 基类实体，允许添加审计监听器
 * @Date: 2023/7/21
 * @Version: 1.0.0
 * @see AuditingEntityListener
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BusinessTreeEntity extends BusinessEntity implements TreeObject {
  /**
   * 父级
   */
  @Column(name = "parent_id", columnDefinition = "bigint(20) COMMENT '父级'")
  protected Long parentId;
  @Transient
  protected transient List<Long> parentIds;
  @Transient
  protected transient Boolean rootNode;
  @Transient
  protected transient Boolean leafNode;
}