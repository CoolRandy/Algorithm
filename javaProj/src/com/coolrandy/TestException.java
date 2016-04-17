package com.coolrandy;

/**
 * Created by randy on 2016/4/10.
 * �������java�쳣����
 */
public class TestException {

    public TestException() {
    }

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1() throws Exception{

        boolean ret = true;
        try {
            ret = testEx2();
            if (!ret){
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        }catch (Exception e){
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        }finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx2() throws Exception{

        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--){
                c = b / i;
                System.out.println("i=" + i);
            }//��ִ��forѭ���Ĺ����г������쳣
            return true;
        }catch (Exception e){
            System.out.println("testEx2, catch exception!");
            ret = false;
            throw e;//���쳣�׳�ȥ��
        }finally {//finally���һ����ִ��
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;
        }
    }

    public static void main(String[] args) {
        TestException testException1 = new TestException();
        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * ���н��Ϊ��
 * i=2
 i=1
 testEx2, catch exception!
 testEx2, finally; return value=false
 testEx1, finally; return value=false
 testEx, finally; return value=false



 */
