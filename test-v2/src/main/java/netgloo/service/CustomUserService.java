package netgloo.service;

import netgloo.models.User;
import netgloo.models.UserDao;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * Created by wuzhuo on 17/5/18.
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("s:"+s);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }

}
