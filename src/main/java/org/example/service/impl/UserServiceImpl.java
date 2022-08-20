package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.common.exception.BusinessException;
import org.example.common.exception.ExceptionCode;
import org.example.common.exception.SystemException;
import org.example.dao.mapper.UserMapper;
import org.example.dao.po.TbUserPo;
import org.example.pojo.User;
import org.example.service.api.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> searchUsersByName(String name) {
        if(StringUtils.isEmpty(name)){
            throw new BusinessException(ExceptionCode.INPUT_NULL_EXP);
        }

        List<TbUserPo> userPos;
        try{
            userPos = userMapper.searchByName(name);

            log.info("数据库查询结果：{}",userPos);
        }catch (Exception e){
            log.error("数据库查询异常："+e);
            throw new SystemException(ExceptionCode.SQL_EXEC_EXP);
        }

        List<User> users = new ArrayList<>();
        if(!ObjectUtils.isEmpty(userPos)){
            for(TbUserPo po: userPos){
                User tmpUser = new User();
                BeanUtils.copyProperties(po,tmpUser);
                users.add(tmpUser);
            }
        }
        return users;
    }
}