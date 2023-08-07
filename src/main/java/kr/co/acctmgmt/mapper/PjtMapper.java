package kr.co.acctmgmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.acctmgmt.domain.Pjt;


public interface PjtMapper {
	public List<Pjt> getPjtList(); //ȸ�� ������� �� �ҷ�����

	public void insertPjt(Pjt pjt);

	public Pjt getPjt(int coCd);
	
	public Pjt getSelPjt(@Param("coCd") int coCd, @Param("pjtCd") String pjtCd);

	public List<Pjt> getPjtList(int coCd); //Ư�� ȸ�縸 �ҷ�����

	public void deletePjt(int coCd);

	public void updatePjt(Pjt pjt, int coCd);
	
	public List<Pjt> getSelPjtList(@Param("pjtCd") String pjtCd, @Param("coCd") int coCd);
}

//������Ʈ�ڵ�
//������Ʈ ���� : 1. ������
// ������Ʈ ��: 
// ������Ʈ ��Ī
//������Ʈ �з�: 2000, �񿵸�(�׷��ڵ�, ��)
// ������ ���� : �̰� ��� ����;��ұ� �ƴ� ���̺� �ٽ� ��������?
// ������Ʈ �Ⱓ : :
// ������Ʈ ������
// ���