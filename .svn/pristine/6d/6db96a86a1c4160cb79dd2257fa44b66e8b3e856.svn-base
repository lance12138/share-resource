package com.jxust.base;
import java.util.List;

/**
 * 提供公共方法的接口
 * 
 * @author Eddie
 * 
 * @param <T>
 *            泛型
 */

public interface BaseDao<T> {

	/**
	 * 保存实体
	 * 
	 * @param t
	 */
	public void save(T t);

	/**
	 * 更新实体
	 * 
	 * @param t
	 */
	public void update(T t);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	public void delect(Long id);

	/**
	 * 查询实体
	 * 
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(Long[] ids);

	/**
	 * 查询实体
	 * 
	 * @param id
	 * @return
	 */
	public T getById(Long id);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<T> findAll();

	public int getSize();
	public int getSize(Long id);
	public void batchDelete();
	public void batchDelete(Long id);
	public int getCountByHQL(String hql);

	public List<T> getListForPage(String hql, int startIndex, int pageSize);

	public String getQueryHQL(T t);
	  
}
