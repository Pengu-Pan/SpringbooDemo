package example.service.impl;

import example.dao.mapper.UserDoMapper;
import example.dao.po.TbUserPo;
import example.pojo.User;
import example.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import example.common.exception.BusinessException;
import example.common.exception.ExceptionCode;
import example.common.exception.SystemException;
import example.dao.mapper.UserMapper;
import example.dao.po.TbUserDo;
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
    @Autowired
    UserDoMapper doMapper;

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

    @Override
    public int add(String mobile, String name, String age) {
        if(StringUtils.isEmpty(mobile)){
            throw new BusinessException(ExceptionCode.INPUT_NULL_EXP);
        }

        TbUserDo row = new TbUserDo();
        row.setMobile(mobile);
        row.setAge(age);
        row.setName(name);

        int returnCode;
        try{
            doMapper.add(row);
            returnCode = 0;
        }catch (Exception ex){
            returnCode = -1;
            throw new SystemException(ExceptionCode.SQL_EXEC_EXP);
        }

        return returnCode;
    }

    @Override
    public int update(String mobile, String name, String age) {
        if(StringUtils.isEmpty(mobile)){
            throw new BusinessException(ExceptionCode.INPUT_NULL_EXP);
        }
        TbUserDo row = new TbUserDo();
        row.setMobile(mobile);
        row.setAge(age);
        row.setName(name);

        int returnCode;
        try{
            doMapper.update(row);
            returnCode = 0;
        }catch (Exception ex){
            returnCode = -1;
            throw new SystemException(ExceptionCode.SQL_EXEC_EXP);
        }

        return returnCode;
    }
}
