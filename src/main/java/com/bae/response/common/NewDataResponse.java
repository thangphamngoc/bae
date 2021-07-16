package com.bae.response.common;

import com.bae.common.AppConstant;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

/**
 * date 2021-03-19 09:01
 *
 * @author Phạm Ngọc Thắng
 */
public class NewDataResponse {

    private static HttpStatus statusValue = null;

    /**
     * hàm trả về kết quả khi có lỗi xảy ra
     *
     * @param body
     * @param message
     * @param httpStatus
     * @return
     */
    public static ResponseEntity<Object> setData(Object body, String message, HttpStatus httpStatus) {
        statusValue = httpStatus;
        return new ResponseEntity(new Data(body, message), httpStatus);
    }

    public static ResponseEntity<Object> setDataCustom(Object body, String message) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, message), HttpStatus.OK);
    }

    public static ResponseEntity<Object> setMessage(String message) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(message), HttpStatus.OK);
    }

    /**
     * hàm trả về kết quả khi có lỗi xảy ra
     *
     * @param body
     * @return
     */
    public static ResponseEntity<Object> setDataSave(Object body) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, AppConstant.SUCCESS_SAVE), HttpStatus.OK);
    }

    public static ResponseEntity<Object> setDataCreate(Object body) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, AppConstant.SUCCESS_CREATE), HttpStatus.OK);
    }

    public static ResponseEntity<Object> setDataUpdate(Object body) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, AppConstant.SUCCESS_UPDATE), HttpStatus.OK);
    }

    public static ResponseEntity<Object> setDataDelete(Object body) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, AppConstant.SUCCESS_DELETE), HttpStatus.OK);
    }

    public static ResponseEntity<Object> setDataRestore(Object body) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, AppConstant.SUCCESS_RESTORE), HttpStatus.OK);
    }

    public static ResponseEntity<Object> setDataSearch(Object body) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, AppConstant.SUCCESS_SEARCH), HttpStatus.OK);
    }

    public static ResponseEntity<Object> setDataActive(Object body) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, AppConstant.SUCCESS_ACTIVE), HttpStatus.OK);
    }

    public static ResponseEntity<Object> setDataApproved(Object body) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, AppConstant.SUCCESS_APPROVED), HttpStatus.OK);
    }

    public static ResponseEntity<Object> setDataUnApproved(Object body) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, AppConstant.SUCCESS_UN_APPROVED), HttpStatus.OK);
    }


    @Getter
    private static class Data {
        private String companyName = "bae group";
        private String appName = "bae";
        private LocalDate nowDate = LocalDate.now();
        private int status = statusValue.value();
        private Object data;
        private String message;

        private Data(Object data, String message) {
            this.data = data;
            this.message = message;
        }

        private Data(String message) {
            this.message = message;
        }
    }
}
