package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Pjt;


public interface PjtMapper {
	public List<Pjt> getPjtList(); //회사 상관없이 다 불러오기

	public void insertCo(Pjt pjt);

	public Pjt getPjt(int coCd);

	public List<Pjt> getPjtList(int coCd); //특정 회사만 불러오기

	public void deletePjt(int coCd);

	public void updatePjt(Pjt pjt);
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