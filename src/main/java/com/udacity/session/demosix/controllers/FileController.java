package com.udacity.session.demosix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fileupload")
public class FileController {

    @GetMapping
    public String viewFielUpload(){
        return "fileupload";
    }
}
