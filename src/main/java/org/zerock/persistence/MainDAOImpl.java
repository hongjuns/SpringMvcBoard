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
	  
	  
	  
	
	  
}
