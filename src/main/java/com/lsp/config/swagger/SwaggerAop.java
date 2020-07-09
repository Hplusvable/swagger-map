package com.lsp.config.swagger;

import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.properties.Property;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class SwaggerAop {



    @Pointcut(value = "execution(public * springfox.documentation.swagger2.mappers.ModelMapper.mapModels(..))")
    public void point(){

    }

    @Around("point()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Map<String, Model> returnValue = (Map<String, Model>) proceedingJoinPoint.proceed();

        returnValue.putAll(ModelCache.extra_cache);

        ModelCache.specified_cache.entrySet().forEach(e->{

            String key = e.getKey();

            String model_name = e.getValue().v1;

            String[] fields = e.getValue().v2;

            Model model = returnValue.get(model_name);

            if(model == null){
                throw new RuntimeException("不存在的类型"+model_name);
            }

            Map<String, Property> properties = model.getProperties();

            ModelImpl newModel = new ModelImpl();

            newModel.setDescription(model.getDescription());
            for(String field : fields){
                Property property = properties.get(field);
                if(property == null){
                    throw new RuntimeException("不存在的属性"+field);
                }
                newModel.property(field,property);
            }

            returnValue.put(key,newModel);

        });

        return returnValue;
    }

}

