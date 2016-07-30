package jike.book.map;

import org.apache.ibatis.annotations.Delete;

/**
 * 使用以前版本的注释，有此映射器接口，将不需要xml映射器
 * 尽量不使用，在复杂的映射中有局限性。
 */
public interface JikeUserMapperInterface {
	
	//删除一个对象
	@Delete("delete from jikeuser where id=#{id}")
	public int deleteUser(Integer id);
}
