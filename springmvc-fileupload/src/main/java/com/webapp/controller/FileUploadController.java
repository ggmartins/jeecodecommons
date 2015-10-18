package com.webapp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;


//import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class FileUploadController {
	
	//private static Logger log = Logger.getLogger();

    @RequestMapping(value="/upload_file", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
    	//log.info("Please use this URL for uploading files.");
        return "Please use this URL for uploading files.";
    }

    //public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
    //public @ResponseBody String handleFileUpload(MultipartHttpServletRequest request){
    
    @RequestMapping(value="/upload_file", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){

    	//http://stackoverflow.com/questions/24339990/how-to-convert-a-multipart-file-to-file
    	//log.info("You can upload a file by posting to this same URL!");
    	
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("/tmp/temp")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + file.getName() + "!";
            } catch (Exception e) {
                return "You failed to upload " + file.getName() + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getName() + " because the file was empty.";
        }

    }
    
}