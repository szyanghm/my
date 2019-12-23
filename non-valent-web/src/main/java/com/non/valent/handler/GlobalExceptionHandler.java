//package com.non.valent.handler;
//
//
//import com.non.valent.api.ErrorType;
//import com.non.valent.exception.ApiException;
//import com.non.valent.utils.ExceptionUtils;
//import com.non.valent.vo.ResultVO;
//import com.tax.invoice.excepiton.ApiException;
//import com.tax.invoice.excepiton.InternalApiException;
//import com.tax.invoice.excepiton.RemoteBaseException;
//import com.tax.invoice.model.base.ErrorResponseEntity;
//import com.tax.invoice.util.ExceptionUtil;
//import com.tax.invoice.util.WechatSendMessagesUtil;
//import com.tax.invoice.vo.ResponseVO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 全局异常处理
// *
// * @author dragonlai
// * @ControllerAdvice 捕获 Controller 层抛出的异常，如果添加 @ResponseBody 返回信息则为JSON 格式。
// * @RestControllerAdvice 相当于 @ControllerAdvice 与 @ResponseBody 的结合体。
// * @ExceptionHandler 统一处理一种类的异常，减少代码重复率，降低复杂度。
// * @since 2019/6/20 0001
// */
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
//    /**
//     * web服务给终端调用外部接口异常捕获 可以多个 @ExceptionHandler({})
//     * 此方法返回ResponseVO给终端最终实体
//     *
//     * @param request  request
//     * @param e        exception
//     * @param response response
//     * @return 响应结果
//     */
//    @ExceptionHandler(ApiException.class)
//    public ResultVO ApiExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.BAD_REQUEST.value());
//        ApiException exception = (ApiException) e;
//        log.error("具体错误信息:{}", ExceptionUtils.getErrorMessage(exception));
//        return new ResultVO(String.valueOf(exception.getCode()), exception.getMessage());
//    }
//
//
//    /**
//     * web远程调用service服务内部接口异常捕获
//     * 此方法返回网络状态码为200的ResponseVO对象
//     * 使用场景：当抛出此异常时，会将其捕捉解析成正常的网络状态码200的ResponseVO对象，可用于微服务之间ResponseVO交互
//     *
//     * @param request  request
//     * @param e        exception
//     * @param response response
//     * @return 响应结果
//     */
//    @ExceptionHandler(InternalApiException.class)
//    public ResultVO InternalApiExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.OK.value());
//        InternalApiException exception = (InternalApiException) e;
//        log.error("具体错误信息:{}", ExceptionUtil.getErrorMessage(exception));
//        //TODO 异常推送
//        return new ResponseVO(exception.getCode(), exception.getMessage());
//    }
//
//    /**
//     * @param request  request
//     * @param e        exception
//     * @param response response
//     * @return 响应结果
//     */
//    @ExceptionHandler(RemoteBaseException.class)
//    public ErrorResponseEntity RemoteBaseExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.BAD_REQUEST.value());
//        RemoteBaseException exception = (RemoteBaseException) e;
//        log.error("具体错误信息:{}", ExceptionUtil.getErrorMessage(exception));
//        return new ErrorResponseEntity(exception.getCode(), exception.getMessage());
//    }
//
//    /**
//     * 捕获  RuntimeException 异常
//     * TODO  如果你觉得在一个 exceptionHandler 通过  if (e instanceof xxxException) 太麻烦
//     * TODO  那么你还可以自己写多个不同的 exceptionHandler 处理不同异常
//     *
//     * @param request  request
//     * @param e        exception
//     * @param response response
//     * @return 响应结果
//     */
//    @ExceptionHandler(RuntimeException.class)
//    public ResultVO runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.BAD_REQUEST.value());
//        RuntimeException exception = (RuntimeException) e;
//        log.error("具体错误信息:{}", ExceptionUtils.getErrorMessage(exception)); //会记录出错的代码行等具体信息
//        //TODO 异常推送
//        return new ResultVO("400", exception.getMessage());
//    }
//
//    /***
//     * IO流转换异常
//     * @param request
//     * @param e
//     * @param response
//     * @return
//     */
//    @ExceptionHandler(IOException.class)
//    public ResultVO ioExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.BAD_REQUEST.value());
//        IOException exception = (IOException) e;
//        log.error("具体错误信息:{}", ExceptionUtils.getErrorMessage(exception));
////        wechatSendMessagesUtil.sendMessages(exception.getMessage());
//        return new ResultVO("400", exception.getMessage());
//    }
//
//    /**
//     * 通用的接口映射异常处理方
//     */
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
//                                                             HttpStatus status, WebRequest request) {
//        if (ex instanceof MethodArgumentNotValidException) {
//            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
//            return new ResponseEntity<>(new ResultVO<>(String.valueOf(status.value()), exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()), status);
//        }
//        if (ex instanceof MethodArgumentTypeMismatchException) {
//            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
//            log.error("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数：" + exception.getName()
//                    + ",信息：" + exception.getLocalizedMessage());
//            return new ResponseEntity<>(new ResultVO(String.valueOf(status.value()), "参数转换失败"), status);
//        }
//        return new ResponseEntity<>(new ResultVO(String.valueOf(status.value()), "参数转换失败"), status);
//    }
//}
