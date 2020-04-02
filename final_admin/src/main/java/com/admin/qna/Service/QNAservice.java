package com.admin.qna.Service;

import java.util.ArrayList;

import com.admin.qna.DAOVO.QNAVO;
import com.admin.client.page.PageClass;

public interface QNAservice {
	
	public int QNADelete(QNAVO bvo);
	
	public QNAVO QNASerchDataOne(int num);
	
	public int QNATotalCount();
	
	public int QNATotalCount(PageClass pc);
	
	public ArrayList<QNAVO> QNAOnePageInfo(PageClass pc);
	
}
