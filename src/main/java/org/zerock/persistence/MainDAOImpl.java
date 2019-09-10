package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

@Repository
public class MainDAOImpl implements MainDAO {
	  @Inject
	  private SqlSession session;
	  
	  private static String namespace = "org.zerock.mapper.MainMapper";
	  
	  @Override
	  public List<BoardVO> Mainlist() throws Exception {
	    return session.selectList(namespace + ".Mainlist");
	  }
	  
	  @Override
	  public int TodayCount() throws Exception {

	    return session.selectOne(namespace + ".TodayCount");
	  
	  }
	  
	  
	  @Override
	  public int MonthCount() throws Exception {

	    return session.selectOne(namespace + ".MonthCount");
	  
	  }
	  
	  @Override
	  public int JultMonthCount() throws Exception {

	    return session.selectOne(namespace + ".JultMonthCount");
	  
	  }
	  @Override
	  public int AugMonthCount() throws Exception {

	    return session.selectOne(namespace + ".AugMonthCount");
	  
	  }
	  
	  @Override
	  public int SeptMonthCount() throws Exception {

	    return session.selectOne(namespace + ".SeptMonthCount");
	  
	  }
	  @Override
	  public int OctMonthCount() throws Exception {

	    return session.selectOne(namespace + ".OctMonthCount");
	  
	  }
	  @Override
	  public int NovMonthCount() throws Exception {

	    return session.selectOne(namespace + ".NovMonthCount");
	  
	  }
	  
	  @Override
	  public int DecMonthCount() throws Exception {

	    return session.selectOne(namespace + ".DecMonthCount");
	  
	  }
	  
	  
	  
	
	  
}
