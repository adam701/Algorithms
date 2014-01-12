public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(numbers==null){
            return null;
        }
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]),i+1};
            }
            map.put(numbers[i],i+1);

        }
        return null;
    }
};