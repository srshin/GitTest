package com.encore.day18_2;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StdDAO {

	public ArrayList<String> repeatCheckList() {
		boolean check = false;
		ArrayList<String> stdlist = null;

		// 지난, 짝 리스트
		String[][] prevList = { { "백하연", "임왕기" }, { "임왕기", "이남기" }, { "위정욱", "정인창" }, 
				{ "정인창", "김휘중" },	{ "방서경", "정윤도" }, { "정윤도", "박소영" }, 
				{ "박소영", "윤창민" }, { "허정표", "배지수" }, { "배지수", "박정은" },
				{ "문상수", "이광호" }, { "이광호", "현진우" }, { "현진우", "정인아" }, 
				{ "박성철", "박세환" }, { "신상림", "오승진" }, { "이아라", "이진주" } };

		// 겹치는 짝이 발견되면, 리스트 다시 생성
		do {
			stdlist = getShuffleList();
			System.out.println(stdlist);
			// 리스트 배열로 변경(비교 편하게 하기 위해서)
			String[] std = stdlist.toArray(new String[stdlist.size()]);

			end: for (int i = 0; i < std.length - 1; i++) {
				String[] compare = { std[i], std[i + 1] };
				Arrays.sort(compare); // 정확한 비교를 위한 정렬
				// System.out.println(Arrays.toString(compare));
				for (String[] s : prevList) {
					Arrays.sort(s);
					// System.out.println(Arrays.toString(s));
					if (Arrays.equals(s, compare)) {
						System.out.println("겹치는 짝 발견!");
						System.out.println(Arrays.toString(compare));
						check = true;
						break end;
					}
				} // inner for
				check = false; 
			} // outer for
		} while (check == true);

		return stdlist;
	}

	public ArrayList<String> getShuffleList() {

		ArrayList<String> stdlist = new ArrayList<>();
		ArrayList<String> major = getMajorList();
		ArrayList<String> nonMajor = getNonMajorList();

		long seed = System.nanoTime();
		Collections.shuffle(major, new Random(seed));
		Collections.shuffle(nonMajor, new Random(seed));
		// System.out.println(major);
		// System.out.println(nonMajor);

		for (int i = 0; i < nonMajor.size(); i++) {
			stdlist.add(nonMajor.get(i));

			if (i < nonMajor.size() - 1) {
				stdlist.add(major.get(i));
			}
		}

		return stdlist;
	}

	public ArrayList<String> getMajorList() {

		List<StdDTO> wholeList = wholeData();
		ArrayList<String> majorList = new ArrayList<>();

		for (StdDTO std : wholeList)
			if (!std.getSkill().equals("NULL"))
				majorList.add(std.getName());

		return majorList;
	}

	public ArrayList<String> getNonMajorList() {

		List<StdDTO> wholeList = wholeData();
		ArrayList<String> nonMajorList = new ArrayList<>();

		for (StdDTO std : wholeList)
			if (std.getSkill().equals("NULL"))
				nonMajorList.add(std.getName());

		return nonMajorList;
	}

	public List<StdDTO> selectAll() {
		return wholeData();
	}

	private List<StdDTO> wholeData() {
		List<StdDTO> stdlist = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("student.csv"));) {
			String line;
			br.readLine(); // 컬럼 제목 부분 버리기
			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				// CSV 파일이므로, ","로 구분하여 각 라인을 배열에 저장한다.
				// 3,박성철,바이오식품,Python/정보보안
				String[] data = line.split(",");
				StdDTO std = new StdDTO();
				std.setStudent_id(Integer.parseInt(data[0]));
				std.setName(data[1]);
				std.setMajor(data[2]);
				std.setSkill(data[3]);

				// 각 학생의 정보를 리스트에 추가
				stdlist.add(std);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return stdlist;

	}// wholeData()
}
