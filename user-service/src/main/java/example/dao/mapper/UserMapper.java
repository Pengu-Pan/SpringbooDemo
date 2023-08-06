package example.dao.mapper;

import example.dao.po.TbUserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from tb_test_01 where name like '%'||#{name}||'%' ")
    public List<TbUserPo> searchByName(String name);
}
