package cn.tellsea.service;

import cn.tellsea.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author James
 */
@Service
public class BusinessService {

    @Autowired
    private UserService userService;

    @Transactional(rollbackFor = Exception.class)
    public void saveUser() {
        User user = new User();
        user.setName("cd");
        user.setPasswd("****");
        userService.insert(user);
        // test transaction
        int a = 1 / 0;
        User user1 = user.clone();
        user1.setName("cd1");
        userService.insert(user1);
    }
}
