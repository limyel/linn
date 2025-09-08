package com.linn.blog.controller.api;

import com.lyxh.linn.common.core.pojo.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public R<?> testGet() {
        return R.ok();
    }

}
