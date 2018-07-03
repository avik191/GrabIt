package com.FileUploads;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "F:\\eclipse-workspace\\GrabIt\\Grab-It\\WebContent\\WEB-INF\\resources\\images\\";
	private static String REAL_PATH = null;
	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code) 
	{				
		// get the real server path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/images/");
		
		
		
		if(!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		
		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		
		try {
			//transfer the file to both the location
			file.transferTo(new File(REAL_PATH + code + ".png"));
			file.transferTo(new File(ABS_PATH + code + ".png"));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return true;
	}
}
