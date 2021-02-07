package org.crazy.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GlobalFilter extends ZuulFilter {


    /*
    filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
    pre：路由之前  可以做安全验证等
    routing：路由之时
    post： 路由之后
    error：发送错误调用
     */
    public String filterType() {
        return "pre";
    }

    //filterOrder：过滤的顺序
    public int filterOrder() {
        return 0;
    }

    // shouldFilter：这里可以写逻辑判断，是否要过滤
    public boolean shouldFilter() {
        return true;
    }

    //run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if(token == null){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            HttpServletResponse response = context.getResponse();
            try{
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                response.getWriter().print("需要传入token");
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
