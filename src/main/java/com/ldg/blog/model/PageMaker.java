package com.ldg.blog.model;

public class PageMaker {
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	//페이징넘버 
	private int displayPageNum = 10;
	
	private Criteria criteria;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//페이징계산 메소드
		calcData();
	}
	
	private void calcData() {
		//					소수점이하 올림		23
		endPage = (int)(Math.ceil(criteria.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = (endPage-displayPageNum)+1;
		int totalEndPage = (int)(Math.ceil(totalCount)/(double)criteria.getPerPageNum());
		
		if(endPage>totalEndPage) endPage=totalEndPage;
		
		prev = startPage == 1 ? false:true;
		
		next = endPage == totalEndPage ? false:true; 
//		next = endPage*criteria.getPerPageNum()>=totalCount ? false:true; 
	}
	

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}


	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	
}