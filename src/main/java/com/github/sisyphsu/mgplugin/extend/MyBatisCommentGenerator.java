package com.github.sisyphsu.mgplugin.extend;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * Generator comment for all field of Model, which from the metadata of database.
 * <p>
 * Created by sulin on 2017-10-17 23:01:47.
 */
public class MyBatisCommentGenerator extends DefaultCommentGenerator {
    
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        if (introspectedColumn.getRemarks() != null) {
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        }
        sb.append(" * Field : ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" * @mbggenerated");
        field.addJavaDocLine(" */");
    }
    
}
