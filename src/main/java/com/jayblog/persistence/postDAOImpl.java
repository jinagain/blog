package com.jayblog.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jayblog.domain.blogVO;

@Repository
public class postDAOImpl implements postDAO {
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.jayblog.mapper.PostMapper";

	private static final Logger logger = LoggerFactory.getLogger(postDAOImpl.class);

	@Override
	public Integer create(blogVO vo) {
		sqlSession.insert(NAMESPACE + ".createPost", vo);
		return sqlSession.selectOne(NAMESPACE + ".getPostCount");
	}

	@Override
	public List<blogVO> getList() {
		return sqlSession.selectList(NAMESPACE + ".getPostList");
	}

	@Override
	public blogVO read(Integer bno) {
		return sqlSession.selectOne(NAMESPACE + ".readPost", bno);
	}

	@Override
	public Integer update(blogVO vo) {
		return sqlSession.update(NAMESPACE + ".updatePost", vo);
	}
}
