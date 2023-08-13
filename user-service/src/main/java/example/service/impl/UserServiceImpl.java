package example.service.impl;

import example.dao.mapper.TbUserPoMapper;
import example.dao.po.TbUserPo;
import example.pojo.User;
import example.service.api.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserPoMapper tbUserPoMapper;

    @Override
    public User queryById(Long id) {
        // todo 异常
        TbUserPo tbUserPo= tbUserPoMapper.findById(id);
        User user = new User();
        BeanUtils.copyProperties(tbUserPo,user);
        return user;
    }
}
