package com.coolrandy.jvm;

import javafx.scene.Parent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * Created by randy on 2016/3/10.
 *
 * ���������ʵ��2��1���ȼ���Ƿ��ѱ����ع�����û�м�������ø���������loadClass����
 * 2������������Ϊ�գ���Ĭ��ʹ���������������Ϊ����������������������ί�ɣ�
 * 3�����������ʧ�ܣ������׳�ClassNotFoundException�쳣���ڵ����Լ���findClass�������м���
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        //ʵ��1���򵥵��������
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


        //ʵ��2������˫��ί��ģ��ʵ�ֵ��������
//        ClassLoader parentloader = new ClassLoader() {
//            @Override
//            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
//                //���ȼ�����Ƿ��Ѿ����ع�
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
         * ������չ�ࡢϵͳ�������
         */
        try{
            System.out.println(ClassLoader.getSystemClassLoader());
            System.out.println(ClassLoader.getSystemClassLoader().getParent());
            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        }catch (Exception e){
            e.printStackTrace();
        }
        /**
         * �����
         * sun.misc.Launcher$AppClassLoader@42a57993
            sun.misc.Launcher$ExtClassLoader@6d6f6e28
            null
            ���Կ�����չ��������ĸ��������Ϊnull
         */
    }
    /**
     * ���н��Ϊ��
     *   fileName:  ClassLoaderTest.class
         fileName:  Object.class
         fileName:  ClassLoader.class
         fileName:  ClassLoaderTest$1.class
         class com.coolrandy.jvm.ClassLoaderTest
         false
         ��Ҫ���������������һ��������Կ�����ȷʵ����com.coolrandy.jvm.ClassLoaderTestʵ���������Ķ���
         �ڶ�����Է��������������com.coolrandy.jvm.ClassLoaderTest�������ͼ��ʱȴ������false��������Ϊ������д���
         ������ClassLoaderTest�࣬һ������ϵͳӦ�ó�������������صģ�����һ�����������Զ��������������صģ���Ȼ������
     ͬһ��Class�ļ���������Ȼ�������������࣬�ʶ��������������ͼ��ʱ�����ȻΪfalse
     */
}
