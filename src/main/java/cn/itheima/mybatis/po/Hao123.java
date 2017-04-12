package cn.itheima.mybatis.po;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Hao123 {

	public static void main(String[] args) throws Exception {
		URL hao123 = new URL("http://www.hao123.com/");
		URLConnection conn = hao123.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
	}
}
