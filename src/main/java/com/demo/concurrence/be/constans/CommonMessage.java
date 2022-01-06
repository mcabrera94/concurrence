package com.demo.concurrence.be.constans;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CommonMessage implements CommonMessageConstant{

    public static Map<String, Object> commonErrorMessage(HttpServletResponse response){
        Map<String, Object> errorMessage = new HashMap<String, Object>();

        errorMessage.put(MESSAGE, COMMON_MESSAGE_ERROR);
        errorMessage.put(TYPE, MESSAGE_TYPE_ERROR);

        return errorMessage;
    }

    public static Map<String, Object> commonExceptionErrorMessage(HttpServletResponse response){
        Map<String, Object> errorMessage = new HashMap<String, Object>();

        errorMessage.put(MESSAGE, COMMON_EXCEPTION_MESSAGE_ERROR);
        errorMessage.put(TYPE, MESSAGE_TYPE_ERROR);

        return errorMessage;
    }

}
