package com.xapp.jjh.xlog.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class GsonTools {

	public GsonTools() {
		
	}

	public static String createGsonString(Object object) {
		Gson gson = new Gson();
		try {
			String gsonString = gson.toJson(object);
			return gsonString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T changeGsonToBean(String gsonString, Class<T> cls) {
		Gson gson = new Gson();
		try {
			T t = gson.fromJson(gsonString, cls);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> changeGsonToList(String gsonString, Class<T> cls) {
		Gson gson = new Gson();
		try {
			List<T> list = gson.fromJson(gsonString, new TypeToken<List<T>>() {}.getType());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static <T> List<Map<String, T>> changeGsonToListMaps(
			String gsonString) {
		List<Map<String, T>> list = null;
		Gson gson = new Gson();
		try {
			list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
			}.getType());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> Map<String, T> changeGsonToMaps(String gsonString) {
		Map<String, T> map = null;
		Gson gson = new Gson();
		try {
			map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
			}.getType());
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
