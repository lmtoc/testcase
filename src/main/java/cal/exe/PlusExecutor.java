package cal.exe;

import java.math.BigDecimal;

/**
 * User: luomeichen
 * Date: 2023/5/11
 * Time: 4:21 PM
 */

public class PlusExecutor extends Executor {

    private final BigDecimal incParam;

    public PlusExecutor(BigDecimal incParam, BigDecimal baseVal) {
        super(baseVal);
        this.incParam = incParam;
    }

    @Override
    public BigDecimal exe() {
        this.newVal = this.originVal.add(incParam);
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
