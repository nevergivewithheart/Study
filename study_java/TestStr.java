package testStr;
/*
 * �����ַ����Ĳ𡢽ء���ʽ��
 * ���ǵ��ò�����ʵ�ʽ���ַ����Ĳ��ҽ�������
 */
public class TestStr {
	public static void main(String[] args) {
		
		/*
		 * �ַ�������
		 * ���ڲ��ҡ���ͷ��β���������������ҡ���ָ��λ�ÿ�ʼ��ǰ����󣩲���
		 * �ж��ַ����Ľṹ���ж��ַ�����ͷ����β���Ƿ���ָ�����ַ���
		 * ��ָ��λ���жϸ�λ���Ƿ�Ϊָ���ַ���
		 */
		//�����ַ����Ĳ���
		/*String se="����";
		String s1="name:";
		String s2="����";
		String s3="һ�����ӣ�";
		String str="name:������num:15674134561��status:�Ŵ��properties:һ�����ӣ�";
		//�ж��Ƿ����
		System.out.println(str.contains("����")? "�и�ծ":"�޸�ծ");
		//��ͷ���ң����ظò���Ŀ���ַ��������ַ���Դ�ַ���������
		System.out.println((str.indexOf(se)==-1)? "NoFound":se+"��"+str.indexOf(se)+"λ��");
		//��ָ������λ�ÿ�ʼ���˳�򣩲���,����û���ҵ���Ȼ����-1
		System.out.println(str.indexOf(s2, 18));
		//�ɺ���ǰ���ҷ��ص���Ȼ������������ֵ��˳Ѱ�ģ�
		System.out.println(str.lastIndexOf(se));
		//��ָ������λ����ǰ�����򣩲���,����û���ҵ���Ȼ����-1
		System.out.println(str.lastIndexOf(se, 39));
		//�ж��Ƿ���ָ�����ַ�����ʼ
		System.out.println(str.startsWith(s1)? "����ָ���ġ�"+s1+"����ͷ":"��ʽ����");
		//�ж��Ƿ���ָ�����ַ�����β
		System.out.println(str.endsWith(s3)? "���ַ������ԡ�"+s3+"��Ϊ��β":"��ʽ����");
		//�ж�ָ��������λ�ô��Ƿ�Ϊָ�����ַ���(��ָ��������λ�ô���ʼ[����])
		System.out.println(str.startsWith(se, 5)? "��ʽ��ȷ":"Form Error");
		*/
		/*
		 * �ַ����Ľ���
		 * ��ָ�����ַ�����Ϊ������в�֣��ɰ������Ϊָ���ĸ���������ת���ַ��ļ�����ַ����Ľ�ȡ
		 * 
		 */
		//����split������ʽ����ַ���
		/*String str="joke math name mike	like	jisgn jgnasikojg";
		String result[]=str.split(" ");
		for(int i=0;i<(result.length);i++)
		{
			System.out.println("��"+(i+1)+"��"+result[i]);
		}*/
		//����split()
		/*String str="joke math name mike likjisgn jgnasikojg";
		String result[]=str.split(" ",4);
		for(int i=0;i<(result.length);i++)
		{
			System.out.println("��"+i+"��"+result[i]);
		}*/
		//����ת���ַ�//��ʹ��
		/*String str="192.168.77.88";
		String result[]=str.split("\\.");
		for(int i=0;i<(result.length);i++)
		{
			System.out.println("��"+(i+1)+"��"+result[i]);
		}*/
		//�����ַ����Ľ�ȡ
		/*String str="joke math name mike	likejisgnjgnasikojg";
		System.out.println(str.substring(0));
		//��ʹ�������������ʽ����0��ʼ����ȡ��ʽ���ӵ�ǰ�ַ���ʼ�����
		System.out.println(str.substring(0,20));
		//��ȡ������֮�������
		 */		
		//������ʽ����ͼƬ�����ַ���
		String str="mdn-photo-����.jpg";
		//str.indexOf("-", str.indexOf("photo"))   ������ʽ���ַ�����������
		//��ָ������������ʼ����
		int beginnu=str.indexOf("-",str.indexOf("photo") )+1;
		//System.out.println(beginnu);
		int endnu=str.indexOf(".");
		System.out.println(str.substring(beginnu, endnu));
		
		
		/*
		 *�ַ�����ʽ��
		 * 
		 */
		String manname="����";
		String womanname="С��";
		int age=28;
		String eve="���";
		String say=String.format("������%s��Ů����%s ����ȫ����%d  ������Ҫ��%s",manname,womanname,age,eve);
		System.out.println(say);
	}
}
