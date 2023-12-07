package lc;

/**
 * 2023/12/7
 * lamic
 **/
public class LC28 {


    public static void main(String[] args){
//        System.out.println(strStr("sadbutsad","sad"));
//        System.out.println(strStr("mississippi","mississippi"));
        System.out.println(strStr("mississippi","sipp"));
    }

    public static int strStr(String haystack, String needle) {
        int i = 0;
        int window = needle.length();
        while(i<=haystack.length()-window ){
            if(haystack.charAt(i) == needle.charAt(0) && needle.charAt(window-1) == haystack.charAt(i+window-1) && contains(haystack,needle,i,window)){
                return i;
            }
            i++;

        }
        return -1;

    }

    private static boolean contains(String haystack, String needle,int hIndexFrom,int window){
        int i = hIndexFrom;
        int needleIndex = 0;
        int endIndex = window-1;
        int iEnd = i+endIndex;
        while( iEnd >= i){
            if(haystack.charAt(i) != needle.charAt(needleIndex) || haystack.charAt(iEnd) != needle.charAt(endIndex)){
                return false;
            }
            needleIndex++;
            i++;
            endIndex--;
            iEnd--;
        }
        return true;
    }
}
