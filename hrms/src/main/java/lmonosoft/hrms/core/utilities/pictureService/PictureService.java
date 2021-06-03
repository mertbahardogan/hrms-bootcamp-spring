package lmonosoft.hrms.core.utilities.pictureService;

import org.springframework.web.multipart.MultipartFile;

import lmonosoft.hrms.core.utilities.results.DataResult;

public interface PictureService {
	DataResult<?> save(MultipartFile file);

}
