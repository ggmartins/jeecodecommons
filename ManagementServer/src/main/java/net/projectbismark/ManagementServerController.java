package net.projectbismark;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MissingServletRequestPartException;


@Controller
public class ManagementServerController {

	@RequestMapping("/ping")
	public @ResponseBody String ping(
			@RequestHeader Map<String, String> h,  //defaultValue=""
			@RequestBody(required=false) Map<String, String> b
			) {
		System.out.println(h.toString());
		if (b != null) System.out.println(b.toString());
		return "pong";
	}
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public @ResponseBody String uploadPost(@RequestParam("file") MultipartFile file,
			@RequestHeader(required=false) Map<String, String> h,
			@RequestBody(required=false) String b,
			HttpServletRequest r)
			{
		String name="/tmp/uploadedfile.tmp";
		if (h != null) System.out.println(r.getRemoteAddr()+" "+h.toString());
		if (b != null) System.out.println(r.getRemoteAddr()+" Body not null");
		if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = 
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
	}
	
	
	@RequestMapping(value="/upload", method = RequestMethod.PUT)
	public @ResponseBody String upload(
			//@RequestParam(required=false) Map<String, String> p,
			@RequestParam(value="filename") String filename,
			@RequestParam(value="node_id") String node_id,
			@RequestParam(value="directory") String directory,
			@RequestParam(value="build_id") String build_id,
			@RequestHeader Map<String, String> h,
			@RequestBody(required=false) byte[] b,
			HttpServletRequest req,
			HttpServletResponse res)
			{
		//if (p != null) System.out.println(req.getRemoteAddr()+" "+p.toString());
		if (h != null) System.out.println(req.getRemoteAddr()+" "+h.toString());
		//if (b != null) System.out.println(req.getRemoteAddr()+" "+new String(b));

		if (node_id.matches("[A-Z]{2}[A-Z0-9]{12}"))
			System.out.println("nodeid: "+node_id+" build_id: "+build_id);
		else
			return fail(res, "Node ID.");
		
		if (!build_id.equals("git"))
			return fail(res, "Not from GIT.");
		
		if (directory.matches("[a-z0-9\\-]{3,40}"))
			System.out.println("directory: "+directory);
		else
			return fail(res, "Dir name: " + directory);
		
		String s[], file="", fileext="";
		s=filename.split("\\/(?=[^\\/]+$)");
		if (s.length == 2) file = s[1];
		s=filename.split("\\.(?=[^\\.]+$)");
		if (s.length == 2) fileext = s[1];
		
		System.out.print("file:" + file);
		System.out.print(",file ext:" + fileext);
		System.out.print(",filepath: "+filename);
		
		if(filename.equals("/tmp/bismark-uploads/" +directory + "/" + file))
		{
			System.out.println(" OK");
		}
		else return fail(res, "Unmatched "+filename+" != /tmp/bismark-uploads/" +directory + "/" + file);
			

		Date d = Calendar.getInstance().getTime();
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
	    SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd_HHmmss");
	    String date = format1.format(d);
	    String datetime = format2.format(d);
	    
	    String writepath= "/upload/bismark/"+date+"/"+node_id+"/"+directory+"/"+directory+"_"+node_id+"_"+datetime;
	    File dir = new File(writepath);
	    if (!dir.exists())
	    	dir.mkdirs();
	        
    	try {
			FileOutputStream fos = new FileOutputStream(writepath+"/"+file);
			if (b != null && b.length > 0 ) fos.write(b);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return fail(res, "WRITING FILE.");
		}	

		return "OK";
	}
	
	//https://dzone.com/articles/handling-spring-mvc-exceptions
	
	private String fail(HttpServletResponse res, String msg)
	{
		System.out.println("FAILING "+ msg);
		res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return "Error processing request."; 
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
    public @ResponseBody Map<String,String> handleMissingServletRequestParameterException(Exception  exception, HttpServletResponse response) {
		Map<String,String> errorMap = new HashMap<String,String>();
		errorMap.put("message","Missing argument");
		System.out.println("FAILING Missing Parameter");
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return errorMap;
    }
	
	@ExceptionHandler(MissingServletRequestPartException.class)
    public @ResponseBody Map<String,String> handleMissingServletRequestPartException(Exception  exception, HttpServletResponse response) {
		Map<String,String> errorMap = new HashMap<String,String>();
		errorMap.put("message","Missing argument");
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return errorMap;
    }
	
	//org.springframework.web.multipart.MultipartException
	//org.springframework.web.HttpRequestMethodNotSupportedException"
	
}
