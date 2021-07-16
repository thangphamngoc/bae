package com.bae.common;

/**
 * date 2021-03-11 16:28
 *
 * @author Phạm Ngọc Thắng
 */
public interface ErrorsConstant {

    String ERROR_SYSTEM = "Không thành công. Bạn vui lòng thử lại sau!";
    String ERROR_COMMON = "Không thành công. Bạn vui lòng thử lại sau!!!";
    String ERROR_TOKEN = "Lỗi xác thực người dùng";
    String BAD_CREDENTIALS = "Thông tin đăng nhập không đúng";
    String ERROR_INPUT = "Lỗi dữ liệu truyền vào";
    String ERROR_MAX_FILE = "Kích thước vượt quá 5MB";
    String ERROR_INPUT_PARAMETER = "Lỗi dữ liệu truyền vào ở tham số";
    String ERROR_INPUT_SQL = "Lỗi thao tác với dữ liệu";
    String NOT_FOUND_DATABASE_FIND = "Không tìm thấy dữ liệu trong hệ thống";
    String NOT_FOUND_DATABASE_DELETE = "Không tồn tại dữ liệu trong hệ thống";
    String NOT_SUPPORT_METHOD = "Không hỗ trợ cách truy vấn này";
    String SQL_SYNTAX = "Lỗi cú pháp SQL";
    String NOT_FOUND_FILE_DELETE = "Không tìm thấy file cần xóa trong hệ thống";
    String NO_DATE = "Ngày không được để trống";
    String DATE_AFTER = "Ngày không được lớn hơn ngày hiện tại";
    String DATE_VALID = "Ngày không hợp lệ";
    String NO_TIME = "Không có thời gian";
    String NO_DATA = "Thông tin không được để trống";
    String BIRTHDAY_EMPTY = "Ngày sinh không được để trống";
    String NO_PICTURE = "Ảnh không được để trống";
    String DATA_NULL = "Không có dữ liệu";
    String NO_DATA_ACCOUNT = "Thông tin tài khoản không được để trống";
    String NO_SUPPORT_ACCOUNT = "Chức năng chưa hỗ trợ trên tài khoản này";
    String PAGE_NUMBER_INVALID = "Số trang phải lớn hơn hoặc bằng 1";
    String MAX_PAGE_ITEM_INVALID = "Số bản ghi trong một trang phải lớn hơn hoặc bằng 1";
    String USERNAME_EXIST = "Tên đăng nhập đã tồn tại";
    String ERROR_NO_USER = "Tài khoản không tồn tại!";
    String ERROR_YES_USER = "Tài khoản đã tồn tại!";
    String ACCOUNT_DELETE = "Tài khoản đã xóa!";
    String USERNAME_BLANK = "Tên đăng nhập không được để trống";
    String USERNAME_LENGHT = "Tên đăng nhập phải lớn hơn hoặc bằng " + AppConstant.USERNAME_MIN_LENGHT + " ký tự";
    String USERNAME_INVALID = "Tên đăng nhập không hợp lệ";
    String USERNAME_INVALID_PLUS = "Tên đăng nhập nhà trường không hợp lệ";
    String USERNAME_INVALID_TEACHER = "Tên đăng nhập giáo viên không hợp lệ";
    String USERNAME_INVALID_PARENT = "Tên đăng nhập phụ huynh không hợp lệ";
    String PASSWORD_BLANK = "Mật khẩu không được để trống";
    String PASSWORD_LENGHT = "Mật khẩu phải lớn hơn hoặc bằng " + AppConstant.PASSWORD_MIN_LENGHT + " ký tự";
    String PASSWORD_INVALID = "Mật khẩu không hợp lệ";
    String NO_SCHOOL_IN_AGENT = "Đại lý không có trường nào";
    String VERIFY_CODE_LENGTH = "Mã xác thực bao gồm 6 ký tự";
    String VERIFY_CODE_ADMIN = "Mã xác thực chỉ bao gồm các ký tự A-Z";
    String NO_APP_TYPE = "AppType không được để trống";
    String NO_INFOR_ACCOUNT = "Thông tin tạo tài khoản không được để trống";
    String INVALID_APPTYPE = "AppType không đúng định dạng";
    String PHONE_BLANK = "Số điện thoại không được để trống";
    String PHONE_LENGH = "Số điện thoại bao gồm 10 số";
    String NO_BRAND = "Trường chưa được thêm brand name";
    String PHONE_INVALID = "Số điện thoại không hợp lệ";
    String APPTYPE_BLANK = "Loại người dùng không được để trống";
    String APPTYPE_INVALID = "Loại người dùng không hợp lệ";
    String CODE_BLANK = "Mã xác thực không được để trống";
    String CODE_LENGTH = "Mã xác thực bao gồm 6 ký tự";
    String CODE_WRONG = "Mã xác thực không chính xác";
    String ERROR_FIREBASE = "Lỗi gửi thông báo qua ứng dụng";
    String ERROR_BUTTON = "Thao tác không được để trống";
    String USER_EMPTY = "Người dùng không được để trống";
    String NOT_FOUND_USER = "Không tìm thấy người thông tin người dùng";
    String EMPTY_USER_LOGIN = "Tài khoản đã hết hiệu lực";
    String MAX_SIZE_FILE = "Kích thước file quá " + UploadDownloadConstant.MAX_SIZE + " MB";
}
