package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.Video;
/**
 * @author LS
 *
 * SearchDao.java 根据课程ID查询课程下的视频id，视频名字，list显示视频名字
 */
public class PlayDao extends BaseDao {

	public List<Video> getvideo(String idString) throws ClassNotFoundException, SQLException {
		getConnect();
		String sqlString="select videoID,VideoName,path from video where CID = ?";
		ps=connection.prepareStatement(sqlString);
		ps.setString(1, idString);
		rsResultSet=ps.executeQuery();
		List<Video> list=new ArrayList<Video>();
		while(rsResultSet.next()) {
			Video video=new Video();
			video.setVideoID(rsResultSet.getString("videoID"));
			video.setVideoName(rsResultSet.getString("VideoName"));
			video.setPath(rsResultSet.getString("path"));
			list.add(video);
		}
		return list;
	}

}
