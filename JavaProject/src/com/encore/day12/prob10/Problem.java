package com.encore.day12.prob10;

import java.util.HashMap;
import java.util.Map;

import com.encore.day11.Fruit;
/**
 * 
 * 	@author SDS
 *	연예인중에서 생일이 08달인 사람들이 총 몇명인지 출력하세요
 *	API 활용하세요 
 */
public class Problem {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();

        map.put("유재석", "19720814");
        map.put("박명수", "19700827");
        map.put("정준하", "19710318");
        map.put("정형돈", "19780315");
        map.put("하하", "19790820");
        map.put("황광희", "19880825");

        countBirthMonth(map, "08");
    }

    public static void countBirthMonth(Map<String, String> map, String thisMonth) {

        // ========== 구현 시작 ==========
    	int count = 0; 
		for (String s: map.values()) {
			 if(s.substring(4, 6).equals(thisMonth)) {
				 count++;
			 }
		}        
		 System.out.println(count);
        
        
        
        // ========== 구현 끝 ============
    }
}
