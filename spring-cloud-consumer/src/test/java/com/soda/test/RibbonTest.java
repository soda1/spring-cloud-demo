package com.soda.test;

import com.soda.cloud.ConsumerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerApplication.class)
public class RibbonTest {

    @Autowired
    private LoadBalancerClient ribbonClient;



    @Test
    public void testRibbon() {


        for (int i = 0; i < 100; i++) {

            ServiceInstance bookServer = ribbonClient.choose("consumerServer");

            System.out.println(bookServer.getHost() + ":" + bookServer.getPort());

        }

    }



}
