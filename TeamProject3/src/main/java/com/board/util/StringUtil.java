package com.board.util;

//�۳��뺸�� -><textarea><pre><%=content%></pre></textarea>
public class StringUtil {
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		
		return msg.replace("\r\n", "<br>")
                         .replace("\n", "<br>");
	}
}
