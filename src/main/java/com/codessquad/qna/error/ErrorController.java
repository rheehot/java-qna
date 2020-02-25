package com.codessquad.qna.error;

import com.codessquad.qna.common.CommonUtility;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
    @GetMapping("/user_not_found")
    public String goUserNotFoundPage() {
        return CommonUtility.ERROR_USER_NOT_FOUND;
    }

    @GetMapping("/question_not_found")
    public String goQuestionNotFoundPage() {
        return CommonUtility.ERROR_QUESTION_NOT_FOUND;
    }
}
