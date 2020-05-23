package com.dream.ltl.spring.annotation.componentscan;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter  implements TypeFilter {

    /**
     *
     * @param metadataReader useDefaultFilters = true   获取内没有注解的类信息,
     *                       useDefaultFilters = false  获得包内所有注解的类信息
     * @param metadataReaderFactory 获取上下文中所有信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获得包内所有注解的类信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前扫描到的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        String className = classMetadata.getClassName();

        System.out.println("--------"+className+"-----------");
        if (className.contains("er")){
            return true;
        }
        return false;
    }
}
