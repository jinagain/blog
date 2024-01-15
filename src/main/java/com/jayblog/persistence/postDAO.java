package com.jayblog.persistence;

import java.util.List;

import com.jayblog.domain.blogVO;

public interface postDAO {

	Integer create(blogVO vo);

	List<blogVO> getList();

	blogVO read(Integer bno);

	Integer update(blogVO vo);

}
