package com.ly.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ly.ssm.service.AddorSearchService;
import com.ly.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;

@Controller
public class UserController {



    @RequestMapping("login")
    @ResponseBody
    public boolean login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        if(userService.login(username,password)){
            session.setAttribute("user",username);
            System.out.println("success");
            return true;
        }
        else { System.out.println("wrongPass"); return false;}

    }

    @RequestMapping("register")
    @ResponseBody
    public boolean register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String adress = request.getParameter("adr");
        System.out.println(username+password+adress);
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        if(userService.Register(adress,username,password)){
            System.out.println("success");
            return true;
        }
        else { System.out.println("wrongRegister"); return false;}

    }


    @RequestMapping("online")
    @ResponseBody
    public String online(HttpServletRequest request,HttpServletResponse response){
        String username = request.getSession().getAttribute("user").toString();
        if(username!=null){
            return username;
        }
        else return "未登录";
    }

    @RequestMapping("logout")
    @ResponseBody
    public boolean logout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");
        return true;

    }

    @RequestMapping("add")
    @ResponseBody
    public boolean add(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String ID = request.getParameter("ID");
        String vio = request.getParameter("vio");
        BigInteger lowpoint =  new BigInteger(request.getParameter("lowpoint"));
        String admin = request.getSession().getAttribute("user").toString();
        AddorSearchService addorSearchService = new AddorSearchService();
        if(addorSearchService.addMsg(username,ID,vio,lowpoint,admin)!=null){
            System.out.println("addSucess!");
            return true;
        }
        else return false;

    }

    @RequestMapping("search")
    @ResponseBody
    public JSONArray search(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String name = request.getParameter("name");
        String ID = request.getParameter("ID");
        System.out.println(name+ID);
        AddorSearchService addorSearchService = new AddorSearchService();
        int total = new Integer(String.valueOf(addorSearchService.returnTotal()));
        System.out.println(total);
        JSONArray js = new JSONArray();
        for(int i=0;i<total;i++){
            String username = addorSearchService.getuserName(BigInteger.valueOf(i));
            String userID = addorSearchService.getID(BigInteger.valueOf(i));
            if(username.equals(name)) {
                JSONObject json = new JSONObject();
                json.put("vio", addorSearchService.getviolateRecord(BigInteger.valueOf(i)));
                json.put("lowpoint", addorSearchService.getlowPoint(BigInteger.valueOf(i)));
                json.put("admin", addorSearchService.getAdministrator(BigInteger.valueOf(i)));
                json.put("ID",addorSearchService.getID(BigInteger.valueOf(i)));
                js.add(json);
                System.out.println(json.toJSONString());
            }

        }
        return js;
    }

}