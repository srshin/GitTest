package com.encore.day10;

import java.util.Comparator;

public class DescendingMySum  implements Comparator<MySum>{

	@Override
	public int compare(MySum o1, MySum o2) {
		return o2.first+o2.second - o1.first - o1.second;
	}

}
