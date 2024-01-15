package com.jayblog.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayblog.domain.blogVO;
import com.jayblog.service.postService;

@RestController
@RequestMapping(value = "/api")
public class RestContoller {
	private static final Logger logger = LoggerFactory.getLogger(RestContoller.class);
	
	@Inject
	private postService pService;
	
	@PostMapping(value = "/posts")
	public ResponseEntity<Integer> create(@RequestBody blogVO vo) {
		logger.info("RC : create");
		logger.info(vo.toString());
		ResponseEntity<Integer> respEntity = null;
		Integer bno = pService.create(vo);
		if(bno > 0) {
			respEntity = new ResponseEntity<Integer>(bno, HttpStatus.OK);
		}else {
			respEntity = new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);				
		}
		return respEntity;
	}
	@PutMapping(value = "/posts")
	public ResponseEntity<Integer> update(@RequestBody blogVO vo) {
		logger.info("RC : update");
		logger.info(vo.toString());
		ResponseEntity<Integer> respEntity = null;
		Integer result = pService.update(vo);
		if(result > 0) {
			respEntity = new ResponseEntity<Integer>(HttpStatus.OK);
		}else {
			respEntity = new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);				
		}
		return respEntity;
	}
	
	@GetMapping(value = "/posts")
	public ResponseEntity<List<blogVO>> list() {
		logger.info("RC : list");
		ResponseEntity<List<blogVO>> respEntity = null;
		List<blogVO> list = pService.getList();
		logger.info("RC : listSize = " + list.size());
		logger.info(list.toString());
//		if(list.size() > 1) {
			respEntity = new ResponseEntity<List<blogVO>>(list, HttpStatus.OK);
//		}else {
//			respEntity = new ResponseEntity<List<blogVO>>(HttpStatus.INTERNAL_SERVER_ERROR);				
//		}
		return respEntity;
	}
	
	@GetMapping(value = "/posts/{bno}")
	public ResponseEntity<blogVO> read(@PathVariable (name = "bno") Integer bno) {
		logger.info("RC : read" + bno);
		blogVO vo = pService.read(bno);
		ResponseEntity<blogVO> respEntity = null;
		if(vo != null) {
			respEntity = new ResponseEntity<blogVO>(vo, HttpStatus.OK);
		}else {
			respEntity = new ResponseEntity<blogVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respEntity;
	}

}
