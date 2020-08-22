package com.dream.ltl.mvcframework.webmvc.servlet;

import java.io.File;

public class GPViewResolver {
    private File templateRootDir;
    private final String DEFAULT_TEMPLATE_SUFFIX=".html";
    public GPViewResolver(String templateRoot) {

        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        templateRootDir = new File(templateRootPath);
    }

    public GPView resolveViewName(String viewName){
        if (null == viewName || "".equals(viewName.trim()))return null;
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFIX)?viewName: (viewName+DEFAULT_TEMPLATE_SUFFIX);
        File templateFile = new File((templateRootDir.getPath()+ File.separator+viewName).replaceAll("/+",""));


        return new GPView(templateFile);
    }
}
