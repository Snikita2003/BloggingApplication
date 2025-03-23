package com.blog.payloads;

import java.util.List;

public class PostResponse {

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalEle() {
		return totalEle;
	}

	public void setTotalEle(long l) {
		this.totalEle = l;
	}

	public int getTotalpages() {
		return totalpages;
	}

	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}

	public boolean isLastpage() {
		return lastpage;
	}

	public void setLastpage(boolean lastpage) {
		this.lastpage = lastpage;
	}

	public void setContent(List<PostDto> content) {
		this.content = content;
	}

	private List<PostDto> content;
	private int pageNo;
	private int pageSize;
	private Long totalEle;
	private int totalpages;
	private boolean lastpage;

	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostResponse(List<PostDto> content, int pageNo, int pageSize, Long totalEle, int totalpages,
			boolean lastpage) {
		super();
		this.content = content;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalEle = totalEle;
		this.totalpages = totalpages;
		this.lastpage = lastpage;
	}

	public List<PostDto> getContent() {
		return content;
	}

}
