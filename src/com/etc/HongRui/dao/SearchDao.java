/**
 * 
 */
package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.etc.HongRui.entiry.Course;
import com.etc.HongRui.mybatis.SearchMapper;

/**
 * @author LS
 *
 * SearchDao.java 
 * 根据页面传递的字符查询课程
 */

@Repository("dao")
public class SearchDao  {
	@Autowired
	public SearchMapper searchMapper;
	public List<Course> getsearch(String string) throws ClassNotFoundException, SQLException {
		List<Course> list = searchMapper.search(string) ;
		return list;
	}
}
