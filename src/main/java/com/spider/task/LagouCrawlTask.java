package com.spider.task;

import com.spider.service.LagouCrawlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class LagouCrawlTask {

    @Autowired
    private LagouCrawlService lagouCrawlService;

    //日志打印
    private static final Logger LOGGER = LoggerFactory.getLogger(LagouCrawlTask.class);

    //每分钟执行一次
    @Scheduled(cron="0 * * * * ? ")
    public void crawl(){

        LOGGER.info("开始执行任务");
        lagouCrawlService.getAll();
        LOGGER.info("执行任务完成");
    }

}
