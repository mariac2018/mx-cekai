package course.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

//@WebServlet(name="basicServlet")
public class BasicServlet extends HttpServlet {
    private static final Logger LOGGER= LoggerFactory.getLogger(BasicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI=req.getRequestURI();
        Map<String,String> parameterMap=handleParamMap(req.getParameterMap());
        LOGGER.info("basic servlet start for url={},param={}",requestURI,parameterMap);
        if(requestURI.equals("/examples/ping123")){
            resp.setStatus(200);
            ServletOutputStream outputStream=resp.getOutputStream();
            outputStream.write("hahhahhah".getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }

    private Map<String,String> handleParamMap(Map<String,String[]> parameterMap){
        return parameterMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,param->param.getValue()[0]));

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
}
