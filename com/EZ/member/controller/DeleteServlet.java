package com.EZ.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.EZ.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/member/remove.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	회원탈퇴 > 쿼리문 > delete from member_Tbl where member_id = '로그인 ID';
		String memberId = request.getParameter("memberId");
		MemberService mService = new MemberService();
		int result = mService.deletemember(memberId);
		if (result > 0) {
			// 로그아웃 후 메인 이동
//		1. 세션 가져온후
//		2. 세션 파괴 후 
//		3. 메인으로 이동
//		HttpSession session = request.getSession();
//		if(session!=null)session.invalidate();
//		response.sendRedirect("/index.jsp");
//	원래는 이렇게 적으나 이 세줄이 로그아웃의 구문과 똑같다. 고로 로그아웃의 Servlet 을 작성하면 된다
			response.sendRedirect("/member/logout.do");
		} else {
//		에러페이지 이동
			request.setAttribute("msg","회원탈퇴가 정상적으로 완료 되지 않았습니다");
			RequestDispatcher view
			= request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp");
			view.forward(request, response);
		}
	}
}
