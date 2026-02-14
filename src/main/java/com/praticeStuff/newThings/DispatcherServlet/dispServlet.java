// works in spring mvc normally  in spring boot causes confusion with the default dispatcher servlet.



//package com.epam.newThings.DispatcherServlet;
//
//import com.epam.Main;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class dispServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[0];
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {f
//        System.out.println("got the config class");
//        return new Class[]{Main.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};       // every req that will come with this prefic will be handled
                                         // by this dispServlet
//    }
//}
