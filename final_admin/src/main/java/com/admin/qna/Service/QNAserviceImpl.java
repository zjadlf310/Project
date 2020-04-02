package com.admin.qna.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.client.page.PageClass;
import com.admin.qna.DAOVO.QNADAO;
import com.admin.qna.DAOVO.QNAVO;

@Service("QNAservice")
public class QNAserviceImpl implements QNAservice {

	@Autowired
	QNADAO qdao;
	@Override
	public int QNADelete(QNAVO bvo) {
		
		return qdao.QNADelete(bvo);
	}

	@Override
	public QNAVO QNASerchDataOne(int num) {

		return qdao.QNASerchDataOne(num);
	}

	@Override
	public int QNATotalCount() {
		
		return qdao.QNATotalCount();
	}

	@Override
	public int QNATotalCount(PageClass pc) {
		
		return qdao.QNATotalCount(pc);
	}

	@Override
	public ArrayList<QNAVO> QNAOnePageInfo(PageClass pc) {
		
		return qdao.QNAOnePageInfo(pc);
	}

}
