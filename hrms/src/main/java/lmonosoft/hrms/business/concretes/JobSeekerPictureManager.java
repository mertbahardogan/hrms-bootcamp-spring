package lmonosoft.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lmonosoft.hrms.business.abstracts.JobSeekerPictureService;
import lmonosoft.hrms.core.utilities.pictureService.PictureService;
import lmonosoft.hrms.core.utilities.results.DataResult;
import lmonosoft.hrms.core.utilities.results.Result;
import lmonosoft.hrms.core.utilities.results.SuccessDataResult;
import lmonosoft.hrms.core.utilities.results.SuccessResult;
import lmonosoft.hrms.dataAccess.abstracts.JobSeekerPictureDao;
import lmonosoft.hrms.entities.concretes.JobSeekerPicture;
import lmonosoft.hrms.entities.concretes.JobSeekerSkill;
import net.bytebuddy.asm.Advice.This;

@Service
public class JobSeekerPictureManager implements JobSeekerPictureService {

	private JobSeekerPictureDao seekerPictureDao;
	private PictureService pictureService;

	@Autowired
	public JobSeekerPictureManager(JobSeekerPictureDao seekerPictureDao, PictureService pictureService) {
		super();
		this.seekerPictureDao = seekerPictureDao;
		this.pictureService = pictureService;
	}

	@Override
	public Result add(JobSeekerPicture jobSeekerPicture) {
		this.seekerPictureDao.save(jobSeekerPicture);
		return new SuccessResult();

	}

	@Override
	public Result add(JobSeekerPicture jobSeekerPicture, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) pictureService.save(file).getData();
		String url = result.get("url");
		jobSeekerPicture.setUrl(url);
		jobSeekerPicture.setUploadedDate(LocalDate.now());
		return add(jobSeekerPicture);
	}

	@Override
	public DataResult<List<JobSeekerPicture>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<>(this.seekerPictureDao.getAllByJobSeekerId(jobSeekerId));
	}

	@Override
	public DataResult<List<JobSeekerPicture>> getAll() {
		return new SuccessDataResult<>(this.seekerPictureDao.findAll());
	}

}
