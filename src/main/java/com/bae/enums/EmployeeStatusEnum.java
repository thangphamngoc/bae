package com.bae.enums;

/**
 * date 2021-03-11 16:25
 *
 * @author Phạm Ngọc Thắng
 */
public enum EmployeeStatusEnum {
    EMPLOYEE_STATUS_WORKING("Đang làm"),
    EMPLOYEE_STATUS_RETAIN("Tạm nghỉ"),
    EMPLOYEE_STATUS_LEAVE("Nghỉ làm");

    private String value;

    EmployeeStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
