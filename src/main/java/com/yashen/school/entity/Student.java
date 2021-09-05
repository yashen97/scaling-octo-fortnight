package com.yashen.school.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "FACULTY",nullable = false)
    private String faculty;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENROLLMENT_DATE",nullable = false)
    private Date enrolledDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE",nullable = false)
    private Date modifiedDate;

    @ColumnDefault("0")
    @Column(name = "Is_Graduated",nullable = false)
    private Integer isGraduated;

    @ColumnDefault("0")
    @Column(name = "IS_DELETED",nullable = false)
    private Integer isDeleted;
}
