package com.spider.cnblog;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class CnblogSpider {
    public static void main(String[] args) {
        String url = "https://www.cnblogs.com/";
        try {
            Connection.Response response = Jsoup.connect(url).method(Connection.Method.GET).execute();
            String body = response.body();
            System.out.println(body);

            Document doc = Jsoup.parse(body);
            Elements elements = doc.select("div#post_list div.post_item");
            for(Element element: elements){
//                System.out.println("-------------");
//                System.out.println(element.toString());
                String title = element.select("a.titlelnk").text();
                System.out.println(title);
                String author = element.select("a.lightblue").text();
                String link = element.select("a").attr("href");
                System.out.println("作者：  "+author);
                System.out.println("链接：  "+link);
                System.out.println("-------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
