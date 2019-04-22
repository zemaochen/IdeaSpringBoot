package com.cdu.springboot.controller;

import com.cdu.springboot.domain.User;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLDecoder;

@Controller
public class FileUploadController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/registerForm")
    public String registerForm(){
        return "registerForm";
    }
    //文件上传会自动绑定到MultipartFile中
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file)throws Exception{
        System.out.println("description = "+description);
        //如果文件不为空写入上传路径
        if(!file.isEmpty()){
            String path = request.getSession().getServletContext().getRealPath("/upload");
            System.out.println("path = "+path);
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，不存在就创建一个
            if (!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //将文件保存到一个目标文件当中
            file.transferTo(new File(path+File.separator+filename));
            return "success";
        }else{
            return "error";
        }
    }


    @RequestMapping("/register")
    public String register(HttpServletRequest request, @ModelAttribute User user, Model model)throws Exception{
        System.out.println("username = "+user.getUsername());
        //如果文件不为空，写入上传路径
        if (!user.getHeadPortrait().isEmpty()){
            //上传文件路径
            String path = request.getSession().getServletContext().getRealPath("/upload/");
            System.out.println("path = "+path);
            String filename = user.getHeadPortrait().getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，不存在就创建一个
            if(!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传的文件保存到一个目标文件当中
            user.getHeadPortrait().transferTo(new File(path+File.separator+filename));
            //将用户添加到model
            model.addAttribute("user",user);
            return "userInfo";
        }else{
            return "error";
        }
    }
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           @RequestParam("User-Agent") String userAgent,
                                           Model model)throws Exception{
        //下载文件路径
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        //构建file
        File file = new File(path+File.separator+filename);
        //ok表示http中的200状态
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        //内容长度
        builder.contentLength(file.length());
        //application/octet-stream:二进制数据流（最常见的数据流）
        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        //使用URLDecoder.decode对文件进行解码
        filename = URLDecoder.decode(filename,"UTF-8");
        if (userAgent.indexOf("MSIE")>0){
            builder.header("Content-Disposition","attachment; filename="+filename);
        }else{
            builder.header("Content-Disposition","attachment; filename*=UTF-8''"+filename);
        }
        return  builder.body(FileUtils.readFileToByteArray(file));
    }
}
