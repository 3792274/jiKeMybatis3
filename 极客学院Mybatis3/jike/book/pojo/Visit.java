package jike.book.pojo;

import java.util.Date;

/**
 * 演示集合查询多增加的一个visit表，表示访问者
 * 
 * @author Mr.TianShu
 *
 */
public class Visit {
	private Integer visitID;
	private JikeUser jikeUser;
	private Date visitDate;
	private String visitIP;

	public Integer getVisitID() {
		return visitID;
	}

	public void setVisitID(Integer visitID) {
		this.visitID = visitID;
	}

	public JikeUser getJikeUser() {
		return jikeUser;
	}

	public void setJikeUser(JikeUser jikeUser) {
		this.jikeUser = jikeUser;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getVisitIP() {
		return visitIP;
	}

	public void setVisitIP(String visitIP) {
		this.visitIP = visitIP;
	}

}
