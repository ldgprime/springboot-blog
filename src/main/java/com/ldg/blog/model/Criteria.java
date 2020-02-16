package com.ldg.blog.model;


//검색까지 하기위해 
public class Criteria {
	
	private int page;
	private int perPageNum;
	private String type;
	private String keyword;	
	private int pagelimit;
	
	
	
	public int getPagelimit() {
		return pagelimit;
	}

	public void setPagelimit(int pagelimit) {
		this.pagelimit = pagelimit;
	}

	public String getType() {
		return type;
	}

	public String[] getTypeArr() {
												//스트링 배열 T, W, C
		return type == null ? new String[] {} : type.split("");
	}	

	public void setType(String type) {
		this.type = type;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public Criteria() {
		//첫번째 페이지 
		this.page = 1;
		//레코드 10개 씩 => 한페이지 당 10개의 글 10개의 행 10개의 row
		this.perPageNum = 10;
	}
	
	
	public Criteria(int page, int perPageNum) {
		//첫번째 페이지 
		this.page = page;
		//레코드 10개 씩 => 한페이지 당 10개의 글 10개의 행 10개의 row
		this.perPageNum = perPageNum;
	}
	
	public void setPage(int page) {
		if(page<=0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0 || perPageNum>100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getPageStart() {
		//				1-1	*	10 = 0
		//				2-1 *   10 = 10
		//				8-1 *   10 = 70
		return (this.page-1)*perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", type=" + type + ", keyword=" + keyword
				+ "]";
	}	
	
}