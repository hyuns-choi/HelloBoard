package com.oraclejava.model;

public class MemberService {
	
	public void insertMember(Member member) 
			throws AlreadyEntryExcption{
		MemberDao dao = new MemberDao();
		if(dao.isEntriedId(member.getMemberid())) {
			throw new AlreadyEntryExcption();
		}
		dao.insertMember(member);
	}	
}
