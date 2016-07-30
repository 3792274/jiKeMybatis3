package jike.book.pojo;

import java.util.List;

public class JikeUser {
    private Integer id;

    private String username;

    private String password;
    
    
    
    //后添加的，演示集合查询
    private List<Visit> visitList;

    
    public JikeUser(){}
    
    
    //为的是适用构造函数映射结果集，Author -> AuthorMapper.xml
    public JikeUser(String username,String password){
    	this.username = username;
    	this.password  =  password;
    }
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


	public List<Visit> getVisitList() {
		return visitList;
	}


	public void setVisitList(List<Visit> visitList) {
		this.visitList = visitList;
	}
    
    
}