package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Tools implements Serializable{
	private transient Scanner in=new Scanner(System.in);

public Tools(){}
public String indentString(String str, int size, char fill){
//	if(str==null){return }
	if (str==null){
		str="null";
	}
	if(str.length()>size&&size>6){
		str=str.substring(0, size-6);
		str+="...";
	}
		String out="";
		while(str.length()<size){
			str+=fill;
		}
		while(str.length()!=size){
			str = str.substring(0,str.length()-2);
		}
		return str;
	}

public String indentString(String str, int size, String fill){
	if(str.length()>size&&size>6){
		str=str.substring(0, size-6);
		str+="...";
	}
		String out="";
		while(str.length()<size){
			str+=fill;
		}
		return str;
	}
public String centreString(String str, int size){
	if(str.length()>size&&size>6){
		str=str.substring(0, size-6);
		str+="...";
	}
	int mid=size/2;
	int midStr=str.length()/2;
	StringBuilder out = new StringBuilder();
	out.append(indentString("", mid-midStr-1,' '));
	out.append(str);
	out.append(indentString("", mid-midStr,' '));
	
	return out.toString();
	
}
public String beRightString(String str, int size){
	if(str.length()>size&&size>6){
		str=str.substring(0, size-6);
		str+="...";
	}
	StringBuilder out=new StringBuilder();
	out.append(indentString("",size-str.length(),' '));
	out.append(str);
	return out.toString();
}

public String wrapString(String str, int width){
	int i=0;
	boolean ignore=false;
	String output="";
	String symbols = "\\\"[{'(";
	for(String s :str.split(" ")){

		if (s.length()>width-i%width-1){
			if(width-i%width-1==0||symbols.contains(s.substring(0, 1))){
			s = new StringBuilder(s).insert(width-i%width-1, " ").toString();
		}

			else
			{
			s = new StringBuilder(s).insert(width-i%width-1, "-").toString();}
		}

		for (String w:s.split("")){
			i++;
			output+=w;
			if(i%width==0){

				if(ignore){
					i++;
					output+=" ";
					ignore=false;
				}else{
				output+="\n";
			}}
		}
		i++;
		if(i%width==1){
			i--;
			ignore=true;
		}else{
			output+=" ";
		}
		if(i%width==0){
			if(ignore){
				i++;
				output+=" ";
				ignore=false;
			}else{
		    output+="\n";
		}}
	}
	String fin = output.replaceAll("\n", "");
	while(fin.length()%width!=0){
		fin+=" ";
		output+=" ";
	}
	return output;
}

public String twoSidedString(String str1,String str2, int size){
	String out="";
	int space;
	int size1=str1.length(), size2=str2.length();
	if (size1>size||size2>size||size2+size1>size){
		return "too long.";
	}else{
	 space = size-size1-size2;
	}
	out += str1;
	for(int i=0;i<space;i++){
		out+=" ";
	}
	out += str2;
	return out;
}


public static void main(String args[]){
	Tools tool= new Tools();
//	System.out.print(tool.cutAString("Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or", 15));
	String s=tool.centreString("afdsfd ffferwgergergreqgqrqeeaf", 20)+"|";
	System.out.println(s);
	String f=tool.beRightString("vfdbshtrwhthtewreerregergre", 10)+"|";
	System.out.println(f);
	f=tool.indentString("dsvregrgregrac", 10,  ' ')+"|";
	System.out.println(f);
	System.out.println(tool.wrapString("A novel is any relatively long"
					+ " piece of written narrative fiction, normally in prose,"
					+ " and typically published as a book.The genre has also been descri"
					+ "bed as possessing, \"a continuous and comprehensive history of a"
					+ "bout two thousand years\".[1] This view sees the novel's origins "
					+ "in Classical Greece and Rome, medieval, early modern romance, and"
					+ " the tradition of the novella. The latter, an Italian word used to"
					+ " describe short stories, supplied the present generic English term"
					+ " in the 18th century. Ian Watt, however, in The Rise of the Novel "
					+ "(1957) suggests that the novel first came into being in the early "
					+ "18th century,Miguel de Cervantes, author of Don Quixote, is frequen"
					+ "tly cited as the first significant European novelist of the modern "
					+ "era; the first part of Don Quixote was published in 1605.[2]The r"
					+ "omance is a closely related long prose narrative. Walter Scott defi"
					+ "ned it as \"a fictitious narrative in prose or verse; the interest o"
					+ "f which turns upon marvellous and uncommon incidents\", whereas in the"
					+ " novel \"the events are accommodated to the ordinary train of human ev"
					+ "ents and the modern state of society\".[3] However, many romances, in"
					+ "cluding the historical romances of Scott,[4] Emily Brontë's Wuthering "
					+ "Heights[5] and Herman Melville's Moby-Dick,[6] are also frequently cal"
					+ "led novels, and Scott describes romance as a \"kindred term\". Romance"
					+ ", as defined here, should not be confused with the genre fiction love  ",
					50));
	System.out.println(tool.centreString("       Good morning..de	de        ", 30));
	System.out.println(tool.twoSidedString("wfweqfwfe",".  .", 50));
}

}
