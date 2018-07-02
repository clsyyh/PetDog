package org.PetDog.controller;

import com.alibaba.fastjson.JSON;
import org.PetDog.entity.Comment;
import org.PetDog.entity.Login;
import org.PetDog.entity.Question;
import org.PetDog.entity.User;
import org.PetDog.service.CommentService;
import org.PetDog.service.QuestionService;
import org.PetDog.service.UserService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class QuestionAndCommentController {
    @Autowired
    @Qualifier("questionService")
    private QuestionService questionService;
    @Autowired
    @Qualifier("commentService")
    private CommentService commentService;
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @RequestMapping("/addQuestion")
    public void addQuestion(@RequestParam("title") String title,
                            @RequestParam("content") String content,
                            HttpServletResponse response,
                            HttpSession session)throws Exception{
        //首先登录才可以提问
        Login login=(Login)session.getAttribute("user");
        User user=userService.findUserByLoginname(login.getLoginname());

        Question question=new Question();
        question.setUser(user);
        question.setTitle(title);
        question.setContent(content);

        questionService.addQuestion(question);
        response.setContentType("text/htnl;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(1);
        out.flush();
        out.close();
    }
    @RequestMapping("/selectQuestions")
    public void selectQuestions(HttpServletResponse response)throws Exception{
        List<Question> questions=questionService.findAll();
        for (Question question:questions){
            System.out.println(question.getUser().getLoginname());
        }
        String responseStr= JSON.toJSONString(questions);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(responseStr);
        out.flush();
        out.close();

    }
    @RequestMapping("/selectComments")
    public void selectComments(@RequestParam("questionId") Integer questionId,
                               HttpServletResponse response)throws Exception{
        List<Comment> comments=commentService.selectByQuestionId(questionId);
        String responseStr= JSON.toJSONString(comments);
        for(Comment comment:comments){
            System.out.println(comment.getComment());
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(responseStr);
        out.flush();
        out.close();
    }
    @RequestMapping("/addComment")
    public void addComment(@RequestParam("comment") String comment,
                           @RequestParam("questionId") Integer questionId,
                           HttpServletResponse response,
                           HttpSession session)throws Exception{
        //首先登录才可以发表评价
        Login login=(Login)session.getAttribute("user");
        User user=userService.findUserByLoginname(login.getLoginname());


        Comment comment1=new Comment();
        comment1.setComment(comment);
        comment1.setQuestionId(questionId);
        comment1.setUser(user);

        int count=commentService.addComment(comment1);
        System.out.println(count);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(1);
        out.flush();
        out.close();
    }
}
