package com.bae.unlti;

import com.bae.common.ErrorsConstant;
import com.bae.common.StringFileConstant;
import com.bae.enums.DateEnum;
import com.bae.unlti.objectData.StartEndDateObject;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ConvertData {
    /**
     * trả về pageNumber tương ứng
     *
     * @param pageNumberString
     * @return -1 nếu không hợp lệ
     */
//    public static int getPageNumber(String pageNumberString) {
//        int pageNumber = -1;
//        if (StringUtils.isBlank(pageNumberString)) {
//            pageNumber = 0;
//        } else {
//            String number = pageNumberString.trim();
//            boolean checkPageNumber = RequestValidate.checkStringInNumber(number);
//            if (checkPageNumber) {
//                pageNumber = Integer.parseInt(number) - 1;
//            }
//        }
//        return pageNumber;
//    }

    /**
     * convert LocalDate to string
     *
     * @param from
     * @param to
     * @return
     */
//    public static String convertDateToString(LocalDate from, LocalDate to) {
//        if (from == null || to == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.NO_DATE);
//        }
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
//        return from.format(formatter).concat(" - ").concat(to.format(formatter));
//    }
//
//    public static String convertDateToStringOne(LocalDate date) {
//        if (date == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.NO_DATE);
//        }
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
//        return date.format(formatter);
//    }

    /**
     * convert date to week "Tuần 00 (dd/MM/yyyy - dd/MM/yyyy)"
     *
     * @param week
     * @param date
     * @return
     */
    public static String convertDateToWeek(int week, LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String weekStart = date.format(formatter);
        String weekEnd = date.plusDays(7).format(formatter);
        String format = "Tuần " + week + " (" + weekStart + " - " + weekEnd + ")";
        return format;
    }

    /**
     * convert to month Tháng MM - yyyy
     *
     * @param month
     * @param year
     * @return
     */
    public static String convertDateToMonth(int month, int year) {
        String monthString = month < 10 ? "0" + month : "" + month;
        String format = "Tháng " + monthString + " - " + year;
        return format;
    }

//    public static String convertDatettoStringHhMMDD(LocalDateTime date) {
//        if (date == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.NO_DATE);
//        }
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm - dd/MM");
//        String dateformat = date.format(formatter);
//        return dateformat;
//    }

    public static String convertDatettotimeDDMMYY(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm - dd/MM/yyyy");
        String dateformat = date.format(formatter);
        return dateformat;
    }

    public static String convertTimeHHMM(LocalTime time) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        String timeNew = df.format(time);
        return timeNew;
    }

    public static LocalTime convertTimeHHMMNow(LocalTime time) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        String timeNew = df.format(time);
        return LocalTime.parse(timeNew);
    }

    public static LocalTime convertTimeHHMM(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    }

    /**
     * @param localDate
     * @return
     */
    public static String convertDateToPeriodic(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd - MM - yyyy");
        String date = localDate.format(formatter);
        String format = "Ngày " + date;
        return format;
    }

    public static String convertLocalDateTimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = localDateTime.format(formatter);
        return date;
    }

    public static String convertLocalDateToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = localDate.format(formatter);
        return date;
    }

    public static long convertLocalTimeToLong(LocalTime localTime) {
        long minute = ((localTime.getHour() * 60) + localTime.getMinute());
        return minute;
    }

    /**
     * tính khoảng cách giữa 2 ngày
     *
     * @param dateStart
     * @param dateEnd
     * @return số tháng
     */
    public static int convertDateToMonth(LocalDate dateStart, LocalDate dateEnd) {
        long months = ChronoUnit.MONTHS.between(dateStart, dateEnd);
        return (int) months;
    }

    /**
     * tính khoảng cách giữa 2 ngày
     *
     * @param dateStart
     * @param dateEnd
     * @return số ngày
     */
    public static int convertDateToDay(LocalDate dateStart, LocalDate dateEnd) {
        long day = ChronoUnit.DAYS.between(dateStart, dateEnd);
        return (int) day;
    }

    // chuyển tháng sinh sang tuổi
    public static String convertAgeToYears(int months) {
        String age = " ";
        if (months == 0) {
            age = "Sơ sinh";
        } else if (months > 0 && months <= 24) {
            age = months + " tháng";
        } else if (months > 24 && months < 36) {
            age = "2.5 Tuổi";
        } else if (months == 36) {
            age = "3 Tuổi";
        } else if (months > 36 && months < 48) {
            age = "3.5 Tuổi";
        } else if (months == 48) {
            age = "4 Tuổi";
        } else if (months > 48 && months < 60) {
            age = "4.5 Tuổi";
        } else if (months == 60) {
            age = "5 Tuổi";
        } else if (months > 60 && months < 72) {
            age = "5.5 Tuổi";
        } else if (months == 72) {
            age = "6 Tuổi";
        } else if (months > 72) {
            age = "Lớn hơn 6 tuổi";
        }
        return age;
    }

//    public static String convertDateToWeekname(LocalDate localDate) {
//        if (localDate == null) {
//            return "";
//        }
//        int week = localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String datetStart = formatter.format(localDate);
//        String datetEnd = formatter.format(localDate.plusDays(6));
//
//        int weekNew = DataUtils.convertWeek(localDate, week);
//
//
//        return "Tuần " + weekNew + " (" + datetStart + " - " + datetEnd + ")";
//    }


    public static String getDateMillisecond() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS");
        return dateFormat.format(LocalDateTime.now());
    }

    public static String convertDateString(LocalDate date) {
        if (date == null) {
            return "";
        } else {
            return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
    }

    public static LocalDate convertStringToDate(String dateStr) {
        if (Strings.isEmpty(dateStr)) {
            return null;
        } else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(dateStr, dateTimeFormatter);
            return localDate;
        }
    }

    public static LocalDate getMondayFromLocalTime(Calendar time) {
        Calendar timenow = Calendar.getInstance();
        timenow.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date date = timenow.getTime();
        LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    public static String fomaterLocalDate(LocalDate date) {
        if (date == null) {
            return null;
        } else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dateStr = dateTimeFormatter.format(date);
            return dateStr;
        }
    }

    public static String formatMonthAndYear(int month, int year) {
        LocalDate date = LocalDate.of(year, month, 1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
        return dateTimeFormatter.format(date);
    }

    /**
     * lấy ngày thứ 2 từ một ngày bất kỳ trong tuần
     *
     * @param date
     * @return
     */
    public static LocalDate getMondayOfWeek(LocalDate date) {
        if (date == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.NO_DATE);
        } else {
            LocalDate monday = date;
            while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
                DayOfWeek monday1 = monday.getDayOfWeek();
                monday = monday.minusDays(1);
            }
            return monday;
        }
    }

    public static String formartDateDash(LocalDate date) {
        if (date == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.NO_DATE);
        } else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dateStr = dateTimeFormatter.format(date);
            return dateStr;
        }
    }

    /**
     * lấy số ngày trong một tháng
     *
     * @param date
     * @return
     */
    public static int getDateNumberOfMonth(LocalDate date) {
        if (date == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.NO_DATE);
        } else {
            YearMonth yearMonthObject = YearMonth.of(date.getYear(), date.getMonthValue());
            int daysInMonth = yearMonthObject.lengthOfMonth();
            return daysInMonth;
        }
    }

    public static String getBithDay(LocalDate date) {
        if (date == null) {
            return "";
        } else {
            return date.format(DateTimeFormatter.ofPattern("dd-MM"));
        }
    }

    /**
     * lấy tháng của 1 ngày
     *
     * @param date
     * @return
     */
    public static StartEndDateObject getStartEndDateOfMonth(LocalDate date) {
        StartEndDateObject model = new StartEndDateObject();
        if (date == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.NO_DATE);
        } else {
            LocalDate startDate = LocalDate.of(date.getYear(), date.getMonthValue(), 1);
            LocalDate endDate = startDate.plusMonths(1);
            model.setStartDate(startDate);
            model.setEndDate(endDate);
        }
        return model;
    }

    /**
     * true: trước 12h
     * false: sau 12h
     *
     * @param time
     * @return
     */
    public static boolean checkBeforeTime(LocalTime time) {
        if (time == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.NO_TIME);
        }
        LocalTime noonTime = LocalTime.of(12, 0, 0);
        return time.isBefore(noonTime);
    }

    /**
     * lấy username bỏ qua đuôi mở rộng
     *
     * @param username
     * @return
     */
    public static String getUsernameNoExtend(String username) {
        if (username.contains("#")) {
            return username.substring(0, username.lastIndexOf("#"));
        } else {
            return username;
        }
    }

    /**
     * lấy đuôi mở rộng username
     *
     * @param username
     * @return
     */
    public static String getExtendUsername(String username) {
        if (username.contains("#")) {
            return username.substring(username.lastIndexOf("#"));
        } else {
            return "";
        }
    }


    /**
     * conver day
     *
     * @param
     * @return
     */
    public static String convetDayString(String day) {
        String reponse = "";
        if (day.equalsIgnoreCase(String.valueOf(DateEnum.MONDAY))) {
            reponse = "T2";
        } else if (day.equalsIgnoreCase(String.valueOf(DateEnum.TUESDAY))) {
            reponse = "T3";
        } else if (day.equalsIgnoreCase(String.valueOf(DateEnum.WEDNESDAY))) {
            reponse = "T4";
        } else if (day.equalsIgnoreCase(String.valueOf(DateEnum.THURSDAY))) {
            reponse = "T5";
        } else if (day.equalsIgnoreCase(String.valueOf(DateEnum.FRIDAY))) {
            reponse = "T6";
        } else if (day.equalsIgnoreCase(String.valueOf(DateEnum.SATURDAY))) {
            reponse = "T7";
        } else if (day.equalsIgnoreCase(String.valueOf(DateEnum.SUNDAY))) {
            reponse = "CN";
        }
        return reponse;
    }


    public static String numberToString(String number) {
        String sNumber = number;
        // Tao mot bien tra ve
        String sReturn = "";
        // Tim chieu dai cua chuoi
        int iLen = sNumber.length();
        // Lat nguoc chuoi nay lai
        String sNumber1 = "";
        for (int i = iLen - 1; i >= 0; i--) {
            sNumber1 += sNumber.charAt(i);
        }
        // Tao mot vong lap de doc so
        // Tao mot bien nho vi tri cua sNumber
        int iRe = 0;
        do {
            // Tao mot bien cat tam
            String sCut = "";
            if (iLen > 3) {
                sCut = sNumber1.substring((iRe * 3), (iRe * 3) + 3);
                sReturn = Read(sCut, iRe) + sReturn;
                iRe++;
                iLen -= 3;
            } else {
                sCut = sNumber1.substring((iRe * 3), (iRe * 3) + iLen);
                sReturn = Read(sCut, iRe) + sReturn;
                break;
            }
        } while (true);
        if (sReturn.length() > 1) {
            sReturn = sReturn.substring(0, 1).toUpperCase() + sReturn.substring(1);
        }
        sReturn = sReturn + "đồng";

        // xu ly lan cuoi voi 220 000 tỷ 000 000 000 000 000 HUTTV ADDED 3 OCT
        if (sNumber.length() > 12) {
            // tren gia tri can xu ly, kiem tra xem don vi TY co = 000 khong
            int begin = sNumber.length() - 9;
            String donviTy = sNumber.substring(begin - 3, (begin - 3) + 3);
            if (donviTy.equals("000")) {
                sReturn = sReturn.replaceFirst("ngàn", "ngàn tỷ");
            }
        }
        return sReturn;
    }

    // Khoi tao ham Read
    public static String Read(String sNumber, int iPo) {
        // Tao mot bien tra ve
        String sReturn = "";
        // Tao mot bien so
        String sPo[] = {"", "ngàn" + " ",
                "triệu" + " ", "tỷ" + " ", "ngàn" + " "};
        String sSo[] = {"không" + " ", "một" + " ",
                "hai" + " ", "ba" + " ",
                "bốn" + " ", "năm" + " ",
                "sáu" + " ", "bảy" + " ",
                "tám" + " ", "chín" + " "};
        String sDonvi[] = {"", "mươi" + " ",
                "trăm" + " "};
        // Tim chieu dai cua chuoi
        int iLen = sNumber.length();
        // Tao mot bien nho vi tri doc
        int iRe = 0;
        // Tao mot vong lap de doc so
        for (int i = 0; i < iLen; i++) {
            String sTemp = "" + sNumber.charAt(i);
            int iTemp = Integer.parseInt(sTemp);
            // Tao mot bien ket qua
            String sRead = "";
            // Kiem tra xem so nhan vao co = 0 hay ko
            if (iTemp == 0) {
                switch (iRe) {
                    case 0:
                        break;// Khong lam gi ca
                    case 1: {
                        if (Integer.parseInt("" + sNumber.charAt(0)) != 0) {
                            sRead = "lẻ" + " ";
                        }
                        break;
                    }
                    case 2: {
                        if (Integer.parseInt("" + sNumber.charAt(0)) != 0
                                && Integer.parseInt("" + sNumber.charAt(1)) != 0) {
                            sRead = "không trăm" + " ";
                        }
                        break;
                    }
                }
            } else if (iTemp == 1) {
                switch (iRe) {
                    case 1:
                        sRead = "mười" + " ";
                        break;
                    default:
                        sRead = "một" + " " + sDonvi[iRe];
                        break;
                }
            } else if (iTemp == 5) {
                switch (iRe) {
                    case 0: {
                        if (sNumber.length() <= 1) {
                            sRead = "năm" + " ";
                        } else if (Integer.parseInt("" + sNumber.charAt(1)) != 0) {
                            sRead = "lăm" + " ";
                        } else
                            sRead = "năm" + " ";
                        break;
                    }
                    default:
                        sRead = sSo[iTemp] + sDonvi[iRe];
                }
            } else {
                sRead = sSo[iTemp] + sDonvi[iRe];
            }

            sReturn = sRead + sReturn;
            iRe++;
        }
        if (sReturn.length() > 0) {
            sReturn += sPo[iPo];
        }
        // xu ly lan cuoi voi 220 000 tỷ 000 000 000 000 000
        if (sNumber.length() > 12) {
            // tren gia tri can xu ly, kiem tra xem don vi TY co = 000 khong
            System.out.println(sNumber.substring(11, 8));
        }
        return sReturn;
    }

    public static String getRomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
            int matches = Int / entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }

    public static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String removeAccentFinal(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, removeAccent(sb.charAt(i)));
        }
        return sb.toString();
    }

    private static char removeAccent(char ch) {
        int index = Arrays.binarySearch(StringFileConstant.SOURCE_CHARACTERS, ch);
        if (index >= 0) {
            ch = StringFileConstant.DESTINATION_CHARACTERS[index];
        }
        return ch;
    }


}
