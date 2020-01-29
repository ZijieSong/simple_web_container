package container;

/**
 * 
 * function: 自定义容器Servlet父类
 */
public abstract class MyServlet {
 
	public void service(MyServletRequest request, MyServletResponse response) {
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			doGet(request, response);
		} else {
			doPost(request, response);
		}
	}
	
	public abstract void doGet(MyServletRequest request, MyServletResponse response);
	
	public abstract void doPost(MyServletRequest request, MyServletResponse response);
	
}