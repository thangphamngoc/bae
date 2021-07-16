package com.bae.common;

/**
 * date 2021-03-24 17:09
 *
 * @author Phạm Ngọc Thắng
 */
public interface RoleTypeConstant {
    String ROOT="root";
    /**
     * app dành cho nhà trường
     */
    String SCHOOL = "plus";

    /**
     * app dành cho giáo viên
     */
    String TEACHER = "teacher";

    /**
     * app giành cho phụ huynh
     */
    String PARENT = "parent";

    /**
     * loại mặc định khi nhà trường tạo role
     */
    String OTHER = "other";
}
