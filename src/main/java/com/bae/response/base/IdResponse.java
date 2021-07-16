package com.bae.response.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

/**
 * date 2021-03-19 09:03
 *
 * @author Phạm Ngọc Thắng
 */


@Getter
@Setter
@MappedSuperclass
public class IdResponse {
    private Long id;
}
