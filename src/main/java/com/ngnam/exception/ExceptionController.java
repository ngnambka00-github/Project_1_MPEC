package com.ngnam.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ExceptionController implements ErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

     @RequestMapping("/error")
     public String handlerException(HttpServletRequest request, ModelMap modelMap) {
         String message = null;
         Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
         if (status != null) {
             Integer statusCode = Integer.valueOf(status.toString());
             if (statusCode == HttpStatus.NOT_FOUND.value()) {
                message = "404 - Không tìm thấy trang !";
                LOGGER.error(message);
//             } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                 message = "500 - Lỗi phía server";
//                LOGGER.error(message);
             } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                 message = "403 - Lỗi quyền truy cập";
                 LOGGER.error(message);
             }
         }
         modelMap.addAttribute("messageError", message);
         return "/error/error-page";
     }

}
