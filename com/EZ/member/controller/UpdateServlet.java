package com.EZ.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EZ.member.model.service.MemberService;
import com.EZ.member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/member/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		update member_tbl set member_email = ? , member_phone = ? ,member_adress = ?, member_hobby=?where member_id=?
	try {
//		한글 안깨지게 하기
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		String memberId = request.getParameter("memberId");

		Member member = new Member();
		member.setEmail(email);
		member.setPhone(phone);
		member.setAddress(address);
		member.setHobby(hobby);
		member.setMemberId(memberId);
		MemberService mService = new MemberService();
		int result = mService.updateMember(member);
		if(result>0) {
			response.sendRedirect("/member/mypage.do?memberId="+memberId);
		}else {
			request.setAttribute("msg","정보 수정이 되지 않았습니다");
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		}
	}catch(Exception e) {
		request.setAttribute("msg", e.getMessage());
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp");
		view.forward(request, response);
	}
	
	}

}
