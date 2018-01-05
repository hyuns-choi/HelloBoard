package com.oraclejava.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class BbsDao {
	public List<Bbs> selectBbs(){
		
		List<Bbs> list = null;
		
		String sql = "select * from bbs";
		try(Connection connection = DBUtil.getDataSource().getConnection();
				//Statement st = connection.createStatement();				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				){
			
//			pstmt.setString(1, id);
//			pstmt.setString(2, passwd);
			ResultSet rs = pstmt.executeQuery();
			
			list = new ArrayList<Bbs>();
			
			Bbs bbs = null;
			while(rs.next()) {
				bbs = new Bbs();
				bbs.setBbsno(rs.getInt("BBSNO"));
				bbs.setTitle(rs.getString("TITLE"));
				bbs.setUploader(rs.getString("UPLOADER"));
				bbs.setContent(rs.getString("CONTENT"));
				bbs.setReadcount(rs.getInt("READCOUNT"));
				bbs.setRegdate(rs.getDate("REGDATE"));
				
				list.add(bbs);				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insertBbs(Bbs bbs) {
		String sql = "insert into bbs(BBSNO, TITLE, UPLOADER, CONTENT) " + 
				"values (bbs_seq.nextval,?,?,?)";
	
		try(Connection connection = DBUtil.getDataSource().getConnection();
				//Statement st = connection.createStatement();				
				PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {
						"bbsno"
				});){
			
			//pstmt.setInt(1, bbs.getBbsno());
			pstmt.setString(1, bbs.getTitle());
			pstmt.setString(2, bbs.getUploader());
			pstmt.setString(3, bbs.getContent());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(null != rs && rs.next()) {
				Long pk = rs.getLong(1);
				bbs.setBbsno(pk.intValue());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void insertBbsFile(BbsFile file) {
		String sql = "insert into BBSFILE(BBSFILENO, SAVEDFILENAME, USERFILENAME, bbsno) " + 
				"values (bbsfile_seq.nextval,?,?,?)";
	
		try(Connection connection = DBUtil.getDataSource().getConnection();
				//Statement st = connection.createStatement();				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				){
			
			pstmt.setString(1, file.getSavedFileName());
			pstmt.setString(2, file.getUserFileName());
			pstmt.setInt(3, file.getBbsNo());
					
			pstmt.executeUpdate();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Bbs selectBbsByBbsNo(int no) {
		
		Bbs bbs = null;
		
		String sql = "select * from bbs where BBSNO=?";
		try(Connection connection = DBUtil.getDataSource().getConnection();
				//Statement st = connection.createStatement();				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				){
			
			pstmt.setInt(1, no);
//			pstmt.setString(2, passwd);
			ResultSet rs = pstmt.executeQuery();
						
			
			if(rs.next()) {
				bbs = new Bbs();
				bbs.setBbsno(rs.getInt("BBSNO"));
				bbs.setTitle(rs.getString("TITLE"));
				bbs.setUploader(rs.getString("UPLOADER"));
				bbs.setContent(rs.getString("CONTENT"));
				bbs.setReadcount(rs.getInt("READCOUNT"));
				bbs.setRegdate(rs.getDate("REGDATE"));
					
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return bbs;
	}

	public List<BbsFile> selectBbsFilesByBbsNo(int bbsNo){
		
		List<BbsFile> list = null;
		
		String sql = "select * from bbsFile where BBSNO=?";
		try(Connection connection = DBUtil.getDataSource().getConnection();
				//Statement st = connection.createStatement();				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				){
			
			pstmt.setInt(1, bbsNo);
//			pstmt.setString(2, passwd);
			ResultSet rs = pstmt.executeQuery();
			
			list = new ArrayList<BbsFile>();
			
			BbsFile bbsFile = null;
			if(rs.next()) {
				bbsFile = new BbsFile();
				bbsFile.setBbsFileNo(rs.getInt("BBSFILENO"));
				bbsFile.setSavedFileName(rs.getString("SAVEDFILENAME"));
				bbsFile.setUserFileName(rs.getString("USERFILENAME"));
				bbsFile.setDownLoadCount(rs.getInt("DOWNLOADCOUNT"));
				bbsFile.setBbsNo(rs.getInt("BBSNO"));
				
				list.add(bbsFile);				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public BbsFile selectBbsFilesByFileNo(int no) {
		BbsFile bbsFile = null;
		
		String sql = "select * from BBSFILE where BBSFILENO=?";
		try(Connection connection = DBUtil.getDataSource().getConnection();
				//Statement st = connection.createStatement();				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				){
			
			pstmt.setInt(1, no);
//			pstmt.setString(2, passwd);
			ResultSet rs = pstmt.executeQuery();
						
			
			if(rs.next()) {
				bbsFile = new BbsFile();
				bbsFile.setBbsFileNo(rs.getInt("BBSFILENO"));
				bbsFile.setSavedFileName(rs.getString("SAVEDFILENAME"));
				bbsFile.setUserFileName(rs.getString("USERFILENAME"));
				bbsFile.setDownLoadCount(rs.getInt("DOWNLOADCOUNT"));
				bbsFile.setBbsNo(rs.getInt("BBSNO"));;
					
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return bbsFile;
	}
}
