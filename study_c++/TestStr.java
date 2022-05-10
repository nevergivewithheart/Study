package testStr;
/*
 * 测试字符串的拆、截、格式化
 * 考虑到该操作的实际结合字符串的查找进行试验
 */
public class TestStr {
	public static void main(String[] args) {
		
		/*
		 * 字符串查找
		 * 存在查找、从头（尾部）进行索引查找、从指定位置开始向前（向后）查找
		 * 判断字符串的结构：判断字符串开头（结尾）是否是指定的字符串
		 * 从指定位置判断该位置是否为指定字符串
		 */
		//测试字符串的查找
		/*String se="张三";
		String s1="name:";
		String s2="贷款";
		String s3="一座房子；";
		String str="name:张三；num:15674134561；status:张贷款；properties:一座房子；";
		//判断是否存在
		System.out.println(str.contains("贷款")? "有负债":"无负债");
		//从头查找，返回该查找目的字符串的首字符在源字符串的索引
		System.out.println((str.indexOf(se)==-1)? "NoFound":se+"在"+str.indexOf(se)+"位置");
		//从指定索引位置开始向后（顺序）查找,如若没有找到任然返回-1
		System.out.println(str.indexOf(s2, 18));
		//由后向前查找返回的任然是正常的索引值（顺寻的）
		System.out.println(str.lastIndexOf(se));
		//从指定索引位置向前（倒序）查找,如若没有找到任然返回-1
		System.out.println(str.lastIndexOf(se, 39));
		//判断是否以指定的字符串开始
		System.out.println(str.startsWith(s1)? "是以指定的“"+s1+"”开头":"格式错误");
		//判断是否以指定的字符串结尾
		System.out.println(str.endsWith(s3)? "该字符串是以“"+s3+"”为结尾":"格式错误");
		//判断指定的索引位置处是否为指定的字符串(从指定索引的位置处开始[包括])
		System.out.println(str.startsWith(se, 5)? "格式正确":"Form Error");
		*/
		/*
		 * 字符串的解析
		 * 以指定的字符串作为间隔进行拆分（可按间隔拆为指定的个数）、带转义字符的间隔、字符串的截取
		 * 
		 */
		//测试split（）方式拆分字符串
		/*String str="joke math name mike	like	jisgn jgnasikojg";
		String result[]=str.split(" ");
		for(int i=0;i<(result.length);i++)
		{
			System.out.println("第"+(i+1)+"是"+result[i]);
		}*/
		//测试split()
		/*String str="joke math name mike likjisgn jgnasikojg";
		String result[]=str.split(" ",4);
		for(int i=0;i<(result.length);i++)
		{
			System.out.println("第"+i+"是"+result[i]);
		}*/
		//测试转义字符//的使用
		/*String str="192.168.77.88";
		String result[]=str.split("\\.");
		for(int i=0;i<(result.length);i++)
		{
			System.out.println("第"+(i+1)+"是"+result[i]);
		}*/
		//测试字符串的截取
		/*String str="joke math name mike	likejisgnjgnasikojg";
		System.out.println(str.substring(0));
		//是使用数组的索引方式，从0开始，截取方式（从当前字符开始到最后）
		System.out.println(str.substring(0,20));
		//截取两索引之间的内容
		 */		
		//解析格式化的图片命名字符串
		String str="mdn-photo-张三.jpg";
		//str.indexOf("-", str.indexOf("photo"))   参数形式（字符串，索引）
		//从指定的索引处开始查找
		int beginnu=str.indexOf("-",str.indexOf("photo") )+1;
		//System.out.println(beginnu);
		int endnu=str.indexOf(".");
		System.out.println(str.substring(beginnu, endnu));
		
		
		/*
		 *字符串格式化
		 * 
		 */
		String manname="唐三";
		String womanname="小舞";
		int age=28;
		String eve="结婚";
		String say=String.format("男主：%s、女主：%s 年龄全部：%d  现在需要：%s",manname,womanname,age,eve);
		System.out.println(say);
	}
}
