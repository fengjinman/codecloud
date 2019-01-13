package com.example.demo.datasource;

/**
 * 动态数据源持有者，负责利用ThreadLocal存取数据源名称
 */
public class DynamicDataSourceHolder {
    /**
     * 本地线程共享对象
     */
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    //增
    public static void putDataSource(String name) {
        THREAD_LOCAL.set(name);
    }

    //查
    public static String getDataSource() {
        return THREAD_LOCAL.get();
    }

    //删
    public static void removeDataSource() {
        THREAD_LOCAL.remove();
    }
}
