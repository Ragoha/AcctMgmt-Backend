package kr.co.acctmgmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Pjt;

public interface PjtMapper {
	public List<Pjt> getPjtList(); // 회占쏙옙 占쏙옙占쏙옙占쏙옙占� 占쏙옙 占쌀뤄옙占쏙옙占쏙옙

	public void insertPjt(@Param("pjt") Pjt pjt, @Param("coCd") int coCd);

	public Pjt getPjt(int coCd);

	public Pjt getSelPjt(@Param("coCd") int coCd, @Param("pjtCd") String pjtCd);

	public List<Pjt> getPjtList(int coCd); // 특占쏙옙 회占썹만 占쌀뤄옙占쏙옙占쏙옙

	public void deletePjt(@Param("pjt") Pjt pjt);

	public void updatePjt(@Param("pjt") Pjt pjt, @Param("coCd") int coCd);

	public List<Pjt> getSelPjtList(@Param("pjtCd") String pjtCd, @Param("coCd") int coCd);
	
	public List<Pjt> getPjtBy(@Param("keyword")String keyword, @Param("coCd")int coCd);

	public Pjt getPgrBy(String keyword, int coCd);
	
	public List<Pjt> selPjtBy(@Param("pjt") Pjt pjt);
	
	public List<Pjt> findPjtByCoCdAndKeyword(Pjt pjt);
}

//占쏙옙占쏙옙占쏙옙트占쌘듸옙
//占쏙옙占쏙옙占쏙옙트 占쏙옙占쏙옙 : 1. 占쏙옙占쏙옙占쏙옙
// 占쏙옙占쏙옙占쏙옙트 占쏙옙: 
// 占쏙옙占쏙옙占쏙옙트 占쏙옙칭
//占쏙옙占쏙옙占쏙옙트 占싻뤄옙: 2000, 占쏟영몌옙(占쌓뤄옙占쌘듸옙, 占쏙옙)
// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 : 占싱곤옙 占쏙옙占� 占쏙옙占쏙옙槁占쏙옙耐占� 占싣댐옙 占쏙옙占싱븝옙 占쌕쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙?
// 占쏙옙占쏙옙占쏙옙트 占썩간 : :
// 占쏙옙占쏙옙占쏙옙트 占쏙옙占쏙옙占쏙옙
// 占쏙옙占�