package exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 在 DJI 的工时打卡计算系统中，一个工作日的定义是由工作日当天的凌晨 03:00:00 开始，到隔天凌晨 03:00:00（不包含） 为止。
 这其中，工作日当天的中午 12:30:00 到下午 14:00:00（不包含）为午休时间，不计入工作时间中。Tom 由于工作繁忙，
 担心自己有时候会忘记打卡，因此每次他经过打卡机到时候都会不由自主地打一次卡。为了更好的了解自己的工作情况，
 Tom 找到了自己整个八月份的乱序打卡记录，但是这些数据不小心弄乱了，所以 Tom 想请你帮个忙。从给出的 N 条打卡记录中，
 找出所有有效的打卡工作日（即在该工作日中打卡次数 >= 2并且有效工作时间 > 0），并计算该工作日中的有效工作时间（按秒计算，除去打卡时间内出现的午休时间）。其中工作日定义为当天3:00:00到次日2:59:59为当天工作日，即当天2:59:59(包括)以前的打卡记录算作前一天打卡记录和有效工作时间，不计做当天的打卡记录和有效工作时间。
 输入
 第一行为一个整数 N （0<N<200），随后有 N 行数据，每行是一个形如 mm.dd hh:mm:ss 打卡记录。
 输出
 输出若干行数据，按照时间先后排序，每行包括工作日的起始日期以及工作的总时长，如 08.01 36000 。如果全部数据中有效打卡工作日为0，输出-1。

 样例输入
 12
 08.10 01:00:00
 08.09 23:59:59
 08.10 17:00:00
 08.10 18:00:00
 08.01 01:00:00
 08.01 04:00:00
 08.03 10:00:00
 08.03 12:29:59
 08.04 10:00:00
 08.04 12:30:00
 08.07 01:00:00
 08.07 02:00:00
 样例输出
 08.03 8999
 08.04 9000
 08.06 3600
 08.09 3601
 08.10 3600
 */
public class DjiTest2 implements ITestRun{
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.mm.dd hh:mm:ss");
        MyDate[] myDates = new MyDate[n];
        Map<Integer, MyDate> myDateMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            MyDate myDate = new MyDate();
            try {
                myDate.setDate( simpleDateFormat.parse("2017." + scanner.nextLine()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }


    class MyDate{
        Date date;

        public void setDate(Date date) {
            this.date = date;
            Date date1 = (Date) date.clone();
            date1.setHours(2);
            date1.setMinutes(59);
            date1.setSeconds(59);
            if (date.getTime() > date1.getTime()){
                System.out.println(date.getDate());
            }else {
                System.out.println(date.getDate() -1);
            }
        }

        int month_day;
    }
}
