package cn.tellsea.controller;

import cn.tellsea.bean.User;
import cn.tellsea.service.BusinessService;
import cn.tellsea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James
 */
@RestController
public class UserController {

    @Autowired
    private BusinessService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String testAdd() {
        userService.saveUser();
        return "success";
    }
}
