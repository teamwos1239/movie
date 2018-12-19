package com.chinasofti.commonsframework.util;

import org.apache.commons.mail.DefaultAuthenticator;  
import org.apache.commons.mail.EmailException;       
import org.apache.commons.mail.HtmlEmail;
   

/**
 * qq邮箱的pop stmp协议要开
 * 163邮箱的
 * @author Administrator
 *
 */
public class BaseEmailSend     
{    
    public BaseEmailSend()    
    {    
            
    }    
        
        
    public static void send(String subject,String msg,String toEmail)    
    {    
        HtmlEmail email = new HtmlEmail();       
        email.setTLS(true); //是否TLS校验，，某些邮箱需要TLS安全校验，同理有SSL校验  
        email.setDebug(true);  
        email.setHostName("smtp.qq.com");   
        email.setAuthenticator(new DefaultAuthenticator("1224473361@qq.com", "lh122447")); 
        try     
        {    
         email.setFrom("1224473361@qq.com"); //发送方,这里可以写多个  
         email.addTo(toEmail); // 接收方  
         email.setCharset("GB2312");  
         email.setSubject(subject); // 标题  
         email.setHtmlMsg("<p style='font-size: 20px;'>万达电影欢迎你！</p><br /><br /><br/><p>"+msg+"</p>");
         email.send();  
        } catch (EmailException e) {    
            e.printStackTrace();    
        }     
    }    
  
    
  /*  public static void main(String[] args) {
		send("万达电影  欢迎注册万达", "恭喜，您已正式成为了我们的会员。", "2413173723@qq.com");
		send("万达电影  您已购买成功", "您已购买成功，您的电影兑换码是："+"xxxx", "2413173723@qq.com");
//		send("万达电影  欢迎注册万达", "恭喜，您已正式成为了我们的会员。", "791151634@qq.com");
//		send("万达电影  您已购买成功", "您已购买成功，您的电影兑换码是："+"xxxx", "791151634@qq.com");
		
	}*/
       
}  