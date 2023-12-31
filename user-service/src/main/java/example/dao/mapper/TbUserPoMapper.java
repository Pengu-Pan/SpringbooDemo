package example.dao.mapper;


import example.dao.po.TbUserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TbUserPoMapper {
    @Select("select * from tb_user where id = #{id}")
    TbUserPo findById(@Param("id") Long id);
}