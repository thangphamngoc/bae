package com.bae.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * date 2021-03-11 16:27
 *
 * @author Phạm Ngọc Thắng
 */

@Getter
@Setter
public class ErrorsObject {
    private String field;

    private String defaultMessage;
}
