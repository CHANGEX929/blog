package com.changex.blog.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.BindHandler;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.bind.PropertySourcesPlaceholdersResolver;
import org.springframework.boot.context.properties.bind.handler.IgnoreTopLevelConverterNotFoundBindHandler;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.PropertySources;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/23 23:48
 */
@Component
public class CustomizedConfigurationPropertiesBinder implements ApplicationContextAware {

    private ConfigurableApplicationContext applicationContext;
    private PropertySources propertySources;
    private Binder binder;

    public void bind(String configPrefix, Bindable<?> bean) {
        BindHandler handler = new IgnoreTopLevelConverterNotFoundBindHandler();
        this.binder.bind(configPrefix, bean, handler);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
        this.propertySources = this.applicationContext.getEnvironment().getPropertySources();
        this.binder = new Binder(getConfigurationPropertySources(), getPropertySourcesPlaceholdersResolver(),
                getConversionService(), getPropertyEditorInitializer());
    }

    private Iterable<ConfigurationPropertySource> getConfigurationPropertySources() {
        return ConfigurationPropertySources.from(this.propertySources);
    }

    private PropertySourcesPlaceholdersResolver getPropertySourcesPlaceholdersResolver() {
        return new PropertySourcesPlaceholdersResolver(this.propertySources);
    }

    private ConversionService getConversionService() {
        return this.applicationContext.getBeanFactory().getConversionService();
    }

    private Consumer<PropertyEditorRegistry> getPropertyEditorInitializer() {
        return this.applicationContext.getBeanFactory()::copyRegisteredEditorsTo;
    }
}
