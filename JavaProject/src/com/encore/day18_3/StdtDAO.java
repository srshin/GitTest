package com.encore.day18_3;

/*    pair list  짝 리스트
0  1  2				3  4  5
6  7  8  9			10 11 12
13 14 15 16			17 18
19 20				21 22  
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StdtDAO {

	public ArrayList<String> repeatCheckList() {
		// 기존 list
		String[] oldlist = {
		"백하연", "임왕기", "이남기", "위정욱", "정인창", "김휘중","방서경", "정윤도", "박소영" , "윤창민" ,"허정표", "배지수", 
		"박정은",  "문상수",  "이광호", "현진우", "정인아" , "박성철", "박세환" ,  "신상림", "오승진" , "이아라", "이진주"} ;
		//짝이 되는 쌍 배열 
		int[][] pair= { {0,1}, {1,2},      			{3,4}, {4,5}, 
						{6,7}, {7,8}, {8,9}, 		{10,11}, {11,12},
						{13,14}, {14,15},{15,16}, 	{17,18},
						{19,20},					{21,22}      };  
		boolean found = false;
		ArrayList<String> newArrayList = null;

		// 파일에서 데이타 읽어오기  
		List<StdtDTO> wholeList = wholeData(); 
		//읽은 데이타중 전공으로 저장  
		ArrayList<String> major = getMajorList(wholeList);
		//읽은 데이타를 비전공으로 저장 
		ArrayList<String> nonMajor = getNonMajorList(wholeList);

		
		
		// 중복 발견되는 동안 반복 (while found is TRUE)
		do {
			found = false; //중복미발견 reset  
			
			// 셔플하여 새롭게 list구성한 뒤 string 배열로 변환(비교 목적)  
			newArrayList = getShuffleList(major, nonMajor);
			String[] newList = newArrayList.toArray(new String[newArrayList.size()]);
			System.out.println("[  새로 셔플한 리스트    ]");
			System.out.println(Arrays.toString(newList));
			
			//비교 시작  old pair와  new pair를 구성하여  n*n 번 비교 수행
			for (int[] s : pair) {
				String[] newPair = { newList[s[0]], newList[s[1]] };
				Arrays.sort(newPair); // 정확한 비교를 위한 정렬
				//System.out.println();
				//System.out.println(i+ " " + Arrays.toString(compare));
				for (int[] k: pair) {
					String[] oldPair = { oldlist[k[0]], oldlist[k[1]] };
					Arrays.sort(oldPair);
					if (Arrays.equals(oldPair, newPair)) {
						System.out.print("중복 pair발견  : 비교 중지  " + Arrays.toString(newPair));
						found = true;
						break;// 중복 발견되면 비교 중지하고 탈출 
					}
				} // inner for
				if(found) break; // 중복이 발견되었으므로 나머지 쌍에 대하여 더이상 비교할 필요 없음. shuffle 다시!  
			} // outer for
		} while (found == true);
		return newArrayList;
	}

	public ArrayList<String> getShuffleList(ArrayList<String> major, ArrayList<String> nonMajor) {

		ArrayList<String> stdlist = new ArrayList<>();

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

	public ArrayList<String> getMajorList(List<StdtDTO> wholeList) {

		ArrayList<String> majorList = new ArrayList<>();

		for (StdtDTO std : wholeList)
			if (!std.getSkill().equals("NULL"))
				majorList.add(std.getName());

		return majorList;
	}

	public ArrayList<String> getNonMajorList(List<StdtDTO> wholeList) {

		ArrayList<String> nonMajorList = new ArrayList<>();

		for (StdtDTO std : wholeList) {
			if (std.getSkill().equals("NULL"))
				nonMajorList.add(std.getName());
		}
		return nonMajorList;
	}

	private List<StdtDTO> wholeData() {
		List<StdtDTO> stdlist = new ArrayList<>();
		

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
				StdtDTO std = new StdtDTO();
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
