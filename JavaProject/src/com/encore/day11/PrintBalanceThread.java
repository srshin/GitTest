package com.encore.day11;

public class PrintBalanceThread extends Thread {

	ShareArea share;

	public PrintBalanceThread(ShareArea share) {
		super();
		this.share = share;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 4; i++) {
			share.print();
			try {
				Thread.sleep(390);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

