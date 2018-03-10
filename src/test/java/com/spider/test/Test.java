package com.spider.test;

public class Test {

    public static void main(String[] args) {
        String href = "https://www.lagou.com/jobs/4133403.html";
        String id = href.replaceAll("[^0-9]q","" );
        System.out.println(id);

    }

}
