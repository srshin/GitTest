package model;

import java.sql.Date;

public class BoardVO {
	private int bno;
	private String title;
	private String contents;
	private String writer;
	private Date regdate;
	private int count;
	public BoardVO() {}
	public BoardVO(int bno, String title, String contents, String writer, Date regdate, int count) {
		super();
		this.bno = bno;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.regdate = regdate;
		this.count = count;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return String.format("%10d%20s%40s%10s%20s%10s", bno,  title, contents, writer, regdate, count);
		
	}
	
	
	
}
