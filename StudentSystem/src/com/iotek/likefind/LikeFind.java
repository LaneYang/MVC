package com.iotek.likefind;

public class LikeFind {
//name Ҫ���ҵ��ַ���,newname ������ַ���
	public boolean likefind(String name, String newname) {
		boolean boo = false;
		for (int i = 0; i < name.length(); i++) {
			if (newname.charAt(0) == name.charAt(i)
					&& name.length() - i >= newname.length()) {
				boo = true;
				for (int j = 0;j<newname.length();j++){
					if (newname.charAt(j)!=name.charAt(i+j)){
						boo = false;
					}
				}
			}
		}
		return boo;
	}
}
