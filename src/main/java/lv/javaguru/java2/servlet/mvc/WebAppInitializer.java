package lv.javaguru.java2.servlet.mvc;


import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.config.WebMVCConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {WebMVCConfig.class}; // We dont need any special servlet config yet.
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		AnnotationConfigWebApplicationContext applicationContext =
				new AnnotationConfigWebApplicationContext();
		applicationContext.register(SpringAppConfig.class);
		return applicationContext;
	}

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		AnnotationConfigWebApplicationContext applicationContext =
				new AnnotationConfigWebApplicationContext();
		applicationContext.register(WebMVCConfig.class);
		return applicationContext;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
