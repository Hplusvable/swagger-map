package com.lsp.entity;
/**
 * 存放多个实例的便捷类
 */
public class Value2<T,V> {

    public final T v1;

    public final V v2;

    public Value2(T v1, V v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

}

