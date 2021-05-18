//package com.aoyang.bis.config.exceptions;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
///**
// * 全局异常处理类，只支持controller层，其它地方异常可以向上抛至controller
// * 异常手动捕捉并且先打印日志 然后在抛出进入此处
// * 异常捕捉先优先进入精确捕捉,比如空指针会先进入空指针的处理但是此处没有就会进入运行时异常，若是没有就会进入最大的异常处理类。
// * 从非controller层抛出的异常将在OtherErrorController中处理，它的优先级别低于本类
// * by gc
// */
//@ControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler {
//
//
//    /**
//     * 最大的异常类，返回各个地方抛出时给的信息。
//     *
//     * @param exception
//     * @return
//     */
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception exception) {
//        if (StringUtils.isNotEmpty(exception.getMessage())) {
//            //已经发现的人工记录并返回特殊提示的运行时异常,只有非运行时异常才会进入这
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
//        } else {
//            log.error("服务器发生未知非运行时异常 " + exception + "具体为" + exception.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器异常" + exception + "具体为" + exception.getMessage());
//        }
//    }
//
//    /**
//     * 运行时异常，返回各个地方抛出时给的信息。
//     *
//     * @param runtimeException
//     * @return
//     */
//    @ResponseBody
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleRuntimeException(RuntimeException runtimeException) {
//        String message = runtimeException.getMessage();
//            log.error("服务器发生未知运行时异常 " + runtimeException + "具体为" + runtimeException.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器异常" + runtimeException + "具体为" + runtimeException.getMessage());
//    }
//
//
//}
