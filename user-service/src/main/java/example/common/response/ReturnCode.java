package example.common.response;

/**
 * 公共工具：响应码和响应描述枚举
 */
public enum ReturnCode {
    SUCCESS("000000","操作成功！"),
    FAIL("999999","操作失败！"),

    USER_SELECT_OK("000010","用户查询成功！"),
    USER_SELECT_KO("000011","用户查询失败！");

    private final String code;

    private final String message;

    public String getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }

    ReturnCode(String code,String message){
        this.code=code;
        this.message=message;
    }
}
