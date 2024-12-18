package net.datasa.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    Logger log = LoggerFactory.getLogger(HomeController.class);

    // 메인 페이지 요청 처리
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
        log.info("매인페이지 호출");

        return "index"; // templates/home.html 반환
    }

}
