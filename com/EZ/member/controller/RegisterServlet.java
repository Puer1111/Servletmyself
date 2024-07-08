package com.EZ.member.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EZ.member.model.service.MemberService;
import com.EZ.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/member/join.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.sendRedirect("/WEB-INF/views/member/register.jsp); << 이거 안됨 주소그냥 복사해서 엔터친거라
	request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String gender = request.getParameter("gender");
		String memberName = request.getParameter("member-name");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");

//		회원 가입 비즈니스 로직
		Member member= new Member(memberId,memberPw,gender,memberName,Integer.parseInt(age),email,phone,address,hobby);
		
		MemberService mService = new MemberService();
		
		int result = mService.insertMember(member);
		
		if(result > 0 ) {
			response.sendRedirect("/index.jsp");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);

		}
	}

}
