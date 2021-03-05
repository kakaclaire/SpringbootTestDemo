//package com.claiire.demo.common;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// * 全局异常捕获类，主要分业务异常和其他异常两种
// * 业务异常为使用serviceException类包装的异常，其他异常为java原生异常
// *
// * @author Claire
// * @create 2021/3/4
// * @since 1.0.0
// */
//@ControllerAdvice //全局捕获异常，异常集中处理，更好的使业务逻辑与异常处理剥离开，更好的定义在类上
//@ResponseBody//将响应直接映射到http响应
//@Slf4j
//public class GlobalExceptionHandler {
//    //业务异常
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//将某种异常映射为HTTP状态码，可用于方法上，也可以用于类上（自定义运行时异常类）
//    @ExceptionHandler({ServiceExpection.class})//统一处理某类异常，声明该方法用于捕获value所指的类型的异常（注意：当子父类都被声明的话，按照先子后父的顺序进行捕获）
//    public String serviceExceptionHandler(ServiceExpection se) {
//        //打印日志
////        log.error(se.getMessage());
////        return "业务异常  系统繁忙，请稍后重试";
//        return resultFormat(se);
//    }
//
//    //业务异常没有捕获到会交给其他异常去处理
//    @ResponseStatus(HttpStatus.BAD_GATEWAY)
//    @ExceptionHandler({Exception.class})
//    public String exceptionHandler(Exception e) {
////        log.error(e.getMessage());
////        return "非业务异常  系统繁忙，请稍后重试";
//        return resultFormat(e);
//    }
//
//    @ExceptionHandler({Throwable.class})
//    public String throwableHandler(Throwable t) {
////        log.error(t.getMessage());
////        return "系统错误  系统繁忙，请稍后重试";
//        return resultFormat(t);
//    }
//
//    //resultFormat（T ex）：将异常转换为统一大对象，将字符串统一处理
//    public String resultFormat(Throwable t) {
//        String tips = "系统繁忙，请稍后重试";
//        if (t instanceof ServiceExpection) {
//            return "业务异常" + tips;
//        }
//        if(t instanceof Exception){
//            return "非业务异常" +tips;
//        }return tips;
//    }
//
//
//}
