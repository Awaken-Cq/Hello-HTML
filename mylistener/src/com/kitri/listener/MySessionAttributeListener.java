package com.kitri.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {
	private int loginCount = 0;
    public MySessionAttributeListener() {
  
    }
    
    public void attributeAdded(HttpSessionBindingEvent e)  { 
    	String attrName = e.getName();
    	
    	if(attrName.equals("loginInfo")) {
    		loginCount++;
    		System.out.println(e.getValue() + "님이 로그인하셨습니다.");
    		System.out.println("로그인된 사용자 수 : " + loginCount + "명");
    	}
    }

    public void attributeRemoved(HttpSessionBindingEvent e)  { 
    	String attrName = e.getName();
    	if(attrName.equals("loginInfo")) {
    		loginCount--;
    		System.out.println(e.getValue() + "님이 로그아웃하셨습니다.");
    		System.out.println("로그인된 사용자 수 : " + loginCount + "명");
    	}
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 

    }
	
}
