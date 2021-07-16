package com.bae.request.base;

import lombok.Data;

/**
 * date 2021-03-19 09:07
 *
 * @author Phạm Ngọc Thắng
 */
@Data
public class BaseRequest {
    private String pageNumber;

    private String maxPageItem;

    private String sort;
}
