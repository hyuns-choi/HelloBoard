package com.oraclejava.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBUtil;

public class MemberDao {
	
	public boolean isEntriedId(String id) {
		String sql = "select memberid from members where memberid=?";
		
		try(Connection connection = DBUtil.getDataSource().getConnection();
				//Statement st = connection.createStatement();				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				){
			
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void insertMember(Member member) {
		String sql = "insert into members(memberid, passwd, email, usertype, active) " + 
					"values (?,?,?,?,?)";
		
		try(Connection connection = DBUtil.getDataSource().getConnection();
				//Statement st = connection.createStatement();				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				){
			
			pstmt.setString(1, member.getMemberid());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getUsertype());
			pstmt.setString(5, member.getActive());
			
			int nRet = pstmt.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public Member selectMemberByIdAndPassword(String id, String passwd) {
		
		Member member = null;
		String sql = "select * from members where memberid=? and passwd=?";
		try(Connection connection = DBUtil.getDataSource().getConnection();
				//Statement st = connection.createStatement();				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				){
			
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberid(rs.getString("MEMBERID"));
				member.setPasswd(rs.getString("PASSWD"));
				member.setEmail(rs.getString("EMAIL"));
				member.setUsertype(rs.getString("USERTYPE"));
				member.setActive(rs.getString("ACTIVE"));
				member.setRegdate(rs.getDate("REGDATE"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return member;
	}
}
