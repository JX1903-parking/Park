package com.park.tools;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Repository("upFile")
public class UpFileImpl implements UpFile {
    @Override
    public boolean upfile(MultipartFile mfile, HttpServletRequest request) {
        boolean b=true;
        if(mfile.isEmpty())
        {
            System.out.println("文件为空,上传失败");
            b=false;
            return b;
        }
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        String name = mfile.getOriginalFilename();
        File f = new File(path);
        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!f.exists())
        {
            f.mkdirs();
        }
        File file=new File(path,name);
        try {
            mfile.transferTo(file);
        } catch (IOException e) {
            b=false;
        }
        return b;
    }
}
