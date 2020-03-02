package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;

public class BDeleteCommand implements BCommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse reponse) {
        
        String bId = request.getParameter("bId");
        BDao dao = new BDao();
        dao.delete(bId);
        
    }

}
