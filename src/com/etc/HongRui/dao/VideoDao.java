package com.etc.HongRui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HongRui.entiry.Video;

public class VideoDao extends BaseDao {
	public List<Video> getVideo(int page , int row) throws SQLException, ClassNotFoundException {
		getConnect();
		String sql = "select * from video";		
		ps = connection.prepareStatement(sql);
		rsResultSet = ps.executeQuery();
		List<Video> list = new ArrayList<Video>();
		while (rsResultSet.next()) {
			Video Video = new Video();
			Video.setCID(rsResultSet.getString("CID"));
			Video.setPath(rsResultSet.getString("path"));
			Video.setVideoID(rsResultSet.getString("VideoID"));
			Video.setVideoName(rsResultSet.getString("VideoName"));
			Video.setVLength(rsResultSet.getString("VLength"));
			list.add(Video);
		}
		return list;
	}
	public List<Video> getlist() throws SQLException, ClassNotFoundException{
		getConnect();
		String sql = "SELECT * FROM video  ";
		ps = connection.prepareStatement(sql);
		rsResultSet = ps.executeQuery();
		List<Video> list = new ArrayList<Video>();
		while(rsResultSet.next()) {
			Video Video = new Video();
			Video.setVideoID(rsResultSet.getString("VideoID"));
			Video.setCID(rsResultSet.getString("CID"));
			Video.setVLength(rsResultSet.getString("VLength"));
			Video.setPath(rsResultSet.getString("Path"));
			Video.setVideoName(rsResultSet.getString("VideoName"));
			list.add(Video);
		}
		return list;
	}
	
	
	public List<Video> getlist1(String vid) throws ClassNotFoundException, SQLException {
		getConnect();
		String sql = "SELECT * FROM video WHERE videoID = ? ";
		ps = connection.prepareStatement(sql);
		ps.setString(1, vid);
		rsResultSet = ps.executeQuery();
		List<Video> list = new ArrayList<Video>();
		while(rsResultSet.next()) {
			Video Video = new Video();
			Video.setVideoID(rsResultSet.getString("videoID"));
			Video.setCID(rsResultSet.getString("CID"));
			Video.setVLength(rsResultSet.getString("VLength"));
			Video.setPath(rsResultSet.getString("path"));
			Video.setVideoName(rsResultSet.getString("videoName"));
			list.add(Video);
		}
		return list;
	}


	public List<Video> getlist2(String vname) throws ClassNotFoundException, SQLException {
		getConnect();
		String sql = "SELECT * FROM video WHERE videoName = ?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, vname);
		rsResultSet = ps.executeQuery();
		List<Video> list = new ArrayList<Video>();
		while(rsResultSet.next()) {
			Video Video = new Video();
			Video.setVideoID(rsResultSet.getString("videoID"));
			Video.setCID(rsResultSet.getString("CID"));
			Video.setVLength(rsResultSet.getString("VLength"));
			Video.setPath(rsResultSet.getString("path"));
			Video.setVideoName(rsResultSet.getString("videoName"));
			list.add(Video);
		}
		return list;
	}


	public List<Video> getlist3(String vid , String vname) throws ClassNotFoundException, SQLException {
		getConnect();
		String sql = "SELECT * FROM video WHERE videoID = ? AND videoName = ? ";
		ps = connection.prepareStatement(sql);
		ps.setString(1, vid);
		ps.setString(2, vname);
		rsResultSet = ps.executeQuery();
		List<Video> list = new ArrayList<Video>();
		while(rsResultSet.next()) {
			Video Video = new Video();
			Video.setVideoID(rsResultSet.getString("videoID"));
			Video.setCID(rsResultSet.getString("CID"));
			Video.setVLength(rsResultSet.getString("VLength"));
			Video.setPath(rsResultSet.getString("path"));
			Video.setVideoName(rsResultSet.getString("videoName"));
			list.add(Video);
		}
		return list;
	}
	

	public int dele(String  Vid) throws SQLException, ClassNotFoundException {
		getConnect();
		String sql = "delete from video where videoID = ?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, Vid);
		int count = ps.executeUpdate();
		return count;
	}

	public int delechoice(String str) throws SQLException {
			String sql = "delete from video where videoID = ?";
			String[] strings = str.split(",");
			int count = 0;
			for (int i = 0; i < strings.length; i++) {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(strings[i]));
				ps.executeUpdate();
				count++;
			}
			return count;
	}


	public Video ShowVideoDetail(String vvid) throws ClassNotFoundException, SQLException {
		getConnect();
		String sql = "SELECT * FROM video WHERE videoID = ? ";
		ps = connection.prepareStatement(sql);
		ps.setString(1, vvid);
		rsResultSet = ps.executeQuery();
		Video Video = new Video();
		while(rsResultSet.next()) {
			Video.setVideoID(rsResultSet.getString("videoID"));
			Video.setCID(rsResultSet.getString("CID"));
			Video.setVLength(rsResultSet.getString("VLength"));
			Video.setPath(rsResultSet.getString("path"));
			Video.setVideoName(rsResultSet.getString("videoName"));
		}
		return Video;
	}
}
