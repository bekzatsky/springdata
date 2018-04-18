package kz.springlesson.springdata;

import kz.springlesson.springdata.dao.UserDao;
import kz.springlesson.springdata.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao = (UserDao) ac.getBean("userDao");
        User user = (User) ac.getBean("user");
        userDao.addUser(user);
        System.out.println(userDao.getUserById(7));
    }
}
