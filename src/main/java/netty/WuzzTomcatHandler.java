package netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

import java.util.Map;

//业务处理handler
public class WuzzTomcatHandler extends ChannelInboundHandlerAdapter {

    private Map<String, WuzzServlet> servletMapping;

    public WuzzTomcatHandler(Map<String, WuzzServlet> servletMap) {
        servletMapping = servletMap;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest req = (HttpRequest) msg;
            // 转交给我们自己的request实现
            WuzzRequest request = new WuzzRequest(ctx, req);
            // 转交给我们自己的response实现
            WuzzResponse response = new WuzzResponse(ctx, req);
            // 实际业务处理
            String url = request.getUrl();

            if (servletMapping.containsKey(url)) {
                servletMapping.get(url).service(request, response);
            } else {
                response.write("404 - Not Found");
            }
        }
    }

    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}