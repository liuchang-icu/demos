package cn.basefly.casclint;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController()
public class TestController {
    @GetMapping(value = "/")
    public String test(HttpServletRequest request){
        String  user  = request.getRemoteUser();
        System.out.println("welcome" + user);
        return "1";
    }
    @GetMapping(value = "/test2")
    public String test2(HttpServletRequest request){
        String  user  = request.getRemoteUser();
        System.out.println("test2" + user);
        return "2";
    }
}
