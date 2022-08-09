package pro.niunai.bilibili.record.map.pojo;

/**
 * 错误代码枚举类型
 */
public enum ResponseCode {
    CONTINUE(100),
    OK(200),
    BAD_REQUEST(400),
    FORBIDDEN(403),
    NOT_ACCEPTABLE(406),
    CONFLICT(409),
    NOT_MAP(440),
    NOT_MAP_CRAFTSMAN(443),
    NOT_MAP_VALIDATION_ERROR(442),
    NOT_MAP_FORMAT_ERROR(441),
    DUPLICATE_MAP(450),
    DUPLICATE_MAP_NOPLAY(451),
    DUPLICATE_MAP_PLAY(452),
    INTERNAL_SERVER_ERROR(500);

    private Integer value;

    ResponseCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
