package com.encore.day09_1;

class OverridingTest {
    public static void main(String args[]){
        int i = 10;
        int j = 20;
        String s1 = new String("30");

        MySum ms1 = new MySum(i, j);
        MySum ms2 = new MySum(i, j);

        System.out.println(ms1);
        System.out.println(ms2);
        
        System.out.println("ms1과 ms2의 합계는 " + ( (ms1.equals(ms2)? "동일합니다" : "동일하지 않습니다")));
        System.out.println("ms1과 s1의 값은 " + ( (ms1.equals(s1)? "동일합니다" : "동일하지 않습니다")));
    }
}

