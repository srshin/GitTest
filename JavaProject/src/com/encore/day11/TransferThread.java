package com.encore.day11;

public class TransferThread extends Thread {

	ShareArea share;

	public TransferThread(ShareArea share) {
		super();
		this.share = share;
	}

	@Override
	public void run() {
		// 12번 계좌이체한다.
		for (int i=0 ; i<=12; i++) {
			share.transfer();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
