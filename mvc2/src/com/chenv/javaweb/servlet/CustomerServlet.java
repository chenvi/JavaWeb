package com.chenv.javaweb.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import com.chenv.javaweb.dao.CustomerDAO;
import com.chenv.javaweb.dao.factory.CustomerDAOFactory;
import com.chenv.javaweb.dao.impl.CustomerDAOJdbcImpl;
import com.chenv.javaweb.dao.impl.CustomerDAOXMLImpl;
import com.chenv.javaweb.domain.CriteriaCustomer;
import com.chenv.javaweb.domain.Customer;


@WebServlet("/customerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDAO customerDAO = CustomerDAOFactory.getInstace().getCustomerDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	//采用switch来使用多个请求对应servlet
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String method = request.getParameter("method");
//		
//		switch (method) {
//		case "add": add(request,response); break;	
//		case "query": query(request,response); break;
//		case "delete": delete(request,response); break;
//
//		}
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String servletPath = req.getServletPath();
		String methodName = servletPath.substring(1, servletPath.length()-3);
		
		
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1.获取要更新的id
		String id = request.getParameter("id");
		
		//2.调用DAO获得customer对象
		 
		try {
			Customer customer = customerDAO.get(Integer.parseInt(id));
			if(customer != null){
		//3.将customer放入request中
				request.setAttribute("customer", customer);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		//4、响页面
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1.获取表单参数：id，name，address ， phone 和 要修改的name
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String oldName = request.getParameter("oldName");
		//2.检查name是不是被占用了
		//2.1 如果相同 说明name可用
		if(!oldName.equalsIgnoreCase(name)){
			long count = customerDAO.getCountWithName(name);
			if(count > 0){
				//2.2 若不同  利用customerDAO 查询getCountWithName 是否存在
				request.setAttribute("message", "用户名"+name+"被占用了！，请重新输入！");
				//2.3 若返回值大于0 就
				request.getRequestDispatcher("update.jsp").forward(request, response);
				return;
			}
		}
		
		
		
		//3.将customer放入request中
		Customer customer = new Customer(name, address, phone);
		customer.setId(Integer.parseInt(id));
		
		//4.调用update执行更新
		customerDAO.update(customer);
		//4、响页面
		response.sendRedirect("query.do");;
	}
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		try {
			customerDAO.delete(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("query.do");
//		request.getRequestDispatcher("query.do").forward(request, response);
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		
//		List<Customer> customers = customerDAO.getALL();
		
		request.setAttribute("customers", customers);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		if(customerDAO.getCountWithName(name)>0){
			request.setAttribute("message", "与"+name+"重名了！！！");
		
			//通过value="<%= request.getParameter("name")%>"回显
			request.getRequestDispatcher("newCustomer.jsp").forward(request, response);
			return;
		}
		
		Customer customer = new Customer(name, address, phone);
			
		customerDAO.save(customer);
		//重定向避免了表单的重新提交	
		response.sendRedirect("success.jsp");
	}

}
