package com.zt.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期处理的工具类 *
 * 
 * @version 1.0
 * @date 2007-4-20
 */
public class DateUtil {

    /** 日期+时间的格式 */
    final static public String DATE_TIME_FORMAT  = "yyyy-MM-dd HH:mm:ss";

    /** 日期的格式 */
    final static public String DATE_FORMAT       = "yyyy-MM-dd";

    /** 小时:分的格式 */
    final static public String HHMM_FORMAT       = "HH:mm";

    final static public String HHMMSS_FORMAT     = "HH:mm:ss";

    /** 日期+时间的格式 */
    final static public String DATE_MIN_FORMAT   = "yyyy-MM-dd HH:mm";

    final static public String DATE_HOUR_FORMAT  = "yyyy-MM-dd HH";

    /** 日期加时间的格式 */
    final static public String DATE_SHORT_FORMAT = "MM-dd HH:mm";

    final static public String DATE_MMDD_FORMAT  = "MM-dd";

    private static final Long  DAY_SECONDS       = 3600 * 24L;

    private static final Long  HOUR_SECONDS      = 3600L;

    private static final Long  MINUTE_SECONDS    = 60L;

    /**
     * 将日期字符串解析成指定格式的Date对象
     * 
     * @param dateTime 日期字符串
     * @param format 指定格式
     * @return （正确格式）日期对象
     * @throws ParseException
     */
    public static Date parse(String dateTime, String format) throws ParseException {
        if (dateTime == null || dateTime.length() <= 0) return null;
        String sDateTime = ((dateTime.indexOf('.') > 0)) ? dateTime.substring(0, dateTime.indexOf('.')) : dateTime;

        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(sDateTime);
    }

    /**
     * 将日期字符串解析成"yyyy-MM-dd HH:mm:ss"格式的Date对象
     * 
     * @param dateTime 日期字符串
     * @param format 指定格式
     * @return （正确格式）日期对象
     * @throws ParseException
     */
    public static Date parseDateTime(String dateTime) {

        try {
            return parse(dateTime, DATE_TIME_FORMAT);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将日期字符串解析成"yyyy-MM-dd HH:mm"格式的Date对象
     * 
     * @param dateTime 日期字符串
     * @param format 指定格式
     * @return （正确格式）日期对象
     * @throws ParseException
     */
    public static Date parseDateTimeDateMinFormat(String dateTime) throws ParseException {
        return parse(dateTime, DATE_MIN_FORMAT);
    }

    /**
     * 将日期类解析成指定格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formatDateTime(Date date, String format) {
        if (date == null) return null;
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 将日期字符串解析成"yyyy-MM-dd"格式的Date对象
     * 
     * @param dateTime 日期字符串
     * @param format 指定格式
     * @return （正确格式）日期对象
     * @throws ParseException
     */
    public static Date parseDate(String dateTime) throws ParseException {
        return parse(dateTime, DATE_FORMAT);
    }

    /**
     * 将日期类解析成"HH:mm"格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formatHHmm(Date date) {
        return formatDateTime(date, HHMM_FORMAT);
    }

    /**
     * 将日期类解析成"MM-dd"格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formatMMdd(Date date) {
        return formatDateTime(date, DATE_MMDD_FORMAT);
    }

    /**
     * 将日期类解析成"HH:mm:ss"格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formatHHmmss(Date date) {
        return formatDateTime(date, HHMMSS_FORMAT);
    }

    /**
     * 将日期解析为yyyy-MM-DD HH:mm 格式的日期字符串
     * 
     * @param date
     * @return
     */
    public static String formatYYMMDDHHmm(Date date) {
        return formatDateTime(date, DATE_MIN_FORMAT);
    }

    /**
     * 将日期解析为 MM-DD HH:mm 格式的日期字符串
     * 
     * @param date
     * @return
     */
    public static String formatMMDDHHmm(Date date) {
        return formatDateTime(date, DATE_SHORT_FORMAT);
    }

    /**
     * 将日期类解析成"yyyy-MM-dd"格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formatYYYYMMDD(Date date) {
        return formatDateTime(date, DATE_FORMAT);
    }

    /**
     * 将日期类解析成"yyyy-MM"格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formatYYYYMM(Date date) {
        if (date == null) return null;

        return getYear(date) + "-" + getMonth(date);
    }

    /**
     * 将日期类解析成"yyyy-MM-dd HH:mm:ss"格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date) {
        return formatDateTime(date, DATE_TIME_FORMAT);
    }

    /**
     * 比较两个日期的时间差 返回 XX天XX小时XX分XX秒
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static String formatHumanDiff(Date startDate, Date endDate) {

        if (startDate == null || endDate == null) {
            return "";
        }

        Long seconds = (endDate.getTime() - startDate.getTime()) / 1000;
        StringBuffer sb = new StringBuffer("");
        if (seconds <= 0) {
            sb.append("已过期");
            seconds = 0 - seconds;
        }
        // 天
        if (seconds >= DAY_SECONDS) {
            sb.append(seconds / DAY_SECONDS).append("天");
            seconds = seconds % DAY_SECONDS;
        }

        // 小时
        if (seconds >= HOUR_SECONDS) {
            sb.append(seconds / HOUR_SECONDS).append("小时");
            seconds = seconds % HOUR_SECONDS;
        }

        // 分
        if (seconds >= MINUTE_SECONDS) {
            sb.append(seconds / MINUTE_SECONDS).append("分");
            seconds = seconds % MINUTE_SECONDS;
        }
        //
        // if(seconds >= 1){
        // sb.append( seconds / 1 ).append("秒 ");
        //
        // }

        return sb.toString();

    }

    /**
     * 返回日期
     * 
     * @param year 1900-...
     * @param month 0-11
     * @param monthDay 1-31
     * @throws RuntimeException
     * @return
     */
    public static Date toDate(int year, int month, int day) {
        if (!checkDay(year, month, day)) return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);

        return cal.getTime();
    }

    /**
     * 返回某一天的开始时间 例如：2012-12-12 00:00:00
     * 
     * @param date
     * @return
     */
    public static Date toDateStart(Date date) {
        
        if(date == null){
            return null;
        }
        
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(DateUtil.getYear(date), DateUtil.getMonth(date), DateUtil.getMonthDay(date), 0, 0, 0);

        return cal.getTime();
    }

    /**
     * 返回某一时间的小时开始时间 例如：2012-12-12 12:00:00
     * 
     * @return
     */
    public static Date toHourStart(Date date) {

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(DateUtil.getYear(date), DateUtil.getMonth(date), DateUtil.getMonthDay(date), DateUtil.getHours(date),
                0, 0);

        return cal.getTime();
    }

    /**
     * 返回某一天的结束时间 2012-12-12 23:59:59
     * 
     * @param date
     * @return
     */
    public static Date toDateEnd(Date date) {
        
        if(date == null){
            return null;
        }
        
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(DateUtil.getYear(date), DateUtil.getMonth(date), DateUtil.getMonthDay(date), 23, 59, 59);

        return cal.getTime();
    }

    /**
     * 返回四位年份
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getYear(Date date) {
        if (date == null) return -1;
        return date.getYear() + 1900;
    }

    /**
     * 返回月数(0-11)
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getMonth(Date date) {
        if (date == null) return -1;
        return date.getMonth();
    }

    /**
     * 返回月几(1-31)
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getMonthDay(Date date) {
        if (date == null) return -1;
        return date.getDate();
    }

    /**
     * 返回周几 returned value (<tt>7</tt> = Sunday, <tt>1</tt> = Monday, <tt>2</tt> = Tuesday, <tt>3</tt> = Wednesday,
     * <tt>4</tt> = Thursday, <tt>5</tt> = Friday, <tt>6</tt> = Saturday)
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getChinaWeekDay(Date date) {
        if (date == null) return -1;
        int d = date.getDay();
        if (d == 0) d = 7;

        return d;
    }

    /**
     * 返回周几 returned value (<tt>0</tt> = Sunday, <tt>1</tt> = Monday, <tt>2</tt> = Tuesday, <tt>3</tt> = Wednesday,
     * <tt>4</tt> = Thursday, <tt>5</tt> = Friday, <tt>6</tt> = Saturday)
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getWeekDay(Date date) {
        if (date == null) return -1;
        return date.getDay();
    }

    /**
     * 返回小时数(0-23)
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getHours(Date date) {
        if (date == null) return -1;
        return date.getHours();
    }

    /**
     * 返回分钟数（0-59）
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getMinutes(Date date) {
        if (date == null) return -1;
        return date.getMinutes();
    }

    @SuppressWarnings("deprecation")
    public static int getSeconds(Date date) {
        if (date == null) {
            return -1;
        }
        return date.getSeconds();
    }

    /**
     * 是否是今天
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean isToday(Date date) {
        if (date == null) return false;
        Date today = new Date();
        return (date.getYear() == today.getYear() && date.getMonth() == today.getMonth() && date.getDate() == today.getDate()) ? true : false;
    }

    /**
     * 是否是今天
     * 
     * @param year
     * @param month
     * @param monthDay
     * @return
     */
    public static boolean isToday(int year, int month, int day) {
        if (!checkDay(year, month, day)) return false;

        return isToday(toDate(year, month, day));
    }

    /**
     * 是否在某个小时的区间[0,59)内。
     * 
     * @param date
     * @param hour
     * @return
     */
    public static boolean isInHour(Date date, int hour) {
        if (date == null || hour < 0) return false;
        return (getHours(date) == hour) ? true : false;
    }

    /**
     * 某年某月某天的下一天
     * 
     * @param year
     * @param month
     * @param monthDay
     * @return
     */
    public static Date getNextDay(int year, int month, int day) {
        if (!checkDay(year, month, day)) return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, 1);

        return cal.getTime();
    }

    /**
     * 某年某月某天的上一天 如果输入1900年1月1日，则返回1900年1月1日。
     * 
     * @param year
     * @param month
     * @param monthDay
     * @throws RuntimeException
     * @return
     */
    public static Date getPrevDay(int year, int month, int day) {
        if (!checkDay(year, month, day)) return null;

        // 如果当前日期为1900-1-1 前一天仍为当天
        if (year == 1900 && month == 0 && day == 1) {
            return toDate(1900, 0, 1);
        }

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, -1);

        return cal.getTime();
    }

    /**
     * 获取当前日期前后几天的日期
     * 
     * @param date
     * @param amount 正数为当前日期往后的天数
     * @return
     */
    public static Date addDay(Date date, int amount) {
        if (date == null) return null;
        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, amount);

        return cal.getTime();
    }

    public static Date changeDay(Date date, int amount) {
        if (date == null) return null;
        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);
        int hours = getHours(date);
        int minutes = getMinutes(date);
        int seconds = getSeconds(date);
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day, hours, minutes, seconds);
        cal.add(Calendar.DAY_OF_YEAR, amount);

        return cal.getTime();

    }

    /**
     * 添加分
     * 
     * @param date
     * @param amount
     * @return
     */
    public static Date addMinute(Date date, int amount) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, amount);
        return cal.getTime();
    }

    public static Date addYear(Date date, int amount) {
        if (date == null) {
            return null;
        }
        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);
        int hour = getHours(date);
        int minute = getMinutes(date);
        int second = getSeconds(date);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, hour, minute, second);
        cal.add(Calendar.YEAR, amount);
        return cal.getTime();
    }

    public static Date addHour(Date date, int amount) {
        if (date == null) {
            return null;
        }
        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);
        int hours = getHours(date);
        int minutes = getMinutes(date);
        int seconds = getSeconds(date);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, hours, minutes, seconds);
        cal.add(Calendar.HOUR_OF_DAY, amount);

        return cal.getTime();
    }

    /**
     * 某年某月某天的下一天
     * 
     * @param year
     * @param month
     * @param monthDay
     * @return
     */
    public static Date getNextDay(Date date) {
        if (date == null) return null;
        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);

        return getNextDay(year, month, day);
    }

    /**
     * 某年某月某天的上一天 如果输入1900年1月1日，则返回1900年1月1日。
     * 
     * @param year
     * @param month
     * @param monthDay
     * @return
     */
    public static Date getPrevDay(Date date) {
        if (date == null) return null;
        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);
        if (year < 1900 || month < 0 || month > 11 || day < 1 || day > 31) return null;

        return getPrevDay(year, month, day);
    }

    /**
     * 某年某月某日的所在周的第一天(周一)。
     * 
     * @param year
     * @param month
     * @param monthDay
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int month, int day) {
        if (!checkDay(year, month, day)) return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_WEEK, 1 - getChinaWeekDay(toDate(year, month, day)));

        return cal.getTime();
    }

    /**
     * 某年某月某日的所在周的周末一天(周日)。
     * 
     * @param year
     * @param month
     * @param monthDay
     * @return
     */
    public static Date getEndDayOfWeek(int year, int month, int day) {
        if (!checkDay(year, month, day)) return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_WEEK, 7 - getChinaWeekDay(toDate(year, month, day)));

        return cal.getTime();
    }

    /**
     * 某年某月某日的所在周的下一周第一天(周一)。
     * 
     * @param year
     * @param month
     * @param monthDay
     * @return
     */
    public static Date getFirstDayOfNextWeek(int year, int month, int day) {
        if (!checkDay(year, month, day)) return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, 7);
        Date newDate = cal.getTime();

        return getFirstDayOfWeek(getYear(newDate), getMonth(newDate), getMonthDay(newDate));
    }

    /**
     * 某年某月某日的所在周的前一周第一天(周一)。 如果输入1900年1月1日，则返回1900年1月1日。
     * 
     * @param year
     * @param month
     * @param monthDay
     * @return
     */
    public static Date getFirstDayOfPrevWeek(int year, int month, int day) {
        if (!checkDay(year, month, day)) return null;

        // 如果当前日期为1900-1-1至1900-1-7中任意一天 上一周的第一天
        if (year == 1900 && month == 0 && day <= 7) {
            return toDate(year, month, 1);
        }

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, -7);
        Date newDate = cal.getTime();

        return getFirstDayOfWeek(getYear(newDate), getMonth(newDate), getMonthDay(newDate));
    }

    /**
     * 某年某月某日的所在周的下一周周末一天(周日)。
     * 
     * @param year
     * @param month
     * @param monthDay
     * @return
     */
    public static Date getEndDayOfNextWeek(int year, int month, int day) {
        if (!checkDay(year, month, day)) return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, 7);
        Date newDate = cal.getTime();

        return getEndDayOfWeek(getYear(newDate), getMonth(newDate), getMonthDay(newDate));
    }

    /**
     * 某年某月某日的所在周的前一周周末一天(周日)。 如果输入1900年1月1日，则返回1900年1月1日。
     * 
     * @param year
     * @param month
     * @param monthDay
     * @return
     */
    public static Date getEndDayOfPrevWeek(int year, int month, int day) {
        if (!checkDay(year, month, day)) return null;

        // 如果当前日期为1900-1-1至1900-1-7中任意一天 上一周的最后一天
        if (year == 1900 && month == 0 && day <= 7) {
            return toDate(year, month, 7);
        }

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, -7);
        Date newDate = cal.getTime();
        return getEndDayOfWeek(getYear(newDate), getMonth(newDate), getMonthDay(newDate));
    }

    /**
     * 某年某月的第一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month) {
        return toDate(year, month, 1);
    }

    /**
     * 某年某月的最后一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getEndDayOfMonth(int year, int month) {
        return toDate(year, month, getMaxDays(year, month));
    }

    /**
     * 某年某月的下一个月的第一天。
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfNextMonth(int year, int month) {
        if (year < 1900 || month < 0 || month > 11) return null;

        if (month == 11) {
            return getFirstDayOfMonth(year + 1, 0);
        }

        return getFirstDayOfMonth(year, month + 1);
    }

    /**
     * 某年某月的下一个月的最后一天。
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getEndDayOfNextMonth(int year, int month) {
        if (year < 1900 || month < 0 || month > 11) return null;

        if (month == 11) {
            return getEndDayOfMonth(year + 1, 0);
        }

        return getEndDayOfMonth(year, month + 1);
    }

    /**
     * 某年某月的上一个月的第一天。 注意：如输入1900年1月，则返回1900年1月1日
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfPrevMonth(int year, int month) {
        if (year < 1900 || month < 0 || month > 11) return null;

        if (year == 1900 && month == 0) {
            return getFirstDayOfMonth(year, month);
        }

        if (month == 0) {
            return getFirstDayOfMonth(year - 1, 11);
        }

        return getFirstDayOfMonth(year, month - 1);
    }

    /**
     * 某年某月的上一个月的最后一天。 注意：如输入1900年1月，则返回1900年1月31日
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getEndDayOfPrevMonth(int year, int month) {
        if (year < 1900 || month < 0 || month > 11) return null;

        if (year == 1900 && month == 0) {
            return getEndDayOfMonth(year, month);
        }

        if (month == 0) {
            return getEndDayOfMonth(year - 1, 11);
        }

        return getEndDayOfMonth(year, month - 1);
    }

    /**
     * 某年某月的天数。
     * 
     * @param year
     * @param month
     * @return
     */
    public static int getMaxDays(int year, int month) {
        if (year < 1900 || month < 0 || month > 11) return 0;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, 1);

        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回某一天的零点的日期字符串
     * 
     * @param date
     * @return
     */
    public static String toZeroDateTime(Date date) {
        return formatDateTime(date, DATE_FORMAT) + " 00:00:00";
    }

    /**
     * 返回某一天最后时刻的日期字符串
     * 
     * @param date
     * @return
     */
    public static String toLastDateTime(Date date) {
        return formatDateTime(date, DATE_FORMAT) + " 23:59:59";
    }

    /**
     * 返回某一天的年月日开始，以现在时刻结尾的日期
     * 
     * @param date
     * @return
     */
    public static Date toNowDate(Date date) {
        return toDate(DateUtil.getYear(date), DateUtil.getMonth(date), DateUtil.getMonthDay(date));
    }

    /**
     * 比较日期：年月日。
     * 
     * @param d0
     * @param d1
     * @return the value <code>0</code> if the argument d1 is equal to d0; a value less than <code>0</code> if d0 is
     * before d1 argument; and a value greater than <code>0</code> if d0 is after d1 argument.
     * @exception NullPointerException if d0 or d1 is null.
     */
    public static int compareDay(Date d0, Date d1) {
        return d0.compareTo(d1);
    }

    /**
     * d0是否在[d1,d2]的日期区间中
     * 
     * @param d0
     * @param d1
     * @param d2
     * @return
     * @exception NullPointerException if d0 or d1 or d2 is null.
     */
    public static boolean isInDayZone(Date d0, Date d1, Date d2) {
        return (compareDay(d0, d1) >= 0 && compareDay(d1, d2) <= 0) ? true : false;
    }

    /**
     * 返回N个月之后（之前）的某天。 例外情况：如果找到的天数大于此月的最后一天，则返回此月的最后一天。 比如：输入(2007-1-31,1)，则返回2007-2-28
     * 
     * @param date
     * @param month
     * @return
     */
    public static Date getThisDayByMonth(Date date, int monthNumber) {
        if (monthNumber == 0) return date;
        if (date == null) return null;

        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);
        if (!checkDay(year, month, day)) return null;
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.MONTH, monthNumber);

        return cal.getTime();
    }

    /**
     * 返回N天之后（之前）的某天。 例外情况：如找到的那天晚于1900-1-1，则返回1900-1-1。
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date getThisDayByDay(Date date, int days) {
        if (days == 0) return date;
        if (date == null) return null;

        int year = getYear(date);
        int month = getMonth(date);
        int day = getMonthDay(date);
        if (!checkDay(year, month, day)) return null;
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day);
        cal.add(Calendar.DAY_OF_YEAR, days);

        Date findDate = cal.getTime();
        Date date_1900_1_1 = toDate(1900, 0, 1);
        if (compareDay(findDate, date_1900_1_1) < 0) return date_1900_1_1;

        return findDate;
    }

    /**
     * 格式化日期类型，返回中文显示的日期时间 返回String 格式如下： 2007年9月4日 16:32:35
     * 
     * @param date
     * @return
     */
    public static String formatDateTimeInChina(Date date) {
        if (date == null) return "";
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.DEFAULT, Locale.CHINA);
        return df.format(date);
    }

    /**
     * 格式化日期类型，返回中文显示的日期时间 返回String 格式如下： 2007年9月4日
     * 
     * @param date
     * @return
     */
    public static String formatDateInChina(Date date) {
        if (date == null) return "";
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
        return df.format(date);
    }

    /**
     * 比较2个日期类型，返回2个日期相差的天数，正数表示前一个日期比后一个日期晚n天，负数表示前一日期比后一日期早n天
     * 
     * @param compareDate
     * @param compareToDate
     * @throws RuntimeException
     * @return
     */
    public static int compareDays(Date d1, Date d2) {
        if (d1 == null || d2 == null) throw new RuntimeException("Not compare between d1<" + d1 + "> and d2<" + d2
                                                                 + ">!");
        try {
            d1 = parseDate(formatYYYYMMDD(d1));
            d2 = parseDate(formatYYYYMMDD(d2));
        } catch (ParseException e) {
            throw new RuntimeException("data format error d1=" + d1 + ",d2=" + d2);
        }

        int i = (int) ((d1.getTime() - d2.getTime()) / (24 * 3600 * 1000));
        return i;
    }

    public static boolean checkDay(int year, int month, int monthDay) {
        if (year < 1900 || month < 0 || month > 11 || monthDay < 1 || monthDay > 31) return false;
        int maxDay = getMaxDays(year, month);
        if (monthDay > maxDay) return false;
        return true;
    }

    /**
     * 得到开始时间的下1秒时间,开始时间为null时得到当前时间的下1秒时间
     * 
     * @author xb
     * @param startDate
     * @return
     */
    public static Date nextSecond(Date startDate) {
        Calendar cal = Calendar.getInstance();
        if (startDate != null) {
            cal.setTime(startDate);
        }
        cal.add(Calendar.SECOND, 1);
        return cal.getTime();
    }

    /**
     * 返回当前的年月日时分秒毫秒
     * 
     * @author
     * @param startDate
     * @return
     */
    public static String getNow() {
        Calendar CD = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(CD.getTime()) + String.valueOf(CD.get(Calendar.MILLISECOND));
    }

    /**
     * 返回某个时间的n小时前（后）的时间
     * 
     * @param date
     * @param hours
     * @return
     * @author
     * @date 2008-12-3
     */
    @SuppressWarnings("deprecation")
    public static Date getDateByHours(Date date, int hours) {
        date.setHours(date.getHours() + hours);
        return date;
    }

    /**
     * 计算当天零点的时间
     * 
     * @return public static Date today0AM(){ long cur = System.currentTimeMillis(); cur-=(cur%(24*60*60*1000)); return
     * new Date(cur); }
     */
    private DateUtil(){

    }

    /**
     * @param date
     * @return
     * @author yafei.wangyf
     * @date 2008-12-28
     */
    public static String getNextDayByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return formatYYYYMMDD(cal.getTime());
    }

    /**
     * 把秒数转换为易读的时间格式 如：61秒：返回1分1秒 如：3661秒：返回1小时1分1秒
     * 
     * @param senconds
     * @return
     * @author
     * @date 2010-2-25
     */
    public static String secondsToHms(int senconds) {
        String hour = "小时";
        String minute = "分";
        String second = "秒";

        if (senconds == 0) return senconds + second;

        // long timeInMillis = 123456789;
        int hours = (int) Math.floor(senconds / (60 * 60));
        int minutes = (int) Math.floor((senconds % (60 * 60)) / 60);
        int seconds = (int) (senconds % (60 * 60)) % 60;

        String returnVal = "";
        if (hours != 0) returnVal = hours + hour;
        if (minutes != 0) returnVal += minutes + minute;
        if (seconds != 0) returnVal += seconds + second;

        return returnVal;
    }

    /**
     * 当前时间加上months月
     */
    public static Date addMonths(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }
    
    /**
     * 比较两个日期相差月份数,date2在date1 后面 返回正数
     * @param date1
     * @param date2
     * @return
     */
    public static int compareMonths(Date date1,Date date2) throws ParseException{
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        
        int monthday =0;
            
        Date startDate1 = f.parse(DateUtil.formatYYYYMMDD(date1));
      
        Calendar starCal = Calendar.getInstance();
        starCal.setTime(startDate1);

        int sYear = starCal.get(Calendar.YEAR);
        int sMonth = starCal.get(Calendar.MONTH);
        int sDay = starCal.get(Calendar.DATE);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(date2);
        int eYear = endCal.get(Calendar.YEAR);
        int eMonth = endCal.get(Calendar.MONTH);
        int eDay = endCal.get(Calendar.DATE);

        monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));

        if (sDay < eDay) {
            monthday = monthday + 1;
        }
        return monthday;
    }
    
    /**
     * 往前或后推分钟数,
     * @param startDate
     * @param minute
     * @return
     */
    public static Date nextMinute(Date startDate,int minute) {
        Calendar cal = Calendar.getInstance();
        if (startDate != null) {
            cal.setTime(startDate);
        }
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(DateUtil.compareMonths(DateUtil.parseDate("2011-6-1 18:22"),
                                                    DateUtil.parseDate("2012-7-1")));
            // System.out.println(formatDateTime(today0AM(), "yyyy-MM-dd hh:mm:ss"));
        } catch (ParseException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }
}
