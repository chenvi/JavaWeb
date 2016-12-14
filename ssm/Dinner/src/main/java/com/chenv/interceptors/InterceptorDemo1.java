package com.chenv.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.cglib.transform.impl.AddDelegateTransformer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class InterceptorDemo1 implements HandlerInterceptor {

	private List<String> excludedUrls;
	
	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	        
			HttpSession session = request.getSession();
	        if (session.getAttribute("userName") == null) {
	        	request.setAttribute("msg", "请登录后操作！！");
	        	request.getRequestDispatcher("/login.jsp").forward(request, response);
//	            response.sendRedirect(request.getContextPath() + "/login.jsp");
	            return false;
	        }else {
				return true;
			}
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//System.out.println("do preHandle...");

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println("do afterCompletion...");

	}

}
interface IDictionary{
	public void add(String word);
	public List<String> findSimilary(String word);
}