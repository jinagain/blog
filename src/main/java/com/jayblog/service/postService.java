package com.jayblog.service;

import java.util.List;

import com.jayblog.domain.blogVO;

public interface postService {
	public Integer create(blogVO vo);

	public List<blogVO> getList();

	public blogVO read(Integer bno);

	public Integer update(blogVO vo);
}
