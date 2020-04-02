package com.admin.client.page;

public class PageClass {
	private int OPContents = 15;//한 화면에 들어갈 내용 수
	private int OPPages = 10;//한 화면에 들어갈 페이지 수


	private int startContent;
	private int endContent;

	private int Cpage;//현재 페이지


	private int Tpage;//총 페이지
	private int Tcontents;//총 내용 수

	private int startPage;//시작 페이지
	private int endPage;// 끝 페이지


	private String searchOption;
	private String keyWord;

	
	
	public PageClass(String searchOption, String keyWord) {
		super();
		this.searchOption = searchOption;
		this.keyWord = keyWord;
	}

	public PageClass(int tcontents) {
		this.Cpage =1;
		this.Tcontents = tcontents;
		this.Tpage = tcontents/OPContents;
		if(tcontents % OPContents > 0)
		{
			Tpage++;
		}
		startPage = ((Cpage - 1) / 10) * 10 + 1;//현재 페이지를 이용한 시작/끝 페이지 만들기
		endPage = startPage + OPPages - 1;
		if (endPage > Tpage) 
		{
			endPage = Tpage;// 끝페이지 조정
		}
		startContent = (Cpage - 1) * OPContents + 1;
		endContent = Cpage * OPContents;
	}
	
	public PageClass(int tcontents,int cpage,String searchOption,String keyWord) {
		this.Cpage =cpage;
		this.Tcontents = tcontents;
		this.Tpage = tcontents/OPContents;
		
		this.searchOption = searchOption;
		this.keyWord = keyWord;
		if(tcontents % OPContents > 0)//총 페이지 수 계산
		{
			Tpage++;
		}
		
		if(this.Cpage<=0)//총페이지/최소 페이지 넘어갈 경우 현재 페이지 보정,이 작업은 시작/끝 페이지 만들기 전에 무조건 해줘야함
		{
			this.Cpage=1;
		}else if(this.Cpage>Tpage) {
			this.Cpage=Tpage;
		}
		
		startPage = ((Cpage - 1) / 10) * 10 + 1;//현재 페이지를 이용한 시작/끝 페이지 만들기
		endPage = startPage + OPPages - 1;

		if (endPage > Tpage) {//끝 페이지가 총 페이지보다 많을 경우 끝 페이지 보정
			endPage = Tpage;
		}
		startContent = (Cpage - 1) * OPContents + 1;
		endContent = Cpage * OPContents; 
		

	}


	public int getStartContent() {
		return startContent;
	}
	public void setStartContent(int startContent) {
		this.startContent = startContent;
	}
	public int getEndContent() {
		return endContent;
	}
	public void setEndContent(int endContent) {
		this.endContent = endContent;
	}
	public int getOPContents() {
		return OPContents;
	}
	public void setOPContents(int oPContents) {
		OPContents = oPContents;
	}
	public int getOPPages() {
		return OPPages;
	}
	public void setOPPages(int oPPages) {
		OPPages = oPPages;
	}
	public int getCpage() {
		return Cpage;
	}
	public void setCpage(int cpage) {
		Cpage = cpage;
	}
	public int getTpage() {
		return Tpage;
	}
	public void setTpage(int tpage) {
		Tpage = tpage;
	}
	public int getTcontents() {
		return Tcontents;
	}
	public void setTcontents(int tcontents) {
		Tcontents = tcontents;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}



}
