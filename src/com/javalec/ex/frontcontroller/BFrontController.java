package com.javalec.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.command.BCommand;
import com.javalec.ex.command.BContentCommand;
import com.javalec.ex.command.BDeleteCommand;
import com.javalec.ex.command.BListCommand;
import com.javalec.ex.command.BModifyCommand;
import com.javalec.ex.command.BReplyCommand;
import com.javalec.ex.command.BReplyViewCommand;
import com.javalec.ex.command.BWriteCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do") // 확장자 맵핑을 URL로하고 있음. //확장자가 DO이면 무조건 BfronController로 오게 되어 있다. 
public class BFrontController extends HttpServlet { //BfrontController가 HttpServlet을 상속받고 있음. servlet임을 확인가능
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response); //doget이던 dopost던 값을 actionDO로 처리함.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("doPost");
		actionDo(request, response);
	}
	
	//actionDo에서 모든 로직을 수행하고, if문을 통해서 분기를 해 나아가면서 viewPage에 값을 전달함. 마지막으로 viewPage를 포워딩함. 
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("actionDo");
	    
	    
	    request.setCharacterEncoding("EUC-KR");
	    
	    String viewPage = null; //FrontController가 나중에 요청을 받은 후 어떤 View를 보여줄건지그 역할을 하는 것 
	    BCommand command = null; //Command 역할을 수행할 객체를 선언. 어떤 로직을 수행할지. 값이 바뀔 수 있으니 null값
	    
	    String uri = request.getRequestURI(); //1)요청request로 부터 URI를 get함. frontController 객체 사용시와 같은 방식.
	    String conPath = request.getContextPath(); //2) getContextPath수행 
	    String com = uri.substring(conPath.length()); // 3) 먼저 get한 uri에서 substring을 한다음 conPath의 length만큼 잘라서 com에 저장. 밑에 있는 조건문을 실행하기 위한 작업.
	    
	    //해당하는 요청에 따라 해당하는 command객체를 생성하고 처리한후, viewPage에 저장하여 화면단 처리
	    if (com.equals("/write_view.do")) { //글작성 화면을 볼 수 있음. 즉, 확장자 패턴이 write_view.do이면 이 조건문을 실행하여 글작성 화면을 command를 처리함.
	        viewPage = "write_view.jsp";
	    }
	    
	    /*
	     * 'write.do' 요청이 들어오면 해당
	     * command를 생성하여 적절한 로직을 실행 후 'list.do'페이지로 포워딩함.
	     */
	    else if (com.equals("/write.do")) { //작성하는 화면을 요청하면
	        command = new BWriteCommand(); 
	        command.execute(request, response);
	        viewPage = "list.do"; // viewPage에 list.do를 주면, list를 작성하면 화면이 보여짐.
	    }
	    else if (com.equals("/list.do")) {
	        command = new BListCommand();
	        command.execute(request, response);
	        viewPage = "list.jsp";
	    }
        else if (com.equals("/content_view.do")) {
            command = new BContentCommand();
            command.execute(request, response);
            viewPage = "content_view.jsp";
        }
        else if (com.equals("/modify.do")) {
            command = new BModifyCommand();
            command.execute(request, response);
            viewPage = "list.do";
        }
        else if (com.equals("/delete.do")) {
            command = new BDeleteCommand();
            command.execute(request, response);
            viewPage = "list.do";
        }
        else if (com.equals("/reply_view.do")) {
            command = new BReplyViewCommand();
            command.execute(request, response);
            viewPage = "reply_view.jsp";
        }
        else if (com.equals("/reply.do")) {
            command = new BReplyCommand();
            command.execute(request, response);
            viewPage = "list.do";
        }	   
	    
	    //viewPage변수를 forwarding 기법으로 RequestDispatcher 객체에 실어서 forwarding 해준다. 
	    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	    dispatcher.forward(request, response);
	}

}
