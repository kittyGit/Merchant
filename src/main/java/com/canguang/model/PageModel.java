package com.canguang.model;

public class PageModel {

	private int pageCount; // 共多少页
	private int currentPage; // 当前是第几页
	private int totalRowCount; // 总共行数
	private int pageSize;// 每页多少行

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		if (pageCount < 0)
			pageCount = 0;
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage < 0)
			currentPage = 0;
		this.currentPage = currentPage;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
