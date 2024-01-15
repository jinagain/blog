package com.jayblog.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jayblog.domain.blogVO;
import com.jayblog.persistence.postDAO;

@Service
public class postServiceImpl implements postService {

	@Inject
	private postDAO pDAO;
	
	//Create
	public Integer create(blogVO vo) {
		return pDAO.create(vo);
	}
	//Read
	
	//LIst
	@Override
	public List<blogVO> getList() {
		return pDAO.getList();
	}

	@Override
	public blogVO read(Integer bno) {
		return pDAO.read(bno);
	}

	@Override
	public Integer update(blogVO vo) {
		return pDAO.update(vo);
	}
	
	//Update
	
	//Delete
	
	
}
