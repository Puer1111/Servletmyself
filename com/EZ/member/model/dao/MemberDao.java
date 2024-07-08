package com.EZ.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.EZ.member.model.vo.Member;

public class MemberDao {

	public int insertMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member_tbl values(?,?,?,?,?,?,?,?,?,default)";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		pstmt.setString(3, member.getGender());
		pstmt.setString(4, member.getMemberName());
		pstmt.setInt(5, member.getAge());
		pstmt.setString(6, member.getEmail());
		pstmt.setString(7, member.getPhone());
		pstmt.setString(8, member.getAddress());
		pstmt.setString(9, member.getHobby());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	public Member checkLogin(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		Member mOne = null;
		ResultSet rset = null;
		String query = "select * from member_tbl where member_id = ? and member_pw = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		rset = pstmt.executeQuery();
		if (rset.next()) {
			mOne = new Member();
			mOne.setMemberId(rset.getString("member_Id"));
			mOne.setMemberName(rset.getString("member_name"));
		}
		pstmt.close();
		rset.close();
		return mOne;
	}

	public int deletemember(Connection conn, String memberId) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member_tbl where member_id = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		result = pstmt.executeUpdate();
		pstmt.close();

		return result;
	}

	public Member selectOneById(Connection conn, String memberId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member result = null;
		String query = "select * from member_tbl where member_Id = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		rset = pstmt.executeQuery();
		if (rset.next()) {
			result = new Member();
			result.setMemberId(rset.getString("member_Id"));
			result.setMemberName(rset.getString("member_name"));
			result.setGender(rset.getString("GENDER"));
			result.setAge(rset.getInt("age"));
			result.setEmail(rset.getString("member_email"));
			result.setPhone(rset.getString("member_address"));
			result.setHobby(rset.getString("member_hobby"));
			result.setRegdate(rset.getDate("reg_date"));
		}
		pstmt.close();
		rset.close();
		return result;
	}

	public int updateMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member_tbl set member_email = ? , member_phone = ? ,member_address = ?, member_hobby =? where member_id=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getEmail());
		pstmt.setString(2, member.getPhone());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getHobby());
		pstmt.setString(5, member.getMemberId());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

}
