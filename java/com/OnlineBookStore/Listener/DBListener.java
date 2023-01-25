package com.OnlineBookStore.Listener;

import java.io.Console;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.OnlineBookStore.Util.Constant;

public class DBListener implements  ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sceContextEvent) {

		ServletContext context= sceContextEvent.getServletContext();

		String isHome =context.getInitParameter("isHome");
		boolean isHomeBoolean = Boolean.valueOf(isHome);
		Constant.loadTables(isHomeBoolean);
	}
	@Override
	public void contextDestroyed(ServletContextEvent sceContextEvent) {

	}

}
