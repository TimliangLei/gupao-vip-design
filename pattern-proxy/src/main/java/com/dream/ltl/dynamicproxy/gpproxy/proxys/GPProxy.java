package com.dream.ltl.dynamicproxy.gpproxy.proxys;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GPProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h)
            throws IllegalArgumentException {
        try {
//        todo 1、动态生成源代码
            String src = generateSrc(interfaces);
            System.out.println(src);
//        todo 2、java 文件输出到磁盘，保存为文件
            String filePath = GPProxy.class.getResource("").getPath();
            System.out.println(filePath);
            File f = new File(filePath + "$Proxy0.java");

            FileWriter fileWriter = new FileWriter(f);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();
            //        todo 3、把Java文件编译成$Proxy0.class 文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();
            //        todo 4、加载到JVM中
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
            f.delete();

//        todo 5、返回新的代理对象
            return c.newInstance(h);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return null;
    }

    private static String generateSrc(Class<?>[] interfaces){
        StringBuffer sb = new StringBuffer();
        sb.append(GPProxy.class.getPackage() + ";" + ln);
        sb.append("import " + interfaces[0].getName() + ";" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("GPInvocationHandler h;" + ln);
        sb.append("public $Proxy0(GPInvocationHandler h) { " + ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);
        for (Method m : interfaces[0].getMethods()){
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();
//
            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " +  paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if(i > 0 && i < params.length-1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames + ") {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses +"});" + ln);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})",m.getReturnType()) + ";" + ln);
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
        }
        sb.append("}" + ln);
        return sb.toString();
    }

    private static String getReturnEmptyCode(Class<?> returnType) {
        if (returnType == void.class){
            return "";
        }
        return "return null";
    }

    private static String getCaseCode(String s, Class<?> returnType) {
        return s;

    }

    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }
}
