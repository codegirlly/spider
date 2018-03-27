package com.spider.test;

import com.spider.entity.JobEntity;
import com.spider.repository.JobMongoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMongo {


    @Autowired
    private JobMongoRepository mongoRepository;

    @Test
    public void test(){
        try {
            JobEntity entity = new JobEntity();
            entity.setLgId(454545L);
            entity.setLgPosition("dfdfdfdfd");
            mongoRepository.save(entity);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("插入成功");
    }

}
