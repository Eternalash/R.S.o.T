package com.designpattern.mediator;

/**
 * Author Bryan.C <br>
 * Date 2018/5/9
 */
public abstract class Colleague {
    // 维持一个抽象中介者的引用
    protected Mediator mediator;

    protected String name;

    public Colleague(String name, Mediator mediator){
        this.mediator = mediator;
        this.name = name;
    }

    /**
     * 设置中介者对象
     * @param mediator
     */
    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }

    /**
     * 向中介 发送消息
     */
    protected abstract void sendMessage(String msg);

    /**
     * 从中介 获取消息
     */
    protected abstract void getMessage(String msg);
}
