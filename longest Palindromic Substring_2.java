public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String processedStr=preprocess(s);
        int center=0;
        int rightEdge=0;
        int maxLeft=0;
        int maxRight=0;
        int centerPoints=processedStr.length();
        int[] maxLength=new int[centerPoints];
        for(int i=0;i<centerPoints;i++){
            int mirror;
            int left,right;
            int tempLength=0;
            if(rightEdge>i){
                mirror=center-(i-center);
                if(maxLength[mirror]<rightEdge-i){
                    maxLength[i]=maxLength[mirror];
                    continue;
                }
                else{
                    left=i-(rightEdge-i)-1;
                    right=rightEdge+1;
                    tempLength=rightEdge-i;
                }
            }
            else{
                left=i-1;
                right=i+1;
            }
            while(left>=0 && right<centerPoints){
                if(processedStr.charAt(left)==processedStr.charAt(right)){
                    tempLength++;
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }
            maxLength[i]=tempLength;
            if(i+tempLength>rightEdge){
                rightEdge=i+tempLength;
                center=i;
            }
            if(((right-1)/2-(left+2)/2)>maxRight/2-(maxLeft+1)/2){
                maxLeft=left+1;;
                maxRight=right-1;
            }
        }
        return s.substring((maxLeft+1)/2,maxRight/2+1);
    }
    
    private String preprocess(String s){
        StringBuilder strBuilder=new StringBuilder();
        if(s==null || s.length()==0){
            return null;
        }
        strBuilder.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            strBuilder.append("#");
            strBuilder.append(s.charAt(i));
        }
        return strBuilder.toString();
    }
}