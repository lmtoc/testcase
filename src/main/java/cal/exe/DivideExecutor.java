package cal.exe;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * User: luomeichen
 * Date: 2023/5/11
 * Time: 4:29 PM
 */

public class DivideExecutor extends Executor {

    private final BigDecimal divideParam;

    public DivideExecutor(BigDecimal divideParam,BigDecimal baseVal) {
        super(baseVal);
        this.divideParam = divideParam;
    }

    @Override
    public BigDecimal exe() {
        newVal =  this.originVal.divide(divideParam,RoundingMode.HALF_UP);
        return newVal;
    }

    @Override
    public BigDecimal undo() {
        return originVal;
    }

    @Override
    public BigDecimal redo() {
        return exe();
    }
}
