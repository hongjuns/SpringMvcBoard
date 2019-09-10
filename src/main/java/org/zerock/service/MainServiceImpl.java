package org.zerock.service;

import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;
import org.zerock.persistence.MainDAO;
@Service
public class MainServiceImpl implements MainService {
	
	  @Inject
	  private MainDAO dao;

	  @Override
	  public List<BoardVO> Mainlist() throws Exception {

	    return dao.Mainlist();
	  }

	  @Override
	  public int TodayCount() throws Exception {
	    return dao.TodayCount();
	  }
	  
	  @Override
	  public int MonthCount() throws Exception {
	    return dao.MonthCount();
	  }

}
