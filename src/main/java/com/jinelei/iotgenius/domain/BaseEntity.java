package com.jinelei.iotgenius.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: jinelei
 * @Description: 基类实体，允许添加审计监听器
 * @Date: 2023/7/21
 * @Version: 1.0.0
 * @see AuditingEntityListener
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
  @Id
  @Column(name = "id", nullable = false, columnDefinition = "bigint(20) comment '主键id'")
  protected Long id;
  @CreatedBy
  @Column(name = "created_by", nullable = false, columnDefinition = "varchar(255) default 'system_reversed' comment '创建者'")
  protected String createdBy;
  @CreatedDate
  @Column(name = "created_date", nullable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP comment '创建时间'")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  protected LocalDateTime createdDate;
  @LastModifiedBy
  @Column(name = "last_modified_by", nullable = false, columnDefinition = "varchar(255) default 'system_reversed' comment '最后修改者'")
  protected String lastModifiedBy;
  @LastModifiedDate
  @Column(name = "last_modified_date", nullable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP comment '最后修改时间'")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  protected LocalDateTime lastModifiedDate;
}