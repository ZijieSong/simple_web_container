package netty;

public class SecondServlet extends WuzzServlet {
    @Override
    public void doGet(WuzzRequest request, WuzzResponse response) throws Exception {
        this.doPost(request, response);
    }
    @Override
    public void doPost(WuzzRequest request, WuzzResponse response) throws Exception {
        response.write("This is Second Serlvet");
    }
}