package com.bae.response.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * date 2021-03-19 09:02
 *
 * @author Phạm Ngọc Thắng
 */


/**
 * kết quả trả về khi có lỗi
 */
public class ErrorResponse {

    private static HttpStatus statusValue = null;

    /**
     * hàm trả về kết quả khi có lỗi xảy ra
     *
     * @param error
     * @param data
     * @param httpStatus
     * @return
     */
    public static ResponseEntity<Object> errorData(String error, String data, HttpStatus httpStatus) {
        statusValue = httpStatus;
        return new ResponseEntity(new ErrorData(error, data), httpStatus);
    }

    /**
     * mổ tả lỗi chi tiết thông qua các thuộc tính
     */
    @Getter
    private static class ErrorData {
        private String companyName = "Bae Group";
        private String appName = "Bae";
        private int status = statusValue.value();
        //gửi cho frontend để hiện thị thông báo
        private String data;
        //frontend ko lấy nó, mô tả lỗi để người code hiểu
        private String error;

        private ErrorData(String error, String content) {
            this.error = error;
            this.data = content;
        }
    }
}
