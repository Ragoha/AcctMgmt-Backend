package kr.co.acctmgmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Pjt;


public interface PjtMapper {
	public List<Pjt> getPjtList(); //회사 상관없이 다 불러오기

	public void insertPjt(@Param("pjt") Pjt pjt, @Param("coCd") int coCd);

	public Pjt getPjt(int coCd);
	
	public Pjt getSelPjt(@Param("coCd") int coCd, @Param("pjtCd") String pjtCd);

	public List<Pjt> getPjtList(int coCd); //특정 회사만 불러오기

	public void deletePjt(@Param("pjt") Pjt pjt);

	public void updatePjt(@Param("pjt") Pjt pjt, @Param("coCd") int coCd);
	
	public List<Pjt> getSelPjtList(@Param("pjtCd") String pjtCd, @Param("coCd") int coCd);
}

//프로젝트코드
//프로젝트 구분 : 1. 진행중
// 프로젝트 명: 
// 프로젝트 약칭
//프로젝트 분류: 2000, 비영리(그룹코드, 명)
// 사용권한 설정 : 이건 어디서 갖고와야할까 아니 테이블 다시 만들어야함?
// 프로젝트 기간 : :
// 프로젝트 시작일
// 비고