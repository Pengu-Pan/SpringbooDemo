package org.example.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.dao.po.TbUserDo;

import java.util.List;

@Mapper
public interface UserDoMapper {

    List<TbUserDo> searchByAgeRange(String min, String max);

}
