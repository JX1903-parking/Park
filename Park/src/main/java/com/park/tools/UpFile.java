package com.park.tools;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface UpFile {

    public boolean upfile(MultipartFile mfile, HttpServletRequest request);
}
