package lcr;

/**
 * 2024/2/5
 * lamic
 **/
public class LCR038 {

    public int[] dailyTemperatures(int[] temperatures) {
        //最后一天肯定没有更高的气温，所以从后往前推
        //当前温度如果比后一天高则找到比当前高的；如果比后一天低则是1
        int []result = new int[temperatures.length];
        result[temperatures.length-1] = 0;
        for(int i = temperatures.length-2;i >=0;i--){
            if(temperatures[i] < temperatures[i+1]){
                result[i] = 1;
            }else{
                int day = i+1+result[i+1];
                while(day<= temperatures.length-1 ){
                    if(temperatures[day] > temperatures[i] ){
                        result[i] = day-i;
                        break;
                    }else if(result[day] == 0){
                        result[i] = 0;
                        break;
                    } else {
                        day = result[day]+day;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        LCR038 lcr038 = new LCR038();
        lcr038.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
