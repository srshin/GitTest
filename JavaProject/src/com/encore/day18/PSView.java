package com.encore.day18;

import java.awt.Dimension;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PSView extends JFrame{

	public static void display() {

	}

	public static void displaySeat() {

		
		String[][] finalSeat = PositionShiftingDAO.checkMate();;
		//JTable 사용하여 출력.
		Dimension dim = new Dimension(1000, 200);
		JFrame frame = new JFrame("엔코아 자리배치");
		frame.setLocation(200,400);
		frame.setPreferredSize(dim);
		//테이블 첫줄
		String[] header = new String[finalSeat[0].length];
		Arrays.fill(header, " ");
		//자리배치
		JTable table = new JTable(finalSeat, header);
		JScrollPane sp = new JScrollPane(table);
		//출력
		frame.add(sp);
		frame.pack();
		frame.setVisible(true);
		
	}

}
