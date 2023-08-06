package example.dao.po;

import example.pojo.User;
import lombok.Data;

@Data
public class TbOrderPo {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}
