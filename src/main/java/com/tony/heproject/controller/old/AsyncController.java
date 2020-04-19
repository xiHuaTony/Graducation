package com.tony.heproject.controller.old;
import com.tony.heproject.service.AsyncService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RestController
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/connect")
    public String submit() {
        asyncService.executeAsync();
        return "success";
    }
}