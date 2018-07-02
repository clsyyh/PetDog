package org.PetDog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.PetDog.entity.Dog;
import org.PetDog.entity.Login;
import org.PetDog.entity.User;
import org.PetDog.service.DogService;
import org.PetDog.service.UserService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DogController {
    @Autowired
    @Qualifier("dogService")
    private DogService dogService;
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/{index}")
    public String index(@PathVariable String index){
        return  index;
    }

    @RequestMapping("/selectDogs")
    public void selectDog(HttpServletResponse response,
                          Model model)throws Exception{
        List<Dog> dogs=dogService.findAllDogs();
        model.addAttribute("dogs",dogs);

        String responseStr= JSON.toJSONString(dogs);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(responseStr);
        out.flush();
        out.close();
    }
    @RequestMapping("/selectDetail")
    public String  selectDetail(HttpServletResponse response,
                              Model model,
                              @RequestParam("id") Integer id)throws Exception{
        Dog dog=dogService.findDogById(id);
        model.addAttribute("dog",dog);
        return "moreDetail";

        /*
        response.setContentType("text/html;charset=utf-8");
        String responseStr=JSON.toJSONString(dog);
        PrintWriter out=response.getWriter();
        out.println(responseStr);
        out.flush();
        out.close();
        */
    }
    @RequestMapping("/getImage")
    public void getImage(@RequestParam("id") Integer id,
                         HttpServletResponse response){
        Dog dog=dogService.findDogById(id);
        byte[] picture=dog.getPicture();
        try{
            ServletOutputStream os=response.getOutputStream();
            if(picture!=null&&picture.length!=0){
                for(int i=0;i<picture.length;i++){
                    os.write(picture[i]);
                }
            }
        }catch (Exception e){
            throw new RuntimeException("加载图片错误！",e);
        }
    }
    @RequestMapping("/searchDogs")
    public void searchDogs(@RequestParam("kind") String kind,
                           @RequestParam("area") String area,
                           @RequestParam("price") Integer price,
                           HttpServletResponse response,
                           Model model)throws Exception{
        if(kind.equals("犬种")){
            kind=null;
        }
        if(area.equals("区域")){
            area=null;
        }
        if(price.equals("价格")){
            price=null;
        }

        List<Dog> dogs=dogService.findDogsByKindOrAreaOrPrice(kind,area,price);
        model.addAttribute("dogs",dogs);

        String responseStr=JSON.toJSONString(dogs);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(responseStr);
        out.flush();
        out.close();
    }
    @RequestMapping("/addDog")
    public void addDog(@RequestParam("pictureFile") MultipartFile picture,
                         @ModelAttribute Dog dog,
                         HttpServletResponse response,
                       HttpSession session)throws Exception{
        Login login=(Login)session.getAttribute("user");
        //先编辑个人信息，才可以上传宠物狗信息(seller_id)
        User user=userService.findUserByLoginname(login.getLoginname());
        if(!picture.isEmpty()){
            try{
                byte[] pic=picture.getBytes();
                dog.setPicture(pic);
            }catch (IOException e){
                throw  new RuntimeException("照片上传出现错误！",e);
            }
        }
        dog.setSeller(user);
        dogService.addDog(dog);

        response.setContentType("text/html;chatset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(1);
        out.flush();
        out.close();
    }
    @RequestMapping("/Jsoup")
    public void Jsoup(HttpServletResponse response){
        try{
            Document html= Jsoup.connect("http://www.dog126.com/").timeout(100000).get();

            Elements ul=html.select(".feature-wrap");
            //String string=ul.toString();
            //System.out.println(string+"8****8");

            Elements lis=ul.select("li");
            //String lisString=lis.toString();
            //System.out.println(lisString+"*********8888");
            Element health=lis.get(0);
            Element character=lis.get(1);
            Element age=lis.get(2);
            Element IQ=lis.get(3);

            Elements health_as=health.select("a");
            String health_as_url=health_as.attr("href",health_as.attr("abs:href")).attr("href");
            //System.out.println("健康地址"+health_as_url);

            Elements character_as=character.select("a");
            String character_as_url=character_as.attr("href",character_as.attr("abs:href")).attr("href");
            //System.out.println("性格地址"+character_as_url);

            Elements age_as=age.select("a");
            String age_as_url=age_as.attr("href",age_as.attr("abs:href")).attr("href");
            //System.out.println("年龄地址"+age_as_url);

            Elements IQ_as=IQ.select("a");
            String IQ_as_url=IQ_as.attr("href",IQ_as.attr("abs:href")).attr("href");
           // System.out.println("智商地址"+IQ_as_url);

            List<String> urls=new ArrayList<String>();
            urls.add(health_as_url);
            urls.add(character_as_url);
            urls.add(age_as_url);
            urls.add(IQ_as_url);

            String responseStr=JSON.toJSONString(urls);
            //System.out.println(responseStr);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println(responseStr);
            out.flush();
            out.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping("/Jsoup2")
    public void Jsoup2(HttpServletResponse response){
        try{
            String start_url="https://v.qq.com/x/cover/8ly4s55kfhsiu45/j0025y4bcwh.html";
            String sns_url="https://ncgi.video.qq.com/fcgi-bin/video_comment_id?otype=json&op=3&vid=0000";
            String comment_url="https://video.coral.qq.com/varticle/0000/comment/v2?orinum=10&oriorder=6407813439465959448&orirepnum=2";

            int start=start_url.indexOf("j00");
            int end=start_url.indexOf(".html");
            String vid=start_url.substring(start,end);//左闭右开

            String sns_url1=sns_url.replaceAll("0000",vid);
            /*
            把js解析为html
             */
            Document js=Jsoup.connect(sns_url1).ignoreContentType(true).timeout(10000).get();
            //String jsString=js.toString();
            //System.out.println(jsString);
            Elements body_content=js.select("body");
            //String bodyString=body_content.toString();
            //System.out.println(bodyString);
            String json=body_content.text();
            /*
            json字符串
            QZOutputJson={"comment_id":"2231263598",
            "result":{"code":0,"msg":"Success!","ret":0},
            "srcid":"j0025y4bcwh",
            "srcid_type":1001};
             */
            int sta=json.indexOf("22");
            int en=json.indexOf("8");
            String comment_id=json.substring(sta,en+1);

            String comment_url1=comment_url.replaceAll("0000",comment_id);
            /*
            把js解析为html
             */
            Document js1=Jsoup.connect(comment_url1).ignoreContentType(true).timeout(1000000).get();
            //String js1String=js1.toString();
            //System.out.println(js1String);
            Elements body_content1=js1.select("body");
            String json1=body_content1.text();
            /*
            把json字符串转换为json对象
             */
            JSONObject jsonObject=JSONObject.parseObject(json1);
            System.out.println(jsonObject);

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println(json1);
            out.flush();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping("/Jsoup3")
    public void Jsoup3(HttpServletResponse response){
        try{
            String start_url="https://v.qq.com/x/cover/bzfkv5se8qaqel2/n0020yrnly7.html";
            String sns_url="https://ncgi.video.qq.com/fcgi-bin/video_comment_id?otype=json&op=3&vid=1111";
            String comm_url="https://video.coral.qq.com/varticle/1111/comment/v2?orinum=20&oriorder=t&cursor=6408564224441552254";

            int start=start_url.indexOf("2/");
            int end=start_url.indexOf(".html");
            String vid=start_url.substring(start+2,end);//左闭右开

            String sns_url1=sns_url.replaceAll("1111",vid);

            Document js=Jsoup.connect(sns_url1).ignoreContentType(true).timeout(100000).get();
            Elements body_content=js.select("body");
            String json=body_content.text();
            int str=json.indexOf("comment_id");
            int en=json.indexOf("result");
            String comment_id=json.substring(str+13,en-3);

            String comm_url1=comm_url.replaceAll("1111",comment_id);

            Document commJs=Jsoup.connect(comm_url1).ignoreContentType(true).timeout(100000).get();
            Elements body_comContent=commJs.select("body");
            String commJson=body_comContent.text();
            /*
            "id":"6408564224441552254"
             */
            System.out.println(commJson);

            JSONObject jsonObject=JSONObject.parseObject(commJson);
            System.out.println(jsonObject);

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println(commJson);
            out.flush();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
