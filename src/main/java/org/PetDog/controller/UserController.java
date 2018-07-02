package org.PetDog.controller;

import org.PetDog.entity.Login;
import org.PetDog.entity.User;
import org.PetDog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @RequestMapping("/login")
    public void login(@RequestParam("loginname") String loginname,
                      @RequestParam("password") String password,
                      @RequestParam("role") Integer role,
                      HttpSession session,
                      HttpServletResponse response)throws Exception{
        Login login=userService.findUserByLoginnameAndPassword(loginname,password);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        if(login!=null){
            //把当前用户和所属角色存入session中
            session.setAttribute("user",login);
            session.setAttribute("role",role);
            out.println(1);
        }else{
            out.println(0);
        }
        out.flush();
        out.close();
    }
    @RequestMapping("/register")
    public void register(@RequestParam("loginname") String loginname,
                         @RequestParam("password") String password,
                         HttpServletResponse response)throws Exception{
        Login login=new Login();
        login.setPassword(password);
        login.setLoginname(loginname);

        userService.addLogin(login);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(1);
        out.flush();
        out.close();
    }
    @RequestMapping("/selectInfo")
    public String selectInfo(HttpSession session,
                           Model model){
        Login login=(Login)session.getAttribute("user");
        String loginname=login.getLoginname();

        User user=null;
        if(userService.findUserByLoginname(loginname)==null){

        }else{
            user=userService.findUserByLoginname(loginname);
        }
        model.addAttribute("user",user);
        return "userInfo";
    }
    @RequestMapping("/getUserImage")
    public void getUserImage(@RequestParam("id") Integer id,
                             HttpServletResponse response){
        User user=userService.findUserById(id);
        byte[] photo=user.getPhoto();
        try{
            ServletOutputStream os=response.getOutputStream();
            if(photo!=null&&photo.length>0){
                for(int i=0;i<photo.length;i++){
                    os.write(photo[i]);
                }
            }
        }catch(Exception e){
            throw new RuntimeException("加载图片错误！",e);
        }
    }


    @RequestMapping("/addOrUpdateInfo")
    public ModelAndView addOrUpdateInfo(@RequestParam("pictureFile") MultipartFile pictureFile,
                                        @RequestParam("id") Integer id,
                                        @ModelAttribute User user,
                                        ModelAndView mv) {
            if (pictureFile != null) {
                try {
                    byte[] buffer = pictureFile.getBytes();
                    user.setPhoto(buffer);
                } catch (Exception e) {
                    throw new RuntimeException("照片上传错误！", e);
                }
            }
            /*userService.findUserById(user.getId())==null*/
            if(id==null){     //该用户信息不存在
                userService.addUser(user);
            }else{      //该用户信息已存在
                User user1=userService.findUserById(user.getId());
                user1.setLoginname(user.getLoginname());
                user1.setName(user.getName());
                user1.setSex(user.getSex());
                user1.setBirthday(user.getBirthday());
                user1.setWeChat(user.getWeChat());
                user1.setTel(user.getTel());
                user1.setEmail(user.getEmail());
                user1.setPhoto(user.getPhoto());
                userService.updateUser(user1);
            }
            mv.setViewName("redirect:selectInfo");
            return mv;
    }
    @RequestMapping("/uploadPhoto")
    public void uploadPhoto(HttpServletResponse response,
                            @RequestParam("photo") MultipartFile photo,
                            @RequestParam("id") Integer id)throws Exception{
        //System.out.println(id+"0000000000000");
        //System.out.println(photo.isEmpty());
        User user=userService.findUserById(id);
        if(photo!=null){
            try {
                byte[] p = photo.getBytes();
                user.setPhoto(p);
            } catch (Exception e) {
                throw new RuntimeException("照片上传错误！", e);
            }
        }
        userService.updateUser(user);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(1);
        out.flush();
        out.close();
    }
    @RequestMapping("/showChangePwd")
    private ModelAndView showChangePwd(HttpSession session,
                                   ModelAndView mv){
        Login login=(Login)session.getAttribute("user");
        String loginname=login.getLoginname();
        mv.addObject("Loginname",loginname);
        mv.setViewName("showChangePwd");
        return mv;
    }
    @RequestMapping("/changePwd")
    public void changePwd(@RequestParam("prePwd") String prePwd,
                          @RequestParam("nowPwd1") String nowPwd1,
                          @RequestParam("nowPwd2") String nowPwd2,
                          HttpSession session,
                          HttpServletResponse response)throws Exception{
        Login login=(Login)session.getAttribute("user");
        if(login.getPassword().equals(prePwd)&&nowPwd1.equals(nowPwd2)){
            login.setPassword(nowPwd1);
            userService.updatePwd(login);

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println(1);
            out.flush();
            out.close();
        }
    }

    @RequestMapping("/deleteUser")
    public  void  deleteUser(HttpSession session,
                             HttpServletResponse response)throws Exception{
        session.removeAttribute("user");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(1);
        out.flush();
        out.close();
    }
}
