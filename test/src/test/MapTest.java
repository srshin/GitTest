package test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		   map.put("arun singh", 1);
		   map.put("arun singh2", 1);
		   map.put("arun singh3", 1);
		   map.put("arun singh4", 1);
		    
		
		
		Stream<Map.Entry<String,Integer>> sorted =
			    map.entrySet().stream()
			       .sorted(Map.Entry.comparingByValue());
	}

}
