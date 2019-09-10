package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface MainService {
	
	  public List<BoardVO> Mainlist() throws Exception;

	  public int TodayCount() throws Exception;
	  
	  public int MonthCount() throws Exception;

}
