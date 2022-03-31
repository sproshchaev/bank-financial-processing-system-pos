package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс JspController содержит методы для работы с JSP-страницами
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */

@Controller
@RequestMapping(value = "/bank")
public class JspController {

    private static final Logger logger = LoggerFactory.getLogger(JspController.class);

    @Value("${appName}")
    private String appName;

    @Value("${dbType}")
    private String dbType;

    /**
     * Метод info выполняет тестирование JSP-страниц
     *
     * @return - ModelAndView
     */
    @RequestMapping("/testjsp")
    public ModelAndView info() {

        logger.info("JspController. Вызов /testjsp...");

        ModelAndView modelAndView = new ModelAndView("/views/info.jsp");
        modelAndView.addObject("appName", appName);
        modelAndView.addObject("dbType", dbType);
        modelAndView.addObject("dateAndTime", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

        return modelAndView;
    }

}
