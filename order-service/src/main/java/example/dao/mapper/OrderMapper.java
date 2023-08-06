package example.dao.mapper;

import example.dao.po.TbOrderPo;
import org.apache.ibatis.annotations.Select;


public interface OrderMapper {
    @Select("select * from tb_order where id = #{id}")
    TbOrderPo findById(Long id);
}
