package cn.basefly.casclint;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas30ProxyReceivingTicketValidationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.EventListener;

@SpringBootApplication
public class CasClintApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasClintApplication.class, args);

    }

     // 研发云 单点登出的filter。当某一个应用登出时，单点登录服务器将发送请求，被此拦截器拦截后销毁自身应用session，达到slo效果。
    @Bean
    public FilterRegistrationBean casSingleSignOutFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SingleSignOutFilter());
        registration.addUrlPatterns("/*");
        // 此处的casServerUrlPrefix value值，请填写中移在线 研发云 的互联网域nginx内网地址访问cas
        registration.addInitParameter("casServerUrlPrefix", "http://localhost:8080/cas/logout");
        registration.setName("casSingleSignOutFilter");
        registration.setOrder(1);
        return registration;
    }


     // 进行鉴权并跳转到单点登录服务器的登录页面进行登录鉴权


    @Bean
    public FilterRegistrationBean casAuthenticationFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationFilter());
        registration.addUrlPatterns("/*");
        // 此处的casServerLoginUrl value值，请填写中移在线 研发云 的互联网域nginx的login地址
        registration.addInitParameter("casServerLoginUrl", "http://localhost:8080/cas/login");
        // 此处的service value值，请填写中移在线 研发云 的研发云首页的地址（互联网域nginx访问地址），当sso登录成功后，会给予此value进行跳转到研发云首页
        registration.addInitParameter("serverName", "http://localhost:8082/");
        registration.setName("casAuthenticationFilter");
        registration.setOrder(2);
        return registration;
    }


      //鉴权成功后，对于下发的ST进行再次确认校验


    @Bean
    public FilterRegistrationBean casValidationFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new Cas30ProxyReceivingTicketValidationFilter());
        registration.addUrlPatterns("/*");
        // 此处的casServerLoginUrl value值，cas server认证地址
        registration.addInitParameter("casServerUrlPrefix", "http://localhost:8080/cas");
        // 此处的serverName value值，认证成功
        registration.addInitParameter("serverName", "http://localhost:8082/");
        registration.addInitParameter("redirectAfterValidation", "true");
        registration.addInitParameter("useSession", "true");
        registration.addInitParameter("authn_method", "mfa-duo");
        registration.setName("casValidationFilter");
        registration.setOrder(3);
        return registration;
    }

    @Bean
    public FilterRegistrationBean casHttpServletRequestWrapperFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new HttpServletRequestWrapperFilter());
        registration.addUrlPatterns("/*");
        registration.setName("casHttpServletRequestWrapperFilter");
        registration.setOrder(4);
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<EventListener> getSingleSignOutHttpSessionListener(){
        ServletListenerRegistrationBean<EventListener> registrationBean =new ServletListenerRegistrationBean<>();
        registrationBean.setListener(new SingleSignOutHttpSessionListener());
        return registrationBean;
    }
}
