package com.bae.entity.user;

import com.bae.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * date 2021-03-11 14:29
 *
 * @author Phạm Ngọc Thắng
 */
@Entity
@Table(name = "ma_user")
@Data
@NoArgsConstructor
public class MaUser extends BaseEntity<String> {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String gender;

    @Column(nullable = false, unique = true)
    @Size(min = 6)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Size(min = 6)
    private String passwordShow;

    @Column(length = 12)
    private String phone;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "ex_user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    @JsonManagedReference
    private List<Role> roleList;
}
