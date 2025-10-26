class Solution {
    public int totalMoney(int n) {
        int term =n/7;//find the perfect weeks eg. 23 days then 17/7=1 weeks and remaing 3 days will solve differently
        int first=28;if calculate the money of first week it is 28 1+2+3+4+5+6+7
        int last=28 + (term -1 )*7;
        int result=term *(56+(term-1)*7)/2;// also term*(first+last)/2;

        int remain=n%7;//calculating for remaining 3 days 
        int firsterm=term+1;
        int lasterm=firsterm+remain-1;//formula for last term
        result += remain*(firsterm + lasterm)/2;// add the result of remaing to the result of perfect
        return result;


        /*
        1 2 3 4 5 6 7
        2 3 4 5 6 7 8
        3 4 5 (3= firsterm + 1 i.e, 1+1 now if 23 days then still same imagine the matrix)
        */
    }
}