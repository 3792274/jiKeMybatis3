package jike.book.pojo;

/**
 * 作者POJO
 * @author Mr.TianShu
 *
 */
public class Author {
	
	private Integer id;
	private JikeUser jikeUser;
	private String realname;
	private String IDCard;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public JikeUser getJikeUser() {
		return jikeUser;
	}
	public void setJikeUser(JikeUser jikeUser) {
		this.jikeUser = jikeUser;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	
	
	
	
}
