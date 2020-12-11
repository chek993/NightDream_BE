package com.polimi.nightdream.config;

import com.polimi.nightdream.NightdreamApplication;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.StandardServletEnvironment;

import javax.persistence.Entity;
import java.util.LinkedList;
import java.util.List;

@Component
public class RestMvcConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setBasePath("/api");
        config.setReturnBodyOnCreate(true);
        config.setReturnBodyOnUpdate(true);
        config.getCorsRegistry()
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "PUT", "POST", "DELETE");

        //Questo codice serve per aggiungere l'id nel rest repository, prima identifica le classi mappate come @Entity e li aggiunge ad una lista di tipo Class
        final List<Class<?>> result = new LinkedList<Class<?>>();
        final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(true, new StandardServletEnvironment());
        provider.addIncludeFilter(new AnnotationTypeFilter(Entity.class));

        for(BeanDefinition beanDefinition : provider.findCandidateComponents(NightdreamApplication.class.getPackage().getName())){
            try {
                result.add(Class.forName(beanDefinition.getBeanClassName()));
            } catch (ClassNotFoundException e) {
                e.getException();
            }

            //Questo permette di aggiungere l'id a tutte le classi contenute nella lista
            config.exposeIdsFor(result.toArray(new Class[result.size()]));
        }
    }
}
