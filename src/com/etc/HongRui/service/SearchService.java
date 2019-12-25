
package com.etc.HongRui.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.HongRui.dao.SearchDao;
import com.etc.HongRui.entiry.Course;
import com.etc.HongRui.util.Log;

/**
 * @author LS
 *
 * SearchService.java

 */

@Service("service")
@Transactional(readOnly=true)
public class SearchService {
	@Autowired
	public SearchDao dao;
	public List<Course> getsearch(String string) throws SQLException, ClassNotFoundException {
		List<Course> list=dao.getsearch(string);
		return list;
	}
}
