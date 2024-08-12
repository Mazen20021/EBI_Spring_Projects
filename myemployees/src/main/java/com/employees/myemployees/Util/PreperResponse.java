package com.employees.myemployees.Util;

import com.employees.myemployees.Models.GeneralResponse;

public class PreperResponse {


   public static GeneralResponse preperResponse (Object data , String message , String code)
    {
        GeneralResponse response = new GeneralResponse();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }


}
