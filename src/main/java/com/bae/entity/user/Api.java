package com.bae.entity.user;

import com.bae.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * date 2021-03-24 17:10
 *
 * @author Phạm Ngọc Thắng
 */

@Getter
@Setter
@Entity
@Table(name = "ma_api")
public class Api extends BaseEntity<String> {

    @Column(nullable = false)
    private String apiUrl;

    @Column(nullable = false)
    private String apiName;

    @Column(length = 3000)
    private String apiDescription;

    //in class ApiScopeContent
    @Column(nullable = false)
    private String scope;

    @JsonBackReference
    @ManyToMany(mappedBy = "apiList", fetch = FetchType.LAZY)
    private List<Role> roleList;
}
