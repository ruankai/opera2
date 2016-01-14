package com.org.opera.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IPTimeStamp {
	private SimpleDateFormat sdf;
	private String ip;

	public IPTimeStamp() {
	}

	public IPTimeStamp(String ip) {
		this.ip = ip;
	}

	public String getIPTimeStampRand() {
		StringBuffer buf = new StringBuffer();
		if (this.ip != null) {
			String s[] = this.ip.split("\\.");
			for (int x = 0; x < s.length; x++) {
				buf.append(this.addZero(s[x], 3));
			}
		}
		this.sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		buf.append(this.sdf.format(new Date()));
		Random rand = new Random();
		for (int x = 0; x < 3; x++) {
			buf.append(rand.nextInt(10)) ;
		}
		return buf.toString();
	}

	private String addZero(String str, int len) {
		StringBuffer buf = new StringBuffer();
		buf.append(str);
		while (buf.length() < len) {
			buf.insert(0, 0);
		}
		return buf.toString();
	}
/*	public static void main(String args[]){
		System.out.println(new IPTimeStamp("192.168.0.1").getIPTimeStampRand()) ;
	}*/
}
