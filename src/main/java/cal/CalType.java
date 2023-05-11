package cal;

/**
 * User: luomeichen
 * Date: 2023/5/11
 * Time: 4:30 PM
 */

public enum CalType {
    PLUS(1,"加"),
    MINUS(2,"减"),
    MULTI(3,"乘"),
    DIVIDE(4,"除");


    private int type;

    private String desc;

    CalType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
