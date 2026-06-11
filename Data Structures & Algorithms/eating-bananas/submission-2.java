class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Take values of potential k from 1 to max(piles) in and array
        // apply binary serach in the array of k values.
        // for every k value count the number of hours to complete all the piles.
        // if  number of hours to complete all the piles <= h , Take res = min(res, k)
        // move the right pointer to k-1.
        // else move the left pointer to k + 1.
        

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int k, totalHours;
        int res = r;
        
        while(l<=r) {
            totalHours = 0;
            k = (int)((l + r) / 2); 
            for(int p : piles){
                totalHours += Math.ceil((double) p / k);
            }
            if(totalHours <= h) {
                res = Math.min(res, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;   
    }
}
