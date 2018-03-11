package com.spider.service.impl;

import com.spider.entity.JobEntity;
import com.spider.service.JobService;
import com.spider.service.LagouCrawlService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LagouCrawlServiveImpl implements LagouCrawlService{

    @Autowired
    private JobService jobService;

    private Map<String,String> cookie = new HashMap<String, String>();


    @Override
    public void getAll(){

        String body = null;
        LagouCrawlServiveImpl lagouCrawlServiveImpl = new LagouCrawlServiveImpl();
        String url1 = "https://www.lagou.com/zhaopin/Java/";
        String url2 = "/?filterOption=";
        String url=null;
        for(int i = 1;i<=30;i++){
            System.out.println("页码是"+i);
            url = url1+i+url2+i;
            body = lagouCrawlServiveImpl.request(url);
            lagouCrawlServiveImpl.parse(body);
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
        JobEntity jobEntity = new JobEntity();
        Document document = Jsoup.parse(body);
        Elements elements = document.select("ul.item_con_list li.con_list_item");
        for (Element element : elements) {
            System.out.println("--------------------------------------------------");
//            System.out.println(element.toString());
//            System.out.println("--------------------------------------------------");
            //获取公司
            String company = element.select("li").attr("data-company");
            System.out.println("公司为：  "+company);
            jobEntity.setLgCompany(company);
            //获取职位
            String position = element.select("li").attr("data-positionname");
            System.out.println("职位：  "+position);
            jobEntity.setLgPosition(position);
            //获取工资
            String salary = element.select("li").attr("data-salary");
            salary = salary.trim();
            salary = salary.replaceAll("K","");
            String[] salaryArray = salary.split("-");
            System.out.println("工资：" +salary);

            String begin = salaryArray[0]+"000";
             String end = salaryArray[1]+"000";

             //保存
            jobEntity.setLgSalaryBegin(begin);
            jobEntity.setLgSalaryEnd(end);
            String href = element.select("a.position_link").attr("href");//获取链接
            System.out.println("链接：  "+href);
            jobEntity.setLgHref(href);
            Long id = Long.parseLong(href.replaceAll("[^0-9]","" ));
            jobEntity.setLgId(id);
            jobEntity.setLgCreateTime(new Date());
            jobEntity.setLgUpdateTime(new Date());
            jobService.save(jobEntity);
        }

    }

    public static void main(String[] args) {

        LagouCrawlServiveImpl lagouCrawlServiveImpl = new LagouCrawlServiveImpl();
         lagouCrawlServiveImpl.getAll();

    }


}

