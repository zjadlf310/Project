package com.admin.client.page;

public class PageClass {
	private int OPContents = 15;//�� ȭ�鿡 �� ���� ��
	private int OPPages = 10;//�� ȭ�鿡 �� ������ ��


	private int startContent;
	private int endContent;

	private int Cpage;//���� ������


	private int Tpage;//�� ������
	private int Tcontents;//�� ���� ��

	private int startPage;//���� ������
	private int endPage;// �� ������


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
		startPage = ((Cpage - 1) / 10) * 10 + 1;//���� �������� �̿��� ����/�� ������ �����
		endPage = startPage + OPPages - 1;
		if (endPage > Tpage) 
		{
			endPage = Tpage;// �������� ����
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
		if(tcontents % OPContents > 0)//�� ������ �� ���
		{
			Tpage++;
		}
		
		if(this.Cpage<=0)//��������/�ּ� ������ �Ѿ ��� ���� ������ ����,�� �۾��� ����/�� ������ ����� ���� ������ �������
		{
			this.Cpage=1;
		}else if(this.Cpage>Tpage) {
			this.Cpage=Tpage;
		}
		
		startPage = ((Cpage - 1) / 10) * 10 + 1;//���� �������� �̿��� ����/�� ������ �����
		endPage = startPage + OPPages - 1;

		if (endPage > Tpage) {//�� �������� �� ���������� ���� ��� �� ������ ����
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
