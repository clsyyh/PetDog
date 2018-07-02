package org.PetDog.controller;

import com.alibaba.fastjson.JSON;
import org.PetDog.entity.Dog;
import org.PetDog.entity.DogOrder;
import org.PetDog.entity.Login;
import org.PetDog.entity.User;
import org.PetDog.service.DogService;
import org.PetDog.service.OrderService;
import org.PetDog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;
    @Autowired
    @Qualifier("dogService")
    private DogService dogService;
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/addOrder")
    public void addOrder(@RequestParam("deliverWay") Integer deliverWay,
                         @RequestParam("payWay") Integer payWay,
                         @RequestParam("sumPrice") Integer sumPrice,
                         @RequestParam("dogId") Integer dogId,
                         @RequestParam("shr") String shr,
                         @RequestParam("tel") String tel,
                         @RequestParam("shad") String shad,
                         HttpServletResponse response,
                         HttpSession session)throws Exception{
        String delWay="";
        int delPrice=0;
        if(deliverWay==1){
            delWay="自提";
            delPrice=0;
        }if(deliverWay==2){
            delWay="省内配送";
            delPrice=500;
        }if(deliverWay==3){
            delWay="省外配送";
            delPrice=1000;
        }
        String pWay="";
        if(payWay==1){
            pWay="微信支付";
        }else {
            pWay="支付宝支付";
        }
        /*
        创建当前时间并转换成字符串格式
         */
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String number=sdf.format(date);
        /*根据dogId查询出卖家，订单中保存的是sellerId,
          但是订单中可以直接保存dogId
         */
        Dog dog=dogService.findDogById(dogId);
        int sellerId=dog.getSeller().getId();

        //先编辑个人信息,才可以添加订单
        Login login=(Login)session.getAttribute("user");
        User user=userService.findUserByLoginname(login.getLoginname());
        int buyerId=user.getId();

        DogOrder order=new DogOrder();
        order.setNumber(number);
        order.setPayWay(pWay);
        order.setDeliverWay(delWay);
        order.setDeliverPrice(delPrice);
        order.setSumprice(sumPrice);
        order.setTel(tel);
        order.setShad(shad);
        order.setShr(shr);
        order.setDog(dog);
        order.setBuyerId(buyerId);
        order.setSellerId(sellerId);

        int count=orderService.addOrder(order);
        System.out.println(count+"_____________");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(count);
        out.flush();
        out.close();
        /*
        if(count==1){
            return "main";
        }else{
            return "order";
        }
        */
    }
    //查询所有订单
    @RequestMapping("/selectAllOrders")
    public void selectAllOrders(HttpSession session,
                                HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        int role=(Integer)session.getAttribute("role");
        if(role==0){//买家登录
            //先编辑个人信息，才可以查询出所有订单
            Login login=(Login)session.getAttribute("user");
            User buyer=userService.findUserByLoginname(login.getLoginname());
            int buyerId=buyer.getId();

            List<DogOrder> orders=orderService.findOrdersByBuyerId(buyerId);

            String responseStr= JSON.toJSONString(orders);

            out.println(responseStr);

        }else{//卖家登录
            Login login=(Login)session.getAttribute("user");
            User seller=userService.findUserByLoginname(login.getLoginname());
            int sellerId=seller.getId();

            List<DogOrder> orders=orderService.findOrdersBySellerId(sellerId);
            String responseStr= JSON.toJSONString(orders);
            out.println(responseStr);
        }
        out.flush();
        out.close();
    }
    //Status=1已处理订单
    @RequestMapping("selectHandled")
    public void selectHandled(HttpServletResponse response,
                              HttpSession session)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        int role=(Integer)session.getAttribute("role");
        if(role==0){//买家登录
            Login login=(Login)session.getAttribute("user");
            User user=userService.findUserByLoginname(login.getLoginname());
            int buyerId=user.getId();

            List<DogOrder> orders=orderService.findOrderByBuyerIdAndStatus(buyerId,1);
            for(DogOrder order:orders){
                System.out.println(order.getShad());
            }
            String responseStr= JSON.toJSONString(orders);
            out.println(responseStr);

        }else{//卖家登录
            Login login=(Login)session.getAttribute("user");
            User user=userService.findUserByLoginname(login.getLoginname());
            int sellerId=user.getId();

            List<DogOrder> orders=orderService.findOrderBySellerIdAndStatus(sellerId,1);
            for(DogOrder order:orders){
                System.out.println(order.getShad());
            }
            String responseStr= JSON.toJSONString(orders);
            out.println(responseStr);
        }

    }
    //Status=0未处理订单
    @RequestMapping("/selectNothandle")
    public void selectNotHandle(HttpSession session,
                                HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        int role=(Integer)session.getAttribute("role");
        if(role==0){//买家登录
            Login login=(Login)session.getAttribute("user");
            User user=userService.findUserByLoginname(login.getLoginname());
            int buyerId=user.getId();

            List<DogOrder> orders=orderService.findOrderByBuyerIdAndStatus(buyerId,0);
            String responseStr= JSON.toJSONString(orders);
            out.println(responseStr);

        }else{//卖家登录
            Login login=(Login)session.getAttribute("user");
            User user=userService.findUserByLoginname(login.getLoginname());
            int sellerId=user.getId();

            List<DogOrder> orders=orderService.findOrderBySellerIdAndStatus(sellerId,0);
            String responseStr= JSON.toJSONString(orders);
            out.println(responseStr);
        }


    }

    @RequestMapping("/changeOrderStatus")
    public String changeOrderStatus(@RequestParam("id") Integer id,
                                          ModelAndView mv){
        orderService.updateStatusById(id);
        //因为不是Ajax请求，所以处理完订单后会输出未处理订单的json串
        //mv.setViewName("redirect:selectNothandle");
        // return mv;
        return "showNothandle";
    }
 }

