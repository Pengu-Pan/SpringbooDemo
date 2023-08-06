package example.dao.mapper;

import java.util.List;

import example.dao.po.TbUserPo;

public interface TbUserPoMapper {
    int deleteByPrimaryKey(String mobile);

    int insert(TbUserPo row);

    TbUserPo selectByPrimaryKey(String mobile);

    List<TbUserPo> selectAll();

    int updateByPrimaryKey(TbUserPo row);
}