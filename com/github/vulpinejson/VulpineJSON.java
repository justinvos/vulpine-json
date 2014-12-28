package com.github.vulpinejson;

public class VulpineJSON
{

	protected static boolean isClass(String str)
	{
		return (str.startsWith("{") && str.endsWith("}"));
	}

	protected static String trimQuotes(String str)
	{
		str.trim();

		if(str.startsWith("\"") && str.endsWith("\""))
		{
			str = str.substring(1, str.length() - 1);
		}
		return str;
	}

	/*

	The main method is used purely for debuging test cases.

	--- Do not use the main method in your implementation. --

	*/

	public static void main(String[] args)
	{
		VulpineElement str = VulpineElement.parse("\"Name\" : \"Justin\" ");

		JSONObject jsonObj = JSONObject.parse("{\"Name\" : \"Justin\", \"Race\" : \"European\"}");

		System.out.println(jsonObj.getKeyArray()[1]);

		System.out.println("Name");
		System.out.println(jsonObj.get("Name").getValue());
		System.out.println(jsonObj.get("Race").getValue());

		System.out.println();
		System.out.println(jsonObj.encode());

		System.out.println();

		JSONObject jsonObj2 = new JSONObject();

		jsonObj2.put(new VulpineElement(new JSONString("Job"), new JSONObject()));

		System.out.println(jsonObj2.encode());
	}
} 