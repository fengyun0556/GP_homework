package com.gupaoedu.spring.framework.webmvc.servlet;

import java.io.File;
import java.util.Locale;

public class GPViewResolver {

    private final String DEFAULT_TEMPLATE_SUFfIX = ".html";

    private File templateFile;

    public GPViewResolver(File templateFile) {
        this.templateFile = templateFile;
    }

    public GPView resolveViewName(String viewName, Locale locale) throws Exception{
        if (viewName == null || "".equals(viewName.trim())) return null;
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFfIX) ? viewName : (viewName + DEFAULT_TEMPLATE_SUFfIX);
        File templateFile = new File((this.templateFile.getPath() + "/").replaceAll("/+", "/"));
        return new GPView(templateFile);
    }

}
