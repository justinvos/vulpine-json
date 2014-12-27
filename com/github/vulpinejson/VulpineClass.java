package com.github.vulpinejson;

import java.util.ArrayList;

public class VulpineClass
{
	private ArrayList<VulpineElement> elementList;

	public VulpineClass()
	{
		this.elementList = new ArrayList<VulpineElement>();
	}

	public VulpineClass(ArrayList<VulpineElement> elementList)
	{
		this.elementList = elementList;
	}

	public ArrayList<VulpineElement> getValue()
	{
		return elementList;
	}

	public String encode()
	{
		String jsonStr = "{";

		for(int i = 0; i < elementList.size(); i++)
		{
			jsonStr = jsonStr + elementList.get(i).encode() + ", ";
		}

		jsonStr = jsonStr.substring(0, jsonStr.length() - 2) + "}";

		return jsonStr;
	}

	public VulpineElement get(String key)
	{
		for(int i = 0; i < elementList.size(); i++)
		{
			if(elementList.get(i).getKey().equals(key))
			{
				return elementList.get(i);
			}
		}
		
		return null;
	}

	public boolean contains(VulpineElement element)
	{
		for(int i = 0; i < elementList.size(); i++)
		{
			if(elementList.get(i).getKey().equals(element.getKey()))
			{
				return true;
			}
		}
		return false;
	}

	public void put(VulpineElement element)
	{
		if(!contains(element))
		{
			elementList.add(element);
		}
	}

	public String[] getKeyArray()
	{
		String[] strArray = new String[elementList.size()];

		for(int i = 0; i < elementList.size(); i++)
		{
			strArray[i] = elementList.get(i).getKey();
		}
		return strArray;
	}

	public static VulpineClass parse(String jsonStr)
	{
		return VulpineJSON.parseClass(jsonStr);
	}
}