package com.changex.blog.tools;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static String[] parsePatterns = {"yyyy-MM-dd",
            "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    public static String getDate(String pattern, int days) {

        Date date = new Date();
        date.setDate(date.getDate() + days);

        return DateFormatUtils.format(date, pattern);
    }

    public static boolean isDate1BeforeDate2(String dateStr1, String dateStr2,
                                             String pattern) {

        Date date1 = formatStringToDate(dateStr1, pattern);
        Date date2 = formatStringToDate(dateStr2, pattern);

        return date1.before(date2);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, String format) {

        if (date == null) {
            return null;
        }

        String formatDate = null;
        if (format != null) {
            formatDate = DateFormatUtils.format(date, format);
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
        }
        return formatDate;
    }

    /**
     * 根据时间字符串和字符串格式,转换成java.util.Date对象
     *
     * @param dateString
     * @param format
     * @return
     */
    public static Date formatStringToDate(String dateString, String format) {
        format = format != null ? format : "yyyy-MM-dd HH:mm:ss";
        if (dateString == null || dateString.length() == 0) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = dateFormat.parse(dateString);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatDateTime(String date) {

        if (StringUtils.isEmpty(date)) {
            return null;
        }

        if (date.length() == 14) {
            return formatDateStrToString(date, "yyyyMMddHHmmss",
                    "yyyy-MM-dd HH:mm:ss");
        }

        return formatDateStrToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将Date对象的字符串格式转换成指定格式的字符串
     *
     * @param format 为null则转换成默认yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String formatDateStrToString(String dateStr, String format) {
        format = format != null ? format : "yyyy-MM-dd HH:mm:ss";
        if (dateStr == null) {
            return null;
        }
        Date date = formatStringToDate(dateStr, format);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String result = dateFormat.format(date);
        return result;
    }

    /**
     * 将Date对象的字符串格式转换成指定格式的字符串
     *
     * @param dateStr
     * @param eformat 为null则转换成默认yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String formatDateStrToString(String dateStr, String bformat,
                                               String eformat) {

        eformat = eformat != null ? eformat : "yyyy-MM-dd HH:mm:ss";
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        Date date = formatStringToDate(dateStr, bformat);
        SimpleDateFormat dateFormat = new SimpleDateFormat(eformat);
        String result = dateFormat.format(date);
        return result;
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    public static Date getDateStart(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getDateStartStr(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getDateEnd(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getDateEndStr(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    // 日期推多少，num：向前为负，向后为正
    public static Date rollNOfDate(Date date, int dateType, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        switch (dateType) {
            case 1: {// 天
                cal.add(Calendar.DAY_OF_MONTH, num);
                break;
            }
            case 2: {// 周
                cal.add(Calendar.DAY_OF_MONTH, 7 * num);
                break;
            }
            case 3: {// 月
                cal.add(Calendar.MONTH, num);
                break;
            }
            case 4: {// 季度
                cal.add(Calendar.MONTH, 3 * num);
                break;
            }
            case 5: {// 年
                cal.add(Calendar.YEAR, num);
                break;
            }
            case 6: {//小时
                cal.add(Calendar.HOUR, num);
                break;
            }
        }
        return cal.getTime();
    }

    // 日期推多少，num：向前为负，向后为正
    public static String rollNOfDate(String dateStr, int dateType, int num, String format) {

        Date date = formatStringToDate(dateStr, format);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        switch (dateType) {
            case 1: {// 天
                cal.add(Calendar.DAY_OF_MONTH, num);
                break;
            }
            case 2: {// 周
                cal.add(Calendar.DAY_OF_MONTH, 7 * num);
                break;
            }
            case 3: {// 月
                cal.add(Calendar.MONTH, num);
                break;
            }
            case 4: {// 季度
                cal.add(Calendar.MONTH, 3 * num);
                break;
            }
            case 5: {// 年
                cal.add(Calendar.YEAR, num);
                break;
            }
            case 6: {//小时
                cal.add(Calendar.HOUR, num);
                break;
            }
            case 7: {//小时
                cal.add(Calendar.MINUTE, num);
                break;
            }
        }
        return formatDateStrToString(formatDateTime(cal.getTime()), "yyyy-MM-dd HH:mm:ss", format);
    }

    public static Date formatLongToDate(Long beginDate) {
        return new Date(beginDate);
    }

    // 通过年龄得到出生年份
    public static Date getBirthYearFromAge(int age) {
        Calendar mycalendar = Calendar.getInstance();
        int year = mycalendar.get(Calendar.YEAR);
        int birthYear = year - age;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(birthYear - 1900, 00, 01);
        return date;
    }

    public static Integer getAgeFromBirthday(Date birthday) {
        if (birthday == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int age = new Date().getYear() + 1900
                - Integer.parseInt(sdf.format(birthday));
        return age;
    }

    public static Integer getAgeFromBirthday(String birthday, String format) {
        if (StringUtils.isEmpty(birthday)) {
            return null;
        }

        Date date = formatStringToDate(birthday, format);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int age = new Date().getYear() + 1900
                - Integer.parseInt(sdf.format(date));
        return age;
    }

    // 计算两个时间点间隔的天数
    public static int getBetweenDays(Date begin, Date end) {
        long interval = (end.getTime() - begin.getTime()) / 1000;
        long days = interval / (24 * 60 * 60);
        return (int) days;
    }

    public static int getBetweenDays(String begin, String end) {
        Date beginDate = DateUtils.formatStringToDate(begin,
                "yyyy-MM-dd HH:mm:ss");
        Date endDate = DateUtils.formatStringToDate(end, "yyyy-MM-dd HH:mm:ss");

        long interval = (endDate.getTime() - beginDate.getTime()) / 1000;
        long days = interval / (24 * 60 * 60);
        return (int) days;
    }

    // 计算两个时间点间隔的分钟数
    public static int getBetweenMinutes(Date begin, Date end) {
        long interval = (end.getTime() - begin.getTime()) / 1000;
        long minutes = interval / 60;
        return (int) minutes;
    }

    // 计算两个时间点间隔的分钟数
    public static int getBetweenMinutes(String begin, String end) {
        Date beginDate = DateUtils.formatStringToDate(begin, null);
        Date endDate = DateUtils.formatStringToDate(end, null);
        long interval = (endDate.getTime() - beginDate.getTime()) / 1000;
        long minutes = interval / 60;
        return (int) minutes;
    }

    // 计算两个时间点间隔的秒数
    public static int getBetweenSeconds(Date begin, Date end) {
        long interval = (end.getTime() - begin.getTime()) / 1000;
        long seconds = interval;
        return (int) seconds;
    }

    // 计算两个时间点间隔的秒数
    public static int getBetweenSeconds(String begin, String end) {

        if (StringUtils.isEmpty(begin) || StringUtils.isEmpty(begin)) {
            return 0;
        }

        Date beginDate = DateUtils.formatStringToDate(begin,
                "yyyy-MM-dd HH:mm:ss");
        Date endDate = DateUtils.formatStringToDate(end,
                "yyyy-MM-dd HH:mm:ss");
        long interval = (endDate.getTime() - beginDate.getTime()) / 1000;
        long seconds = interval;
        return Math.abs((int) seconds);
    }

    public static int getBetweenMonths(String beginDate, String endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dbeginDate = null;
        Date dendDate = null;
        try {
            dbeginDate = formatter.parse(beginDate);
            dendDate = formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getBetweenMonths(dbeginDate, dendDate);
    }

    public static int getBetweenMonths(Date beginDate, Date endDate) {
        Calendar calbegin = Calendar.getInstance();
        Calendar calend = Calendar.getInstance();
        calbegin.setTime(beginDate);
        calend.setTime(endDate);
        int m_begin = calbegin.get(Calendar.MONTH) + 1; // 获得合同开始日期月份
        int m_end = calend.get(Calendar.MONTH) + 1;
        // 获得合同结束日期月份
        int checkmonth = m_end - m_begin
                + (calend.get(Calendar.YEAR) - calbegin.get(Calendar.YEAR))
                * 12;
        // 获得合同结束日期于开始的相差月份
        return checkmonth;
    }

    public static boolean isToday(Date date) {

        if (date == null) {
            return false;
        }

        return DateUtils.formatDate(date, "yyyy-MM-dd").equals(
                DateUtils.getDate());
    }

    public static boolean isToday(String date) {

        if (StringUtils.isEmpty(date)) {
            return false;
        }

        return DateUtils.formatDateStrToString(date, "yyyy-MM-dd").equals(
                DateUtils.getDate());
    }

    public static String getBefore(Integer beforeDays, Integer hour,
                                   Integer minute, Integer second) {

        if (hour == null || minute == null || second == null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
            Date today = new Date();
            today.setDate(today.getDate() - beforeDays);
            return df.format(today);
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
            Date today = new Date();
            today.setHours(hour);
            today.setMinutes(minute);
            today.setSeconds(second);
            today.setDate(today.getDate() - beforeDays);
            return df.format(today);
        }
    }

    public static boolean isInDates(String strDate, String strDateBegin,
                                    String strDateEnd) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date myDate = null;
        Date dateBegin = null;
        Date dateEnd = null;
        try {
            myDate = sd.parse(strDate);
            dateBegin = sd.parse(strDateBegin);
            dateEnd = sd.parse(strDateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        strDate = String.valueOf(myDate);
        strDateBegin = String.valueOf(dateBegin);
        strDateEnd = String.valueOf(dateEnd);

        int strDateH = Integer.parseInt(strDate.substring(11, 13));
        int strDateM = Integer.parseInt(strDate.substring(14, 16));
        int strDateS = Integer.parseInt(strDate.substring(17, 19));

        int strDateBeginH = Integer.parseInt(strDateBegin.substring(11, 13));
        int strDateBeginM = Integer.parseInt(strDateBegin.substring(14, 16));
        int strDateBeginS = Integer.parseInt(strDateBegin.substring(17, 19));

        int strDateEndH = Integer.parseInt(strDateEnd.substring(11, 13));
        int strDateEndM = Integer.parseInt(strDateEnd.substring(14, 16));
        int strDateEndS = Integer.parseInt(strDateEnd.substring(17, 19));

        if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {
            if (strDateH > strDateBeginH && strDateH < strDateEndH) {
                return true;
            } else if (strDateH == strDateBeginH && strDateM > strDateBeginM
                    && strDateH < strDateEndH) {
                return true;
            } else if (strDateH == strDateBeginH && strDateM == strDateBeginM
                    && strDateS > strDateBeginS && strDateH < strDateEndH) {
                return true;
            } else if (strDateH == strDateBeginH && strDateM == strDateBeginM
                    && strDateS == strDateBeginS && strDateH < strDateEndH) {
                return true;
            } else if (strDateH > strDateBeginH && strDateH == strDateEndH
                    && strDateM < strDateEndM) {
                return true;
            } else if (strDateH > strDateBeginH && strDateH == strDateEndH
                    && strDateM == strDateEndM && strDateS < strDateEndS) {
                return true;
            } else if (strDateH > strDateBeginH && strDateH == strDateEndH
                    && strDateM == strDateEndM && strDateS == strDateEndS) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isInTime(String strDate, String strDateBegin,
                                   String strDateEnd) {
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
        Date myDate = null;
        Date dateBegin = null;
        Date dateEnd = null;
        try {
            myDate = sd.parse(strDate);
            dateBegin = sd.parse(strDateBegin);
            dateEnd = sd.parse(strDateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        strDate = String.valueOf(myDate);
        strDateBegin = String.valueOf(dateBegin);
        strDateEnd = String.valueOf(dateEnd);

        int strDateH = Integer.parseInt(strDate.substring(11, 13));
        int strDateM = Integer.parseInt(strDate.substring(14, 16));
        int strDateS = Integer.parseInt(strDate.substring(17, 19));

        int strDateBeginH = Integer.parseInt(strDateBegin.substring(11, 13));
        int strDateBeginM = Integer.parseInt(strDateBegin.substring(14, 16));
        int strDateBeginS = Integer.parseInt(strDateBegin.substring(17, 19));

        int strDateEndH = Integer.parseInt(strDateEnd.substring(11, 13));
        int strDateEndM = Integer.parseInt(strDateEnd.substring(14, 16));
        int strDateEndS = Integer.parseInt(strDateEnd.substring(17, 19));

        if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {
            if (strDateH > strDateBeginH && strDateH < strDateEndH) {
                return true;
            } else if (strDateH == strDateBeginH && strDateM > strDateBeginM
                    && strDateH < strDateEndH) {
                return true;
            } else if (strDateH == strDateBeginH && strDateM == strDateBeginM
                    && strDateS > strDateBeginS && strDateH < strDateEndH) {
                return true;
            } else if (strDateH == strDateBeginH && strDateM == strDateBeginM
                    && strDateS == strDateBeginS && strDateH < strDateEndH) {
                return true;
            } else if (strDateH > strDateBeginH && strDateH == strDateEndH
                    && strDateM < strDateEndM) {
                return true;
            } else if (strDateH > strDateBeginH && strDateH == strDateEndH
                    && strDateM == strDateEndM && strDateS < strDateEndS) {
                return true;
            } else if (strDateH > strDateBeginH && strDateH == strDateEndH
                    && strDateM == strDateEndM && strDateS == strDateEndS) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String getFirstDayOfMonth(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date theDate = calendar.getTime();

        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(
                " 00:00:00");
        day_first = str.toString();

        return day_first;
    }

    public static String getLastDayOfMonth(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date theDate = calendar.getTime();
        calendar.add(Calendar.MONTH, 1); // 加一个月
        calendar.set(Calendar.DATE, 1); // 设置为该月第一天
        calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_last = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_last).append(
                " 23:59:59");
        day_last = endStr.toString();

        return day_last;
    }

    public static Map<String, String> getFirstdayAndLastdayOfLastMonth(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();

        // 上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(
                " 00:00:00");
        day_first = str.toString();

        // 上个月最后一天
        calendar.add(Calendar.MONTH, 1); // 加一个月
        calendar.set(Calendar.DATE, 1); // 设置为该月第一天
        calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_last).append(
                " 23:59:59");
        day_last = endStr.toString();

        Map<String, String> map = new HashMap<String, String>();
        map.put("first", day_first);
        map.put("last", day_last);
        return map;
    }

    public static String getMondayOfThisWeek() {
        int mondayPlus;
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            mondayPlus = 0;
        } else {
            mondayPlus = 1 - dayOfWeek;
        }
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String preMonday = df.format(monday);

        return preMonday;
    }

    //测试时间是否符合规范或者准确
    public static boolean isValidDate(String dateStr, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(dateStr);
            return true;
        } catch (ParseException var4) {
            return false;
        }
    }

    public static List<String> listMonth(String beginDate, String endDate, String formatter) {

        List<String> monthList = new ArrayList<>();

        LocalDate begin = LocalDate.parse(beginDate, DateTimeFormatter.ofPattern(formatter));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern(formatter));

        while (begin.isBefore(end) || begin.isEqual(end)) {
            monthList.add(begin.format(DateTimeFormatter.ofPattern("yyyy-MM")));
            begin = begin.plusMonths(1);
        }

        return monthList;
    }

    public static List<String> listDay(String beginDate, String endDate, String formatter) {

        List<String> dayList = new ArrayList<>();

        LocalDate begin = LocalDate.parse(beginDate, DateTimeFormatter.ofPattern(formatter));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern(formatter));

        while (begin.isBefore(end) || begin.isEqual(end)) {
            dayList.add(begin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            begin = begin.plusDays(1);
        }

        return dayList;
    }

    public static List<String> cutDate(String dateType, String start, String end) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dBegin = sdf.parse(start);
            Date dEnd = sdf.parse(end);
            return findDates(dateType, dBegin, dEnd);
        } catch (Exception e) {
            System.out.println("时间切割错误");
        }
        return null;
    }

    public static List<String> findDates(String dateType, Date dBegin, Date dEnd) throws Exception {
        List<String> listDate = new ArrayList<>();
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (calEnd.after(calBegin)) {
            switch (dateType) {
                case "M":
                    calBegin.add(Calendar.MONTH, 1);
                    break;
                case "D":
                    calBegin.add(Calendar.DAY_OF_YEAR, 1);break;
                case "H":
                    calBegin.add(Calendar.HOUR, 1);break;
                case "N":
                    calBegin.add(Calendar.SECOND, 1);break;
            }
            if (calEnd.after(calBegin)) {
                listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calBegin.getTime()));
            } else {
                listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calEnd.getTime()));
            }
        }
        return listDate;
    }

    public static String getGprsAcquisitionTimeStr(String acquisitionTime) {
        if (StringUtils.isEmpty(acquisitionTime)) {
            return DateUtils.getDateTime();
        }
        String acquisitionTimeStr = DateUtils.formatDateStrToString(
                acquisitionTime, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");

        Date acquisitionDate = DateUtils.formatStringToDate(acquisitionTimeStr,
                null);
        Date now = new Date();
        if (acquisitionDate.after(now)) {
            acquisitionTimeStr = DateUtils.getDateTime();
        }
        return acquisitionTimeStr;
    }

}
