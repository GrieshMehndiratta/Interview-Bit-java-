public class Solution 
{

	public String reverseWords(String a) 
	{

	    int i=0;

	    String[] temp=a.split(" ");

	    String str= "";

	    for(i=temp.length-1;i>0;i--)

	    str=str+temp[i]+" ";

	    str=str+temp[i];

	    return str;
	
	}


}
