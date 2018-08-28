package eduardoppalardo.trip.manager;

import javax.validation.Validator;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import eduardoppalardo.trip.manager.repository.TripRepository;

@EnableJpaRepositories(basePackageClasses = { TripRepository.class })
@org.springframework.context.annotation.Configuration
public class Configuration {

	// @Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:application");
		return messageSource;
	}

	// @Bean
	public Validator validator(MessageSource messageSource) {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource);
		return localValidatorFactoryBean;
	}
}