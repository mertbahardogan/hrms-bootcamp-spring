package lmonosoft.hrms.core.utilities.pictureService.cloudinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import lmonosoft.hrms.core.utilities.pictureService.PictureService;
import lmonosoft.hrms.core.utilities.results.*;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.util.Map;

public class CloudinaryPictureManager implements PictureService {

	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryPictureManager(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}

	@Override
	public DataResult<Map> save(MultipartFile file) {
		try {
			Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			;
			return new SuccessDataResult<Map>(uploadResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}

}
