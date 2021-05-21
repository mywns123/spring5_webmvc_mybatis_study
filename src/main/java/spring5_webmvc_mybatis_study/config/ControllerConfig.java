package spring5_webmvc_mybatis_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextSqlSession.class,ContextDataSource.class,MvcConfig.class  })
@ComponentScan(basePackages = {"spring5_webmvc_mybatis_study.controller",
		"spring5_webmvc_mybatis_study.survey"})
public class ControllerConfig {

	
}
