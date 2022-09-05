package cn.cvzhanshi.wechatpush;

import cn.cvzhanshi.wechatpush.config.Pusher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class WechatpushApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatpushApplication.class, args);
        Pusher.push("o-WcX6op8NCLS3z3J8Ez1JpBIwxA", "440305");//我
//        Pusher.push("o-WcX6oTb5P_kKh4YNv0CRBWins4", "510100");//张志凯
    }


    @Scheduled(cron = "0 20 23 * * ? ")
    public void goodMorning() {
        Pusher.push("o-WcX6op8NCLS3z3J8Ez1JpBIwxA", "440305");//我
        Pusher.push("o-WcX6oTb5P_kKh4YNv0CRBWins4", "510100");//张志凯
        log.info("发送成功");
    }

    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void goodMorning1() {
//        Pusher.push("o-WcX6op8NCLS3z3J8Ez1JpBIwxA", "440305");//我
//        Pusher.push("o-WcX6oTb5P_kKh4YNv0CRBWins4", "510100");//张志凯
        log.info("每一小时发送一次");
    }

}
