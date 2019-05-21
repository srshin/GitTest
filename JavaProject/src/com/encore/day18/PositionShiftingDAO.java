package com.encore.day18;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PositionShiftingDAO {

	public static String[][] encoreSeat() {
		String[][] seat = new String[4][9];
		return seat;
	}

	public static String[][] checkMate() {
		// 처음 짝궁을 파일로 불러옴.
		String file_name = "src/com/encore/day18/mateList.csv";

		Map<String, String> mateList = new HashMap<>();
		Map<String, String> mateList_rev = new HashMap<>();
		Map<String, String> new_mateList = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file_name));) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				mateList.put(data[0], data[1]); //짝궁리스트
				mateList.put(data[1], data[0]); //짝궁리스트 반전
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		aa: while (true) {
			// 새로운 짝궁과 비교
			String[][] position_result = positionShift();
			for (int row = 0; row < position_result.length; row++) {
				new_mateList.put(position_result[row][2], position_result[row][3]);
				new_mateList.put(position_result[row][5], position_result[row][6]);
				if (row == 1 || row == 2) {
					new_mateList.put(position_result[row][0], position_result[row][1]);
				}
			}
			//중복 개수 체크
			int cnt = 0;
			for (Map.Entry<String, String> entry : mateList.entrySet()) {
				if (new_mateList.entrySet().contains(entry)) {
					cnt++;
				}
			}
			for (Map.Entry<String, String> entry : mateList_rev.entrySet()) {
				if (new_mateList.entrySet().contains(entry)) {
					cnt++;
				}
			}
			// 적합하면 같은 파일에 짝궁을 업로드. 중복이 발생하면 재시도
			if (cnt  > 0) {
				System.out.println("짝궁 중복이 " + cnt +"개 발생하였습니다.");
				System.out.println("자리 배치를 다시 시작합니다.");
				continue aa; // 재시도
			} else {
				String eol = System.getProperty("line.separator");
				try (Writer writer = new FileWriter("src/com/encore/day18/mateList2.csv");) // 새로운 짝궁 업로드.
				{
					for (Map.Entry<String, String> entry : new_mateList.entrySet()) {
						writer.append(entry.getKey()).append(',').append(entry.getValue()).append(eol);
					}
					return position_result;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String[][] positionShift() {
		List<PSDTO> studentArr = dataAccess();

		// Random seed shuffling
		long seed = System.nanoTime();
		Collections.shuffle(studentArr, new Random(seed));

		// 셔플된 리스트로 전공자/비전공자 구분
		ArrayList<PSDTO> major = new ArrayList<>();
		ArrayList<PSDTO> nonMajor = new ArrayList<>();

		for (PSDTO student : studentArr) {
			if (!student.getItSkill().equals("NULL")) {
				major.add(student);
			} else {
				nonMajor.add(student);
			}
		}
		// 빈자리
		String[][] defaultSeat = encoreSeat();
		// 자리배치
		int i = 0;
		int j = 0;
		boolean toggle = true;
		for (int row = 0; row < defaultSeat.length; row++) {
			for (int col = 0; col < defaultSeat[0].length; col++) {
				// 빈공간 예외처리
				if (row == 0 && col == 0) {
					defaultSeat[row][col] = " ";
					continue;
				}
				if (col == 4 || col == 8) {
					defaultSeat[row][col] = " ";
					continue;
				}
				if ((row == 2 || row == 3) && col == 7) {
					defaultSeat[row][col] = " ";
					continue;
				}
				if (row == 3 && (col == 0 || col == 1)) {
					defaultSeat[row][col] = " ";
					continue;
				}
				// 자리배치
				if (toggle) {
					defaultSeat[row][col] = nonMajor.get(j++).getName();
					if (j <= major.size())
						toggle = !toggle;
				} else {
					defaultSeat[row][col] = major.get(i++).getName();
					if (i <= major.size())
						toggle = !toggle;
				
				}
			}
		}

		return defaultSeat;
	}

	public static void fullDatePrint() {
		List<PSDTO> studentArr = dataAccess();
		for (PSDTO student : studentArr) {
			System.out.println(student);
		}
	}

	public static List<PSDTO> dataAccess() {

		String file_name = "src/com/encore/day18/student.csv";
		ArrayList<PSDTO> studentArr = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file_name));) {

			br.readLine(); // header delete

			String line;

			while ((line = br.readLine()) != null) {
				String[] lineArr = line.split(",");

				PSDTO data = new PSDTO(Integer.parseInt(lineArr[0]), lineArr[1], lineArr[2], lineArr[3]);
				studentArr.add(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return studentArr;

	}
}
