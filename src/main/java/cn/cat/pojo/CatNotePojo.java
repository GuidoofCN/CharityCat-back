package cn.cat.pojo;

import java.util.Date;

public class CatNotePojo {
	private String catid;
	private Date posttime;
	private String title;
	private String content;
	public String getCatid() {
		return catid;
	}
	//**************
	public void setCatid(String catid) {
		this.catid = catid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CatNotePojo [ catid=" + catid + ", posttime=" + posttime + ", title=" + title
				+ ", content=" + content + "]";
	}
	
}
