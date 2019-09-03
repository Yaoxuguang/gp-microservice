package com.yao.microservice.xmg.phaseone.springboot.mvc.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/9/2 12:14
 */
@Controller
public class ViewDemoController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
