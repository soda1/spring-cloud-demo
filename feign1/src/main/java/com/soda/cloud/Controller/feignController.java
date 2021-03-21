package com.soda.cloud.Controller;

import com.soda.cloud.feign.api.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")
public class feignController {


    @Autowired
    private ProviderFeign providerFeign;


    /**
     *测试feign调用
     * @param name
     * @return
     */
    @GetMapping("/book/{name}")
    public String getBook(@PathVariable("name")String name) {
        //feign调用远程服务
        return providerFeign.getBook(name);
    }

    /**
     * 测试feign fallback
     *
     * @return
     */
    @GetMapping("/error")
    public String error() {
        //feign调用远程服务
        return providerFeign.error();
    }



    /**
     * 测试feign，get方法参数怎么传递
     * @param param1
     * @return
     */
    @GetMapping("/get")
    String getMethodTest(String param1) {

        return providerFeign.getMethodTest(param1);

    }


    /**
     * 测试feign，post方法参数怎么传递
     * @param param1
     * @return
     */
    @PostMapping("/post")
    String postMethodTest(String param1) {

        return providerFeign.postMethodTest(param1);

    }


    /**
     * post多参接收
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    @PostMapping("/post/many")
    public String postManyTest( String param1,  String param2,  String param3) {
        return providerFeign.postManyTest(param1, param2, param3);
    }

    /**
     * 测试feign超时
     * @param sleepTime
     * @return
     */
    @GetMapping("/timeout/{time}")
    String timeout(@PathVariable("time") int sleepTime) {
        return providerFeign.timeout(sleepTime);
    }

}
