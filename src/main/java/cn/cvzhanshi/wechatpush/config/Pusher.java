package cn.cvzhanshi.wechatpush.config;


import cn.cvzhanshi.wechatpush.entity.Weather;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

/**
 * @author cVzhanshi
 * @create 2022-08-04 21:09
 */
public class Pusher {

    public static void main(String[] args) {
        push();
    }

    private static String appId = "wx04dedaef83dcabce";
    private static String secret = "65c8f39499f0b8bae2d888ab74338e8d";


    public static void push() {
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("o-WcX6op8NCLS3z3J8Ez1JpBIwxA")
                .templateId("S4opNGY4Bz-J1PkgaF_mN7z7U7SeeUFaJmZ0BE8I9v4")
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        Weather weather = WeatherUtils.getWeather();
        String request = CaiHongPiUtils.request("http://api.tianapi.com/caihongpi/index?key=", "cc255151a359ed7909aed4da8125f703");
        templateMessage.addData(new WxMpTemplateData("riqi", weather.getDate() + "  " + weather.getWeek(), "#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi", weather.getText_now(), "#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low", weather.getLow() + "", "#173177"));
        templateMessage.addData(new WxMpTemplateData("temp", weather.getTemp() + "", "#EE212D"));
        templateMessage.addData(new WxMpTemplateData("high", weather.getHigh() + "", "#FF6347"));
        templateMessage.addData(new WxMpTemplateData("windclass", weather.getWind_class() + "", "#42B857"));
        templateMessage.addData(new WxMpTemplateData("winddir", weather.getWind_dir() + "", "#B95EA3"));
        templateMessage.addData(new WxMpTemplateData("caihongpi", "\t" + request, "#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("lianai1", JiNianRiUtils.getLianAi() + "", "#FF1493"));
        templateMessage.addData(new WxMpTemplateData("lianai2", JiNianRiUtils.getLianAi() + "", "#FF1493"));
        templateMessage.addData(new WxMpTemplateData("shengri1", JiNianRiUtils.getBirthday_Jo() + "", "#FFA500"));
        templateMessage.addData(new WxMpTemplateData("shengri2", JiNianRiUtils.getBirthday_Hui() + "", "#FFA500"));
        String beizhu = "\t" + "顺顺❤凯凯";
        if (JiNianRiUtils.getLianAi() % 365 == 0) {
            beizhu = "今天是恋爱" + (JiNianRiUtils.getLianAi() / 365) + "周年纪念日！";
        }
        if (JiNianRiUtils.getBirthday_Jo() == 0) {
            beizhu = "今天是弟弟生日，生日快乐呀！";
        }
        if (JiNianRiUtils.getBirthday_Hui() == 0) {
            beizhu = "今天是哥哥生日，生日快乐呀！";
        }
        templateMessage.addData(new WxMpTemplateData("beizhu", beizhu, "#FF0000"));

        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
