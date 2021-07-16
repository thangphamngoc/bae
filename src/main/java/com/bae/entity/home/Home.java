package com.bae.entity.home;

import com.bae.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * date 2021-03-19 08:48
 *
 * @author Phạm Ngọc Thắng
 */

@Getter
@Setter
@Entity
@Table(name = "demo_home")
public class Home extends BaseEntity<String> {

    @Column(nullable = false)
    private Long idSchool;

    @Column(nullable = false)
    private LocalDate scheduleDate;

    private String scheduleTitle;

    @Column(nullable = false)
    private boolean isApproved;
}
