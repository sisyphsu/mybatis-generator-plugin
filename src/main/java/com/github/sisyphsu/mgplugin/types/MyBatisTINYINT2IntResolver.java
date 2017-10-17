package com.github.sisyphsu.mgplugin.types;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;

/**
 * Support type conversion: TINYINT(db) <-> Integer(java)
 * <p>
 * Created by sulin on 2017-10-17 23:08:14.
 */
public class MyBatisTINYINT2IntResolver extends JavaTypeResolverDefaultImpl {
    
    @Override
    public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {
        FullyQualifiedJavaType result = super.calculateJavaType(introspectedColumn);
        if (introspectedColumn.getJdbcType() == Types.TINYINT) {
            result = new FullyQualifiedJavaType(Integer.class.getName());
        }
        return result;
    }
    
}
