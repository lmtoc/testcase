package cal.exe;

import java.math.BigDecimal;

/**
 * User: luomeichen
 * Date: 2023/5/11
 * Time: 4:27 PM
 */

public class MultiExecutor extends Executor {

    private BigDecimal multiParam;

    public MultiExecutor(BigDecimal multiParam,BigDecimal baseVal) {
        super(baseVal);
        this.multiParam = multiParam;
    }

    @Override
    public BigDecimal exe() {
        this.newVal = this.originVal.multiply(multiParam);
        return this.newVal;
    }

    @Override
    public BigDecimal undo() {
        return this.originVal;
    }

    @Override
    public BigDecimal redo() {
        return exe();
    }
}
