package com.bae.request.base;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * date 2021-03-19 09:07
 *
 * @author Phạm Ngọc Thắng
 */

@Getter
@Setter
public class IdListRequest {

    @NotEmpty
    private List<Long> idList;
}
