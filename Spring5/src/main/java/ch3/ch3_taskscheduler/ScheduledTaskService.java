package ch3.ch3_taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 计划任务，每隔固定事件执行
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每五秒执行一次：" + dateFormat.format(new Date()));
    }

    // 每天固定时间执行 15:16执行
    @Scheduled(cron = "0 16 15 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间 " + dateFormat.format(new Date()) + "执行");
    }
}
