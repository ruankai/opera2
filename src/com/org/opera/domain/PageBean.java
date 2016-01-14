package com.org.opera.domain;

import java.util.List;

public class PageBean {
	//指定的或页面参数
	private String keyword;//请求的关键词
	private int currentPage;//当前页数
	private int pageSize;//当前页显示的行数
	//查询数据库
	private int rowNumber=0;//总记录数
	private List recordList;//本页的数据列表
	//计算得出
	private int totalPage=1;//总页数
	private int beginPageIndex; //页码列表开始的索引(包含)
	private int endPageIndex;//页码列表结束的索引(包含)
	/**
	 * 只接受前4个必要的属性，会自动的计算出其他3个属生的值
	 * @param currentPage
	 * @param pageSize
	 * @param rowNumber
	 * @param recordList
	 */
	public PageBean(int currentPage,int pageSize,int rowNumber,List recordList){
		this.currentPage=currentPage;
		this.pageSize=pageSize;
		this.rowNumber=rowNumber;
		this.recordList=recordList;
		//计算总页数
		totalPage=(rowNumber+pageSize-1)/pageSize;
		// 计算 beginPageIndex 和 endPageIndex
				// >> 总页数不多于10页，则全部显示
		if (totalPage < 10) {
			beginPageIndex = 1;
			endPageIndex = totalPage;
		}
		// // >> 总页数多于10页，则显示当前页附近的共10个页码
		else {// 当前页附近的共10个页码（前4个 + 当前页 + 后5个）
			beginPageIndex = currentPage - 4;
			endPageIndex = currentPage + 5;
			if (beginPageIndex < 1) {// 当前面的页码不足4个时，则显示前10个页码
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			if (endPageIndex > totalPage) {// 当后面的页码不足5个时，则显示后10个页码
				endPageIndex=totalPage;
				beginPageIndex=totalPage-10+1;
			}
		}
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getBeginPageIndex() {
		return beginPageIndex;
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	
}
