package com.dream.ltl.springboot.importSelectorDemo3;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited

@Import(GpDefineImportSelector.class)
public @interface EnableDefineService {

}
