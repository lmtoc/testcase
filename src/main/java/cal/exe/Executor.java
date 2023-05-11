package cal.exe;

import cal.CalType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * User: luomeichen
 * Date: 2023/5/11
 * Time: 4:18 PM
 */

public abstract class Executor {

    protected BigDecimal newVal;

    protected BigDecimal originVal;

    public Executor(BigDecimal originVal) {
        this.originVal = originVal;
    }

    public abstract BigDecimal exe();


    public abstract BigDecimal undo();


    public abstract BigDecimal redo();



    public static  Executor getByType(CalType calType,BigDecimal basVal,BigDecimal input){
        if(CalType.PLUS.getType() == calType.getType()){
            return new PlusExecutor(input,basVal);
        }else if(CalType.DIVIDE.getType() == calType.getType()){
            return new DivideExecutor(input,basVal);
        }else if(CalType.MINUS.getType() == calType.getType()){
            return new MinusExecutor(input,basVal);
        }else if(CalType.MULTI.getType() == calType.getType()){
            return new MultiExecutor(input,basVal);
        }
        throw new RuntimeException("操作类型未支持");
    }

}
