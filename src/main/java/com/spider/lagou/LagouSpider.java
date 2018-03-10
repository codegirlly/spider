package com.spider.lagou;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.CookieHandler;
import java.util.HashMap;
import java.util.Map;

public class LagouSpider {

    private Map<String,String> cookie = new HashMap<String, String>();

    public void getAll(){

        String body = null;
        LagouSpider lagouSpider = new LagouSpider();
        String url1 = "https://www.lagou.com/zhaopin/Java/";
        String url2 = "/?filterOption=";
        String url=null;
        for(int i = 1;i<=30;i++){
            System.out.println("页码是"+i);
            url = url1+i+url2+i;
            body = lagouSpider.request(url);
            lagouSpider.parse(body);
           try{
               Thread.sleep(1000);
           }catch(InterruptedException e){
               e.printStackTrace();
           }
        }
    }
    public String request(String url) {

        String body = null;
        try {
            Connection.Response response = Jsoup.connect(url)
                    .header("Referer", "https://www.lagou.com/")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWe" +
                            "bKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36")
                    .header("Host", "www.lagou.com")
                    .cookies(cookie)
                    .method(Connection.Method.GET)
                    .execute();
            cookie = response.cookies();
            body = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    public void parse(String body) {
//        System.out.println(body);
        Document document = Jsoup.parse(body);
        Elements elements = document.select("ul.item_con_list li.con_list_item");
        for (Element element : elements) {
            System.out.println("--------------------------------------------------");
//            System.out.println(element.toString());
//            System.out.println("--------------------------------------------------");
            String company = element.select("li").attr("data-company");
            System.out.println("公司为：  "+company);
            String position = element.select("li").attr("data-positionname");
            System.out.println("职位：  "+position);
            String salary = element.select("li").attr("data-salary");
            System.out.println("工资：" +salary);
            String href = element.select("a.position_link").attr("href");
            System.out.println("链接：  "+href);

        }

    }

    public static void main(String[] args) {

        LagouSpider lagouSpider = new LagouSpider();
         lagouSpider.getAll();

    }
}

