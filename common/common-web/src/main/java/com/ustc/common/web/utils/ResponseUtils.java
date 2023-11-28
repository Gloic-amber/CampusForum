package com.ustc.common.web.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * ClassName: ResponseUtils
 * Package: com.ustc.common.web.utils
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/28 15:49
 * @Version 1.0
 */
public class ResponseUtils {

    static ObjectWriter writer;

    static {
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        writer = mapper.writer(dateFormat);
    }

    public static void objectToJson(HttpServletResponse response, Object object) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        writer.writeValue(response.getWriter(), object);
    }

}
