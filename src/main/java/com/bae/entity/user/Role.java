package com.bae.entity.user;

/**
 * date 2021-03-24 17:08
 *
 * @author Phạm Ngọc Thắng
 */

import com.bae.common.RoleTypeConstant;
import com.bae.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ma_role")
public class Role extends BaseEntity<String> {

    @Column(nullable = false)
    private String roleName;

    @Column(length = 3000)
    private String description;

    //in class RoleTypeConstant, dùng để tạo các loại role mặc định
    @Column(nullable = false, columnDefinition = "varchar(255) default 'other'")
    private String type = RoleTypeConstant.OTHER;

    //true là của hệ thống tạo
    private boolean createdSystem;

    //true là ẩn role
    private boolean roleHidden;

    @JsonBackReference
    @ManyToMany(mappedBy = "roleList", fetch = FetchType.LAZY)
    private List<MaUser> maUsersList;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "ex_role_api",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_api")
    )
    @JsonManagedReference
    private List<Api> apiList;
}
