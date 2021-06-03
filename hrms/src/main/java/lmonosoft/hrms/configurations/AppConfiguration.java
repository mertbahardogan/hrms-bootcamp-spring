package lmonosoft.hrms.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import lmonosoft.hrms.core.utilities.pictureService.PictureService;
import lmonosoft.hrms.core.utilities.pictureService.cloudinary.CloudinaryPictureManager;

@Configuration
public class AppConfiguration {

	@Bean
	public Cloudinary cloudinaryService() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dklvms3jy", "api_key", "821644786124512", "api_secret",
				"uAn8BAu7J8BjU5rhUMsByweoTY8"));
	}

	@Bean
	public PictureService pictureService() {
		return new CloudinaryPictureManager(cloudinaryService());
	}
}
