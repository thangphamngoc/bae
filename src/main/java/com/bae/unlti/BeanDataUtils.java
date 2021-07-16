package com.bae.unlti;

import org.springframework.stereotype.Component;

/**
 * date 2021-03-20 17:29
 *
 * @author Phạm Ngọc Thắng
 */
@Component
public class BeanDataUtils {
//    private static AttendanceConfigRepository attendanceConfigRepository;
//
//    @Autowired
//    public BeanDataUtils(AttendanceConfigRepository attendanceConfigRepository) {
//        BeanDataUtils.attendanceConfigRepository = attendanceConfigRepository;
//    }
//
//    public static AttendanceConfigResponse getAttendanceConfigDate(Long idSchool, LocalDate date) {
//        Optional<AttendanceConfig> attendanceConfig = attendanceConfigRepository.findAttendanceConfigDate(idSchool, date);
//        if (attendanceConfig.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.DATE_VALID);
//        }
//        return ConvertData.convertAttendanceConfig(attendanceConfig.get(), date);
//    }

}
