package jike.book.pojo;

/**
 * Reader表，根据money，动态SQL查询
 * 
 * @author Mr.TianShu
 */
public class JiKeReader {
	
	private Integer readerID;
	private JikeUser jikeUser;
	private Integer money;

	public Integer getReaderID() {
		return readerID;
	}
	
	public void setReaderID(Integer readerID) {
		this.readerID = readerID;
	}

	public JikeUser getJikeUser() {
		return jikeUser;
	}

	public void setJikeUser(JikeUser jikeUser) {
		this.jikeUser = jikeUser;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}
