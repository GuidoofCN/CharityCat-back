package cn.cat.pojo;

import java.util.Date;

public class CatPojo {
	private String catid;
	private String catname;
	private Integer gender;
	private String pic;
	private Integer sickness;
	private Integer disabled;
	private Date birthday;
	private Double weight;
	private Double len;
	private String varity;
	private String userid;
	private String username;
	private String adoptid;
	private String adoptname;
	private CatNotePojo note;

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getSickness() {
		return sickness;
	}

	public void setSickness(Integer sickness) {
		this.sickness = sickness;
	}

	public Integer getDisabled() {
		return disabled;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getLen() {
		return len;
	}

	public void setLen(Double len) {
		this.len = len;
	}

	public String getVarity() {
		return varity;
	}

	public void setVarity(String varity) {
		this.varity = varity;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdoptid() {
		return adoptid;
	}

	public void setAdoptid(String adoptid) {
		this.adoptid = adoptid;
	}

	public String getAdoptname() {
		return adoptname;
	}

	public void setAdoptname(String adoptname) {
		this.adoptname = adoptname;
	}

	public CatNotePojo getNote() {
		return note;
	}

	public void setNote(CatNotePojo note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "CatPojo [catid=" + catid + ", catname=" + catname + ", gender=" + gender + ", pic=" + pic
				+ ", sickness=" + sickness + ", disabled=" + disabled + ", birthday=" + birthday + ", weight=" + weight
				+ ", len=" + len + ", varity=" + varity + ", userid=" + userid + ", username=" + username + ", adoptid="
				+ adoptid + ", adoptname=" + adoptname + ", note=" + note + "]";
	}

}
