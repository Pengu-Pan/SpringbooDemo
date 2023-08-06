package example.dao.po;

import lombok.Data;

@Data
public class TbOrderPo {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private TbUserPo user;
}
