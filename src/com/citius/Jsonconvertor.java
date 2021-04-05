package com.citius;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Jsonconvertor {
	public String convertToJson(Object object) {
		String jsonString="";
		try {
			if (Objects.isNull(object)) {
				throw new RuntimeException();
			}
			Class clazz = object.getClass();
//			for (Method method : clazz.getDeclaredMethods()) {
//				if(method.isAnnotationPresent(annotationClass))
//			}
			Map<String, String> jsonElementsMap = new HashMap<>();
			for (Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(JsonElement.class)) {
					jsonElementsMap.put(getKey(field), (String) field.get(object));
				}
			}
			jsonString = jsonElementsMap.entrySet().stream()
					.map(entry1 -> "\"" + entry1.getKey() + "\":\"" + entry1.getValue() + "\"")
					.collect(Collectors.joining(","));
			return "{" + jsonString + "}";
		} catch (Exception e) {
//			e.prin
		}
		return jsonString;
	}

	private String getKey(Field field) {
		String value = field.getAnnotation(JsonElement.class).key();
		return value.isEmpty() ? field.getName() : value;
	}
}
