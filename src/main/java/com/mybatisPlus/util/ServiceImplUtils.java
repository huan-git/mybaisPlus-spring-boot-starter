package com.mybatisPlus.util;

import com.mybatisPlus.autoconfigure.MybatisPlusProperties;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * @ClassName ControllerUtils
 * @Description: ControllerUtils.java
 * @Author Ahuan
 * @Date 2020/5/14 
 * @Version V1.0
 **/
public class ServiceImplUtils {

    public static String getServiceImplJava(MybatisPlusProperties properties, String tableName) {
        String date = StringUtils.date2Str(new Date());
        String basePackage = properties.getBasePackage();
        String daoPackage = properties.getDaoPackage();
        String className = StringUtils.underlineToCamel(tableName);
        String classname = StringUtils.initcap(className);
        return get(basePackage,daoPackage,date,className,classname);
    }

    public static String get(String basePackage,String daoPackage, String date, String className,String classname) {
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(basePackage).append(".service.impl;\n\n")
                .append("import javax.annotation.Resource;").append("\n")
                .append("import org.springframework.stereotype.Service;").append("\n\n")
                .append("import ").append(basePackage).append(".service.").append(className)
                .append("Service;").append("\n")
                .append("import ").append(daoPackage).append(".").append(className)
                .append("Mapper;").append("\n\n")
                .append("/***\n")
                .append(" *@author Created by Mybatis Generator on ").append(date).append("\n")
                .append(" */\n")
                .append("@Service\n")
                .append("public class ").append(className)
                .append("ServiceImpl implements ").append(className).append("Service {\n\n")
                .append("    @Resource")
                .append("\n    private ").append(className).append("Mapper ").append(classname).append("Mapper;")
                .append("\n\n").append("}");
        return sb.toString();
    }
}