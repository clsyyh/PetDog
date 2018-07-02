package org.PetDog.controller;

import org.PetDog.entity.Address;
import org.PetDog.entity.Dog;
import org.PetDog.entity.Login;
import org.PetDog.entity.User;
import org.PetDog.service.AddressService;
import org.PetDog.service.DogService;
import org.PetDog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    @Qualifier("addressService")
    private AddressService addressService;
    @Autowired
    @Qualifier("dogService")
    private DogService dogService;
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/showOrder")
    public String showOrder(@RequestParam("dogId") Integer dogId,
                            HttpServletResponse response,
                            Model model,
                            HttpSession session)throws Exception{
        //先编辑个人信息，才可以显示订单
        Login login=(Login)session.getAttribute("user");
        User user=userService.findUserByLoginname(login.getLoginname());
        String userName=user.getName();
        int userId=user.getId();

        Address address=addressService.findByBuyerId(userId);

        Dog dog=dogService.findDogById(dogId);
        model.addAttribute("dog",dog);
        model.addAttribute("userName",userName);
        model.addAttribute("address",address);
        return "order";
        /*
        int flag=0;
        if(address==null){
            flag=0;
         }else{
            flag=1;
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(flag);
        out.flush();
        out.close();
        */
    }
    @RequestMapping("/addAddress")
    public void addAddress(@ModelAttribute Address address,
                           HttpServletResponse response,
                           HttpSession session)throws Exception{
        //先编辑个人信息，才可以添加地址
        Login login=(Login)session.getAttribute("user");
        User user=userService.findUserByLoginname(login.getLoginname());
        int userId=user.getId();

        address.setBuyerId(userId);
        addressService.addAddress(address);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(1);
        out.flush();
        out.close();
    }
}
