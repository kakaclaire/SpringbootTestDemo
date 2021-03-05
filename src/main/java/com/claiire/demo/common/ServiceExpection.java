package com.claiire.demo.common;

/**
 * 〈一句话功能简述〉<br>
 * 〈自定义业务异常〉
 *服务异常类
 * @author Claire
 * @create 2021/3/4
 * @since 1.0.0
 */
public class ServiceExpection extends RuntimeException{
    private static final long serialVersionUID =1l;

    private String message;
    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    //自定义构造方法实时传送信息具体异常给父类，提示信息给当前类
    public ServiceExpection(final String message,Throwable th){
        super(message,th);
        this.message=message;
    }
    public ServiceExpection(final String message){
        this.message=message;
    }
    public static void throwEx(String message){
        throw new ServiceExpection(message);
    }


}
