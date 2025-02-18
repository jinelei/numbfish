package com.jinelei.iotgenius.domain;

import cn.jinelei.core.business.RemarkObject;
import cn.jinelei.core.business.SensitivityObject;
import cn.jinelei.core.business.SoftDeleteObject;
import cn.jinelei.core.business.SortableObject;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
public class BusinessEntity extends BaseEntity
    implements SortableObject, SoftDeleteObject, SensitivityObject, RemarkObject {
  /**
   * 排序
   */
  @Column(name = "sort", columnDefinition = "int(11) default 0 COMMENT '排序'")
  protected Integer sort;
  @Transient
  protected transient Boolean direction;
  /**
   * 是否保护数据
   */
  @Column(name = "sensitivity", columnDefinition = "tinyint(1) default 0 COMMENT '是否敏感数据' ")
  protected Integer sensitivity;
  /**
   * 是否启用
   */
  @Column(name = "enabled", columnDefinition = "tinyint(1) default 1 COMMENT '是否启用'")
  protected Integer enabled;
  /***
   * 描述
   */
  @Column(name = "remark", columnDefinition = "varchar(255) default '' COMMENT '描述'")
  protected String remark;
}