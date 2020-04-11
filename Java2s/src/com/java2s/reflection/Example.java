package com.java2s.reflection;

import java.lang.reflect.Constructor;

class Foo<T>
{
    private T arg;
    private Foo(T t) {
        this.arg = t;
        System.out.println("In Private Constructor");
    }   

    @Override
    public String toString() {
        return "My argument is: " + arg;
    }   
}

public class Example {
    public static void main(final String[] args) throws Exception {
        Constructor<Foo> constructor;
        constructor = Foo.class.getDeclaredConstructor(Object.class);
        constructor.setAccessible(true);
        Foo<String> foo = constructor.newInstance("arg1");
        System.out.println(foo);
    }   
}
