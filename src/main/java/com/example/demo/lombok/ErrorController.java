package com.example.demo.lombok;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

@RestController
@Slf4j
public class ErrorController {


    @RequestMapping("/lombok/user")
    public Uservo getMessage(){
        String id="1";
        String name ="testLombok";
        Uservo uservo = new Uservo();
        uservo.setId(id);
        uservo.setName(name);
        log.info(JSONObject.toJSONString(uservo));
        return uservo;

    }
}
