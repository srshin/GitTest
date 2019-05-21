package com.encore.day07_2;

public class Radio implements Volume {
	int level; 
	@Override
	public void volumeUp(int level) {
		this.level += level; 
		System.out.println("speaker volume을 올립니다"+this.level);
	}

	@Override
	public void volumeDown(int level) {
		this.level -= level; 
		System.out.println("speaker volume을 내립니다"+this.level);
	}

}
