package com.loan.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author GuoKang
 * @date 2019/8/6 15:43
 */
public class HttpUtil {

    public static void sendResponse(HttpServletResponse response, Object content) {
        PrintWriter out = null;
        try {
            response.setContentType("application/json;charset=utf-8");
            out = response.getWriter();
            out.write(new ObjectMapper().writeValueAsString(content));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }
}
