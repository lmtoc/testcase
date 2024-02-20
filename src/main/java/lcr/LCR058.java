package lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024/2/14
 * lamic
 **/
public class LCR058 {

        List<int[]> calendar = new ArrayList();

        public LCR058() {

        }

        public boolean book(int start, int end) {
            if(start>end){
                return false;
            }
            return merge(start,end);
        }

        //这里判断重复预定，[start,end] 要么完全插入间隙；要么就在队头队尾
//不然就是重复预定
        private boolean merge(int start,int end){
            if(calendar.size() == 0){
                calendar.add(new int[]{start,end});
                return true;
            }else if(end<=calendar.get(0)[0]){
                calendar.add(0,new int[]{start,end});
                return true;
            }else if(start>= calendar.get(calendar.size()-1)[1]){
                calendar.add(new int[]{start,end});
                return true;
            }
            for(int i = 0;i<calendar.size();i++){
                if(i>0 && start>=calendar.get(i-1)[1]&&end<=calendar.get(i)[0]){
                    calendar.add(i,new int[]{start,end});
                    return true;
                }
            }
            return false;
        }


    public static void main(String[] args) {
        LCR058 lcr058 = new LCR058();
        lcr058.book(20,29);
        lcr058.book(13,22);
        lcr058.book(44,50);
        lcr058.book(1,7);
        lcr058.book(2,10);
        lcr058.book(14,20);


    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
}
