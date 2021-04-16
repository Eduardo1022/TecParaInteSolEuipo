package com.example.transporte;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@ComponentScan
public class TransporteConfig extends WsConfigurerAdapter {

    @Bean
  public XsdSchema transporteSchema(){
    return new SimpleXsdSchema(new ClassPathResource("transporte.xsd"));
  }

   @Bean
  public ServletRegistrationBean messageDispatcherservlet( ApplicationContext ApplicationContex ){
    MessageDispatcherServlet servlet = new  MessageDispatcherServlet();
    servlet.setApplicationContext(ApplicationContex);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(servlet, "/ws/*");
  }

  @Bean (name = "transporte")
  public DefaultWsdl11Definition defaultWsdl11Definition (XsdSchema transporteSchema){
    DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition ();
    wsdl.setPortTypeName("transportePort");
    wsdl.setLocationUri("/ws/transporte");
    wsdl.setTargetNamespace("http://www.equipo8.me/transporte");
    wsdl.setSchema(transporteSchema);
    return wsdl;
  }
  @Bean
  public FilterRegistrationBean corsFilter(){
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    source.registerCorsConfiguration("/**", config); 
    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
      bean.setOrder(0);
      return bean;
  }
}