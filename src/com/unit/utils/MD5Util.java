package com.unit.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
	/**
	 * 采用MD5算法对字符串加密
	 * @param s 字符串
	 * @return  加密后的字符串信息
	 */
	public static String md5(String s){
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] input=s.getBytes();
			byte[] output=md.digest(input); //md5处理
			//将output转成字符串,采用Base64算法
			//return new String(output);    乱码
			String str= Base64.encodeBase64String(output);
			return str;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(md5("123456"));
	}
}
