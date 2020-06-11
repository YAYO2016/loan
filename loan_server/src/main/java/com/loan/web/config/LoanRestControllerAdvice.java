package com.loan.web.config;

import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author GuoKang
 * @date 2019-04-18 00:39
 */
@RestControllerAdvice
public class LoanRestControllerAdvice {
    private Logger logger = LoggerFactory.getLogger(LoanRestControllerAdvice.class);

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    public JsonData runtimeExceptionHandler(Exception ex) {
        logger.error("Uncatched exception:", ex);
        //处理后端校验异常
        if (ex instanceof ConstraintViolationException) {
            String message = ex.getMessage();
            if (StringUtils.hasText(message)) {
                message = StringUtils.trimAllWhitespace(message);
                String[] strings = message.split(":");
                if (strings.length > 0) {
                    String code = strings[1];
                    int index = code.indexOf(",");
                    if (index > 0) {
                        code = code.substring(0, index);
                    }
                    return JsonData.getResult(CommonData.StatusCode.valueOf(code), ex.getMessage());
                }
            }
        }

        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            for (ObjectError error : exception.getBindingResult().getAllErrors()) {
                String message = error.getDefaultMessage();
                return JsonData.getResult(CommonData.StatusCode.valueOf(message), ex.getMessage());
            }
        }

        return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_100.getCode(),
                null == ex.getMessage() ? ex.toString() : ex.getMessage());
    }
}
