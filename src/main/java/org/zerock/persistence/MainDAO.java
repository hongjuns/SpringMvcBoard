package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

public interface MainDAO {

	  public int TodayCount() throws Exception;
	  public int MonthCount()throws Exception;
	  public int JultMonthCount()throws Exception;
	  public int AugMonthCount()throws Exception;
	  public int SeptMonthCount()throws Exception;
	  public int OctMonthCount()throws Exception;
	  public int NovMonthCount()throws Exception;
	  public int DecMonthCount()throws Exception;
	  public List<BoardVO> Mainlist()throws Exception;
	  
}
