package com.encore.day18_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class StdtDAO {
	String[] oldList = {
			"백하연", "임왕기", "이남기", "위정욱", "정인창", "김휘중","방서경", "정윤도", "박소영" , "윤창민" ,"허정표", "배지수", 
			"박정은",  "문상수",  "이광호", "현진우", "정인아" , "박성철", "박세환" ,  "신상림", "오승진" , "이아라", "이진주"} ;


	public List<StdtDTO> selectAll()  {
		return collect();
	}
	//기존 좌석 리스트 
	public  ArrayList<String>  readSeatList() {
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(oldList));
		return arrayList;
	}

	//새로운 좌석 리스트 구하기 
	public ArrayList<String> makeNewSeatList(List<StdtDTO> dtoList) {

		boolean found = false;
		ArrayList<String> newArrayList = null;

		// 기존 좌석으로 쌍으로 된 set 생성 
		Set<Pair> oldPairSet = makePair(oldList);

		//전공과 비전공으로 저장  
		ArrayList<String> majorList = getMajorList(dtoList);
		ArrayList<String> nonMajorList = getNonMajorList(dtoList);
		
		do {
			found = false; //중복미발견 reset  
			
			// 전공리스트와 비전공리스트로 list구성  
			newArrayList = getShuffleList(majorList, nonMajorList);
			String[] newList = newArrayList.toArray(new String[newArrayList.size()]); // string 배열로 변환(비교 목적)

			//새로 구성된 list를 가지고 pair로 된 set을 생성 
			Set<Pair> newPairSet = makePair(newList);
			
			//새로 구성된 pair set이 기존 pair set과 중복되는 지 검사 
			for (Pair p : newPairSet) {
				if (oldPairSet.contains(p)) {
					System.out.println("중복 pair발견  : 비교 중지  "+ p);
					found = true;
					break;// 중복 발견되면 비교 중지하고 탈출 
				}
			} 
		} while (found == true);		// 중복 발견되었다면 다시 수행 (while found is TRUE)
		return newArrayList;
	}

	private ArrayList<String> getShuffleList(ArrayList<String> major, ArrayList<String> nonMajor) {

		ArrayList<String> list = new ArrayList<>();

		long seed = System.nanoTime();
		Collections.shuffle(major, new Random(seed));
		Collections.shuffle(nonMajor, new Random(seed));

		//major와 nonMajor를 교대로 list에 추가 
		Iterator<String> itMajor = major.iterator();
		Iterator<String> itNon = nonMajor.iterator();
		for (int i=0 ; i <major.size()+nonMajor.size(); i++) {
			if (itNon.hasNext()) list.add(itNon.next());
			if (itMajor.hasNext()) list.add(itMajor.next());
		}
		return list;
	}

	private ArrayList<String> getMajorList(List<StdtDTO> dtoList) {

		ArrayList<String> majorList = new ArrayList<>();

		for (StdtDTO std : dtoList)
			if (!std.getSkill().equals("NULL"))
				majorList.add(std.getName());

		return majorList;
	}

	private ArrayList<String> getNonMajorList(List<StdtDTO> dtoList) {

		ArrayList<String> nonMajorList = new ArrayList<>();

		for (StdtDTO std : dtoList) {
			if (std.getSkill().equals("NULL"))
				nonMajorList.add(std.getName());
		}
		return nonMajorList;
	}

	private List<StdtDTO> collect() {
		List<StdtDTO> stdlist = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("student.csv"));) {
			String line;
			br.readLine(); // 컬럼 제목 부분 버리기
			while (true) {
				line = br.readLine();
				if (line == null)	break;
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
	}
	
	private Set<Pair> makePair (String[] list) {
		
		int[][] pair= { {0,1}, {1,2},      		{3,4}, {4,5}, 
					{6,7}, {7,8}, {8,9}, 		{10,11}, {11,12},
					{13,14}, {14,15},{15,16}, 	{17,18},
					{19,20},					{21,22}      };  
		Set<Pair> pairSet = new HashSet<>(); // 순서 변경 중복안됨
		for 	(int[] s : pair) {
			HashSet<String> newPair = new HashSet<>();
			newPair.add( list[s[0]]);
			newPair.add( list[s[1]]);
			pairSet.add(new Pair(newPair));
			System.out.print(newPair.toString());
		}			
		System.out.println();
		return pairSet ;
	}	
}