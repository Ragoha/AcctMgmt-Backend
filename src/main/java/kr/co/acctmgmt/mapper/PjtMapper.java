package kr.co.acctmgmt.mapper;

import java.util.List;

import kr.co.acctmgmt.domain.Pjt;


public interface PjtMapper {
	public List<Pjt> getPjtList(); //ȸ�� ������� �� �ҷ�����

	public void insertCo(Pjt pjt);

	public Pjt getPjt(int coCd);

	public List<Pjt> getPjtList(int coCd); //Ư�� ȸ�縸 �ҷ�����

	public void deletePjt(int coCd);

	public void updatePjt(Pjt pjt);
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