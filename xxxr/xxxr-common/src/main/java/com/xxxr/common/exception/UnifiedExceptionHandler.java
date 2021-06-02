package com.xxxr.common.exception;

import com.xxxr.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 */
//配置异常切面，项目一旦发生异常进入到类中执行
@RestControllerAdvice
@Slf4j
public class UnifiedExceptionHandler {

    //处理Exception类型的异常
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e){
        log.error(e.getMessage(),e);
        return R.error();
    }

    /**
     * 定义异常处理
     */
    @ExceptionHandler(value = BusinessException.class)
    public R handleBusiness(BusinessException e){
        log.error(e.getMessage(),e);
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
