package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
    //1가지 메서드만 execute하는 메서드를 구현해라., 즉 다른 command들이 BCommand 인터페이스를 Overriding해서 메서드를 구현한다. 
    void execute(HttpServletRequest request, HttpServletResponse reponse);
}
