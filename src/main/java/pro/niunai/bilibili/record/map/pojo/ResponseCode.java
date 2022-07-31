package pro.niunai.bilibili.record.map.pojo;

/**
 * 错误代码枚举类型
 */
public enum ResponseCode {

    OK(200),
    BAD_REQUEST(400),
    FORBIDDEN(403),
    NOT_ACCEPTABLE(406),
    CONFLICT(409),
    INTERNAL_SERVER_ERROR(500);

    private Integer value;

    ResponseCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
