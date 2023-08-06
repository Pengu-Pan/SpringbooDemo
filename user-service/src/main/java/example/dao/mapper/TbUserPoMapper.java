package example.dao.mapper;

import java.util.List;

import example.dao.po.TbUserPo;
import example.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TbUserPoMapper {
    @Select("select * from tb_user where id = #{id}")
    TbUserPo findById(@Param("id") Long id);
}