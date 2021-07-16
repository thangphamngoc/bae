package com.bae.request.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * date 2021-03-19 09:06
 *
 * @author Phạm Ngọc Thắng
 */

@Data
@MappedSuperclass
public abstract class  IdRequest {
    @NotNull
    private Long id;
}
