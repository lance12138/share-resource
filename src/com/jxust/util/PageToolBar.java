package com.jxust.util;


/**
 * @author wx
 */
public class PageToolBar {

	public int resultsetCount; // 总记录数

	public int pageSize; // 页面记录数

	public int pageIndex = 1; // ��ǰҳ

	public int pageCount; // 页面数

	public int startRow; // 开始记录

	public int endRow; // 结束记录

	public int previousPage; // 上一页

	public int nextPage; // 下一页
	public int beginPageIndex;//开始索引
	public int getBeginPageIndex() {
		Begin_EndPageIndex();
		//beginPageIndex=PageToolBar.this.beginPageIndex;
		return beginPageIndex;
	}

	public void Begin_EndPageIndex(){
		pageCount=getPageCount();
		if(pageCount<=4){
			beginPageIndex=1;
			endPageIndex=pageCount;
		}else{
			beginPageIndex=getPageIndex()-1;
			endPageIndex=getPageIndex()+2;
			if(beginPageIndex<1){
				beginPageIndex=1;
				endPageIndex=4;
			}
			if(endPageIndex>pageCount){
				endPageIndex=pageCount;
				beginPageIndex=pageCount-3;
			}
		}
		
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		//endPageIndex=PageToolBar.this.endPageIndex;
		Begin_EndPageIndex();
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	public int endPageIndex;//结束索引

	public PageToolBar() {

	}

	public PageToolBar(int resultsetCount, int pageSize) {
		this.resultsetCount = resultsetCount;
		this.pageSize = pageSize;
	}

	public PageToolBar(int pageIndex, int resultsetCount, int pageSize) {
		this.pageIndex = pageIndex;
		this.resultsetCount = resultsetCount;
		this.pageSize = pageSize;
	
	}

	public int getResultsetCount() {
		return resultsetCount;
	}

	public void setResultsetCount(int resultsetCount) {
		if (resultsetCount > 0)
			this.resultsetCount = resultsetCount;
	}

	// ���㵱ǰҳ
	public int getPageIndex() {
		if (this.pageIndex == 0) {
			this.pageIndex = 1;
		} else if (this.pageIndex > getPageCount()) {
			this.pageIndex = getPageCount();
		}
		return pageIndex;
	}

	public void setPageIndex(int pageindex) {
		this.pageIndex = pageindex;
	}

	// ��� ��¼���� �� ÿҳ��¼�� ��� ��ҳ��
	public int getPageCount() {
		pageCount = resultsetCount / pageSize;
		if (resultsetCount % pageSize > 0) {
			pageCount = pageCount + 1;
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	// ÿҳ��¼��
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// ��ѯ��ʼ��
	public int getStartRow() {
		startRow = (getPageIndex() - 1) * pageSize;
		if (startRow < 0) {
			startRow = 0;
		}
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	// ��ѯ������
	public int getEndRow() {
		// endRow = getPageIndex() * pageSize; //MSsql oracle
		endRow = pageSize; // mysql(limit)
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	// ��һҳ
	public int getPreviousPage() {
		if (getPageIndex() > 1) {
			previousPage = getPageIndex() - 1;
		}
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	// ��һҳ
	public int getNextPage() {
		if (getPageIndex() < getPageCount()) {
			nextPage = getPageIndex() + 1;
		}
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
}