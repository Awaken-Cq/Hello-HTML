package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/* cnt의 길이를 추출하여 8자리까지 부족한만큼 0이 나오는 String 생성
 * charAt(cnt, 1)등으로 각 숫자를 하나씩 추출.
 * 추출한 숫자를 int화 X
 * 추출한 이미지에 맞게 for문 8번 돌리며 i가 img의 이름이 되도록 설정.]
 * 방문자가
 */

@WebServlet("/Counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int cnt;
	int max;
	
	public void init() {
		cnt = 0;
		max = 8;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			String cntTotal = "";
			cnt++;
			String cntStr = String.valueOf(cnt);
			int len = cntStr.length();
			int zeroCnt = max-len;
			for(int i = 0; i< zeroCnt;i++) {
				cntTotal += "0";
			}
			
			cntTotal += cntStr;
			
			System.out.println(cntTotal.length());
			
			out.println("<html>");
			out.println("	<body>");
			out.println("		당신은 ");
			for(int i = 0; i<8;i++) {
				out.print("		<img src=\"/basicservlet/img/"+ cntTotal.charAt(i) + ".png\" width=\"50\">");				
				System.out.println(i);
			}
			
			out.println("	</body>");
			out.println("</html>");
			
	}


}
