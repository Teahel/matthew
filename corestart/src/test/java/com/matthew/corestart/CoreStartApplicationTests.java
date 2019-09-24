package com.matthew.corestart;

import com.matthew.entity.Article;
import com.matthew.entity.ArticleType;
import com.matthew.entity.User;
import com.matthew.service.ArticleService;
import com.matthew.service.ArticleTypeService;
import com.matthew.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreStartApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleTypeService articleTypeService;

    @Autowired
    private ArticleService articleService;

    /**
     * 保存账户
     */
    @Test
    public void saveUser() {
         User user=new User();
         user.setEmail("li.teahel@gmail.com");
         user.setGithubaddress("git@github.com:Teahel/Code.git");
         user.setPassword(DigestUtils.md5DigestAsHex("1996".getBytes()));
         user.setUsername("matthew");
         boolean flag= userService.save(user);
         System.out.println(flag);
    }

    /**
     * 保存文章
     */
    @Test
    public void saveArticleType(){
        /**
         * 工具类
         * 框架类
         * 算法类
         * 部署类
         * 安全类
         * 基层类
         * 功能类
         * 服务器类
         */
        List<String> list=Arrays.asList("工具类","框架类","算法类","部署类","安全类","基层类","功能类","服务器类");
        for(int i=0;i<list.size();i++){
            ArticleType articleType=new ArticleType();
            articleType.setTypename(list.get(i));
            articleTypeService.save(articleType);
        }
    }


    /**
     * 保存文章
     */
    @Test
    public void saveArticle(){
        Article article=new Article();
        article.setTitle("测试");
        article.setContent("内容测试");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr=simpleDateFormat.format(date);
        article.setCreatetime(datestr);
        article.setUserid("dbab6dc54685431de799c87d27dd37fb");
        article.setReprintlink("www.teahel.com");
        articleService.save(article);
    }
}
