package com.java2s.reflection;

import java.io.Serializable;
import java.lang.annotation.Annotation;

import javax.annotation.Generated;

public class GetAnnotation {
    public static void main(String[] args) {
        Annotation[] as = Person.class.getAnnotations();
        
        for(int i=0;i<as.length;i++){
            System.out.println(as[i].annotationType());        
        }
        System.out.println("=============================");
        Annotation a = Person.class.getAnnotation(Deprecated.class);
        System.out.println(a);  
        Annotation[] das = Person.class.getDeclaredAnnotations();
        for(int i=0;i<das.length;i++){
            System.out.println(das[i].annotationType());        
        }        
    }
}


///



@Deprecated
@SuppressWarnings(value = { "str" })
class Person implements Serializable {

  Integer id;
  String name;
}
