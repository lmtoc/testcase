package lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2023/12/26
 * lamic
 **/
public class LC207 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //不能有环，有环就不能学任何一门
        //解锁课程图
        Map<Integer, Set<Integer>> conditions = new HashMap<>();
        //条件课程图
        Map<Integer, Set<Integer>> needConditions = new HashMap<>();
        for(int i = 0;i<numCourses;i++){
            Set<Integer> set = new HashSet<>();
            set.add(-1);
            conditions.put(i,set);
            needConditions.put(i,new HashSet<>(set));
        }
        for(int[] pair:prerequisites){
            conditions.get(pair[1]).add( pair[0]);
            needConditions.get(pair[0]).add( pair[1]);
        }
        //得到conditons中0的index，这代表不需要前置条件就能上的课
        //沿着每一个不需要前置条件就能上的课找到所有连通节点并记录为visited
        int result = 0;
        //所有已经统计到的能上的课程index
        boolean[] taken = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(taken[i]){//已经统计过能上了
                continue;
            }
            if(needConditions.get(i).size() == 1 ){
                taken[i] = true;
                result++;

                //i是前置条件，对应的值是解锁课程,现在解锁了nextCourse，沿着解锁
                Set<Integer> nextCourses = conditions.get(i);
                for(Integer nextCourse:nextCourses) {
                    while (nextCourse >= 0) {
                        if (!taken[nextCourse]) { //不交叉直线图，到这个点就能停了；如果这里是跳过就会产生交叉
                            result++;
                            taken[nextCourse] = true;
                        }
                        nextCourse = 0;

                    }
                }
            }
        }
        return result>=numCourses;

    }




    public static void main(String[] args){
        System.out.println(canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}}));
    }
}
