package com.roy.utils;

import com.roy.beans.Employee;
import com.roy.beans.Person;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


/**
 * description：
 * author：dingyawu
 * date：created in 14:20 2020/12/5
 * history:
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值为需要导入到容器中的bean的全类名数组
     * AnnotationMetadata：当前标注@Import注解的类的所有注解信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Person.class.getName(), Employee.class.getName()};
    }
}
