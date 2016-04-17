package com.coolrandy.jvm;

import javafx.scene.Parent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * Created by randy on 2016/3/10.
 *
 * 代码分析：实现2：1、先检查是否已被加载过，若没有加载则调用父加载器的loadClass方法
 * 2、若父加载器为空，则默认使用启动类加载器作为父加载器（将任务逐级向上委派）
 * 3、若父类加载失败，则在抛出ClassNotFoundException异常后，在调用自己的findClass方法进行加载
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        //实现1：简单的类加载器
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    System.out.println("fileName:  " + fileName);
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (null == is){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (IOException e){

                    throw new ClassNotFoundException(name);
                }
            }
        };


        //实现2：采用双亲委派模型实现的类加载器
//        ClassLoader parentloader = new ClassLoader() {
//            @Override
//            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
//                //首先检查类是否已经加载过
//                Class c = findLoadedClass(name);
//                if (null == c){
//                    try {
//                        if (getParent() != null){
//                            c = getParent().loadClass(name, false);
//                        }
//                    }
//                }
//                return super.loadClass(name, resolve);
//            }
//        };

        Object object = classLoader.loadClass("com.coolrandy.jvm.ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof com.coolrandy.jvm.ClassLoaderTest);
        /**
         * 测试扩展类、系统类加载器
         */
        try{
            System.out.println(ClassLoader.getSystemClassLoader());
            System.out.println(ClassLoader.getSystemClassLoader().getParent());
            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        }catch (Exception e){
            e.printStackTrace();
        }
        /**
         * 输出：
         * sun.misc.Launcher$AppClassLoader@42a57993
            sun.misc.Launcher$ExtClassLoader@6d6f6e28
            null
            可以看到扩展类加载器的父类加载器为null
         */
    }
    /**
     * 运行结果为：
     *   fileName:  ClassLoaderTest.class
         fileName:  Object.class
         fileName:  ClassLoader.class
         fileName:  ClassLoaderTest$1.class
         class com.coolrandy.jvm.ClassLoaderTest
         false
         主要看后两句输出：第一句输出可以看到类确实是类com.coolrandy.jvm.ClassLoaderTest实例化出来的对象
         第二句可以发现这个对象与类com.coolrandy.jvm.ClassLoaderTest所属类型检查时却返回了false，这是因为虚拟机中存在
         了两个ClassLoaderTest类，一个是由系统应用程序类加载器加载的，另外一个是由我们自定义的类加载器加载的，虽然都来自
     同一个Class文件，但是依然是两个独立的类，故而做对象所属类型检查时结果自然为false
     */
}
