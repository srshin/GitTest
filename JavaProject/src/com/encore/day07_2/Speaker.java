package com.encore.day07_2;

public class Speaker implements Volume {
	int level; 
	@Override
	public void volumeUp(int level) {
		this.level += level; 
		if (this.level > 100 )
			this.level = 100; 
		System.out.println("speaker volume을 올립니다"+this.level);
	}

	@Override
	public void volumeDown(int level) {
		this.level -= level; 
		if (this.level <0 )
			this.level = 0; 
		System.out.println("speaker volume을 내립니다"+this.level);
	}

}
