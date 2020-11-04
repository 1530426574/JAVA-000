package src.com.louis.homework;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class HelloClassLoader extends ClassLoader {
    @Override
    public Class findClass(String name) {
        byte[] b = new byte[0];
        try {
            b = loadClassFromFile(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // name 就是加载的类名称，这里注意要填写正确
        return defineClass("Hello", b, 0, b.length);
    }

    /**
     * 读取class文件，转化内容为字节流
     * @param fileName 文件路径
     * @return
     * @throws FileNotFoundException
     */
    private byte[] loadClassFromFile(String fileName) throws FileNotFoundException {
        System.out.println(fileName);
        File file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                // 注意字节还原
                byteStream.write(255 - nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String path = "C:\\Users\\12439\\Documents\\Code\\Java\\JAVA-000\\Week_01\\code\\src\\main\\resources\\Hello.xlass".replace("\\", "/");
        HelloClassLoader loader = new HelloClassLoader();
        Class hello = loader.loadClass(path);
        System.out.println(hello.getName());
        Object instance = hello.newInstance();
        System.out.println(hello.getMethod("hello").invoke(instance));
    }
}