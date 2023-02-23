package com.web.servlet;
import com.alibaba.fastjson.JSON;
import com.service.impl.xiewenImpl;
import com.service.xiewenService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
@WebServlet("/xiewen/*")
public class xiewen extends servlet{
    private xiewenService xiewenServices= new xiewenImpl();
    public void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用service查询
        List<com.pojo.xiewen> xiewens = xiewenServices.selectall();
        //2. 转为JSON
        String jsonString = JSON.toJSONString(xiewens);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    public  void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        //转为Brand对象
        com.pojo.xiewen xiewen = JSON.parseObject(params, com.pojo.xiewen.class);
        //2. 调用service添加
         xiewenServices.add(xiewen);
        //3. 响应成功的标识*/
        response.getWriter().write("success");
    }
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
       BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        xiewenServices.deleteById(params);
        //3. 响应成功的标识
        response.getWriter().write("success");
    }
    public  void updateById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为 int
        com.pojo.xiewen xiewen = JSON.parseObject(params, com.pojo.xiewen.class);


        //2. 调用service添加
        xiewenServices.updateById(xiewen);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }
    public void tiaocha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        com.pojo.xiewen xiewen1 = JSON.parseObject(params, com.pojo.xiewen.class);
        List<com.pojo.xiewen> tiaocha = xiewenServices.tiaocha(xiewen1);
        String s = JSON.toJSONString(tiaocha);
        System.out.println(s);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }
}
