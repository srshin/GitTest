package com.encore.day18_6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class StdtDAO {

	public List<StdtDTO> selectAll()  {
		return collect();
	}


	private List<StdtDTO> collect() {
		List<StdtDTO> stdlist = new ArrayList<>();

		try  {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 로딩 성공 ");
				Connection conn=null;
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
				System.out.println("DB연결 성공");
				String sql="select * from studentlist";
				Statement st;
				st = conn.createStatement();
				ResultSet rs;
				rs = st.executeQuery(sql);
				while (rs.next()) {
					StdtDTO std = new StdtDTO();
					std.setName(rs.getString("name"));
					std.setMajor(rs.getString("major"));
					std.setSkill(rs.getString("skill"));
	
					// 각 학생의 정보를 리스트에 추가
					stdlist.add(std);
				}
				conn.close();
			
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		return stdlist;
	}
	//새로운 좌석 리스트 구하기 
	public ArrayList<String> makeNewSeatList(ArrayList<String> oldArrayList, List<StdtDTO> dtoList) {

		boolean found = false;
		ArrayList<String> newArrayList = null;

		// 기존 좌석으로 쌍으로 된 set 생성 
		Set<Pair> oldPairSet = makePair(oldArrayList);

		//전공과 비전공으로 저장  
		ArrayList<String> majorList = getMajorList(dtoList);
		ArrayList<String> nonMajorList = getNonMajorList(dtoList);
		
		do {
			found = false; //중복미발견 reset  
			
			// 전공리스트와 비전공리스트로 list구성  
			newArrayList = getShuffleList(majorList, nonMajorList);

			//새로 구성된 list를 가지고 pair로 된 set을 생성 
			Set<Pair> newPairSet = makePair(newArrayList);
			
			//새로 구성된 pair set이 기존 pair set과 중복되는 지 검사 
			for (Pair p : newPairSet) {
				System.out.println(p.toString());
				if (oldPairSet.contains(p)) {
					System.out.println();
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
			if (std.getSkill() != null )
				majorList.add(std.getName());

		return majorList;
	}

	private ArrayList<String> getNonMajorList(List<StdtDTO> dtoList) {

		ArrayList<String> nonMajorList = new ArrayList<>();

		for (StdtDTO std : dtoList) {
			if (std.getSkill() == null)
				nonMajorList.add(std.getName());
		}
		return nonMajorList;
	}
	
	private Set<Pair> makePair (ArrayList<String> list) {
		
		int[][] pair= { {0,1}, {1,2},      		{3,4}, {4,5}, 
					{6,7}, {7,8}, {8,9}, 		{10,11}, {11,12},
					{13,14}, {14,15},{15,16}, 	{17,18},
					{19,20},					{21,22}      };  
		Set<Pair> pairSet = new HashSet<>(); // 순서 변경 중복안됨
		for 	(int[] s : pair) {
			String[] newPair = { list.get(s[0]), list.get(s[1]) };
			//System.out.println(Arrays.toString(newPair));
			//Arrays.sort(newPair); // 정확한 비교를 위한 정렬
			//System.out.println(Arrays.toString(newPair));
			pairSet.add(new Pair(newPair));
			System.out.print(Arrays.toString(newPair));
		}			
		System.out.println();
		return pairSet ;
	}	
}