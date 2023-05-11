package cal.exe;

import java.math.BigDecimal;

/**
 * User: luomeichen
 * Date: 2023/5/11
 * Time: 4:27 PM
 */

public class MinusExecutor extends Executor {


    private final BigDecimal minusVal;


    public MinusExecutor(BigDecimal minusVal,BigDecimal baseVal) {
        super(baseVal);
        this.minusVal = minusVal;
    }

    @Override
    public BigDecimal exe() {
        this.newVal = this.originVal.subtract(minusVal);
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
