package cal;

import cal.exe.Executor;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * User: luomeichen
 * Date: 2023/5/11
 * Time: 3:52 PM
 */

public class Calculator {

    private Stack<Executor> calculateHistory = new Stack<>();

    private BigDecimal currentSum = BigDecimal.ZERO;



    public String run(CalType calType,String val) {
        Executor executor = Executor.getByType(calType,currentSum,new BigDecimal(val));
        currentSum = executor.exe();
        calculateHistory.push(executor);
        return currentSum.toString();
    }



    public String redo() {
        if(calculateHistory.isEmpty()){
            throw new RuntimeException("没有可以重做的操作");
        }
        Executor executor = calculateHistory.pop();
        currentSum = executor.redo();
        calculateHistory.push(executor);
        return currentSum.toString();
    }


    public String undo() {
        if(calculateHistory.isEmpty()){
            throw new RuntimeException("没有可以撤回的操作");
        }
        Executor executor = calculateHistory.pop();
        currentSum = executor.undo();
        return currentSum.toString();
    }




    //testcase
    public static void main(String[] args){

        //用例与输出
        //SAMPLE1
        //
        Calculator calculator = new Calculator();
        System.out.println(calculator.run(CalType.PLUS,"6.78"));
        System.out.println(calculator.run(CalType.MULTI,"2"));
        System.out.println(calculator.run(CalType.MULTI,"3"));
        System.out.println(calculator.undo());
        System.out.println(calculator.run(CalType.PLUS,"6.78"));
        System.out.println(calculator.run(CalType.PLUS,"6.78"));
        //print
        //6.78
        //13.56
        //40.68
        //13.56
        //20.34
        //27.12


        //SAMPLE2
        Calculator calculator2 = new Calculator();
        System.out.println(calculator2.run(CalType.PLUS,"5"));
        System.out.println(calculator2.run(CalType.DIVIDE,"2"));
        System.out.println(calculator2.run(CalType.MULTI,"2"));
        System.out.println(calculator2.undo());
        System.out.println(calculator2.run(CalType.PLUS,"9"));
        System.out.println(calculator2.redo());
        System.out.println(calculator2.run(CalType.PLUS,"6.78"));
        System.out.println(calculator2.undo());
        System.out.println(calculator2.undo());
        System.out.println(calculator2.undo());

        //print
        //5
        //3
        //6
        //3
        //12
        //12
        //18.78
        //12
        //3
        //5
    }








    //SAMPLE2
    //

}
