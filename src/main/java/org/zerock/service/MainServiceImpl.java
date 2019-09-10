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
	  
	  @Override
	  public int JultMonthCount() throws Exception {
	    return dao.JultMonthCount();
	  }
	  
	  @Override
	  public int AugMonthCount() throws Exception {
	    return dao.AugMonthCount();
	  }
	  
	  @Override
	  public int SeptMonthCount() throws Exception {
	    return dao.SeptMonthCount();
	  }
	  
	  @Override
	  public int OctMonthCount() throws Exception {
	    return dao.OctMonthCount();
	  }
	  
	  @Override
	  public int NovMonthCount() throws Exception {
	    return dao.NovMonthCount();
	  }
	  
	  @Override
	  public int DecMonthCount() throws Exception {
	    return dao.DecMonthCount();
	  }
	
}
