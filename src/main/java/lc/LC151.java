package lc;

/**
 * 2023/12/5
 * lamic
 **/
public class LC151 {

    public static String reverseWords(String s) {
        int left = 0;
        int right = s.length()-1;

        StringBuilder result = new StringBuilder();
        // while(s.charAt(left) == ' ' || s.charAt(right)== ' '){
        //     if(s.charAt(left) == ' '){
        //         left++;
        //     }
        //     if(s.charAt(right) == ' '){
        //         right--;
        //     }
        // }
        String [] strs = s.split(" ");
        int lastNotBlankIndex = strs.length-1;
        int headNotBlankIndex = 0;
        while(true){
            if(strs[lastNotBlankIndex] .equals("") || strs[lastNotBlankIndex] .equals(" ")){
                lastNotBlankIndex--;
            }else if(strs[headNotBlankIndex] .equals("") || strs[headNotBlankIndex] .equals(" ")){
                headNotBlankIndex++;
            }else{
                break;
            }
        }

        for(int i = lastNotBlankIndex;i>=headNotBlankIndex; i--){
            String str = strs[i];
            if(str.equals(" ") || str.equals("")){
                continue;
            }
            result.append(str);
            if(i > headNotBlankIndex ){
                result.append(" ");
                System.out.println("append \"\" ");
            }
            System.out.println("String content:["+str+"]");
        }
        return result.toString();
    }


    public static void  main(String[] args){
        System.out.println(reverseWords("the sky is blue"));
        reverseWords("  hello world  ");
    }
}
