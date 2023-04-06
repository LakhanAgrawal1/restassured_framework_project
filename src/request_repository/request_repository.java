package request_repository;

import java.io.IOException;
import java.util.ArrayList;

import common_method.DataDriven;

public class request_repository {

	//post

	public static String baseURI()
	{
		String baseURI="https://reqres.in";
				return baseURI;
	}
	public static String post_resource()
	{
	String post_resource="/api/users";
	return post_resource;
	}

	public static String post_request_body() throws IOException
	{
		ArrayList<String> data = DataDriven.getDataExcel("post_data","tc_1");
		String Name=data.get(2);
		String Job=data.get(3);
		String post_req_body="{\r\n"
				+ "    \"name\": \""+Name+"\",\r\n"
				+ "    \"job\": \""+Job+"\"\r\n"
				+ "}";
		return post_req_body;
	}

	//patch 

public static String patch_resource() {
	String patch_resource="/api/users/2";
	return patch_resource;
}

public static String patch_request_body() throws IOException
{
	ArrayList<String> data = DataDriven.getDataExcel("patch_data","tc1");
	String Name=data.get(2);
	String Job=data.get(3);
	String patch_req_body="{\r\n"
			+ "    \"name\": \""+Name+"\",\r\n"
			+ "    \"job\": \""+Job+"\"\r\n"
			+ "}";
	return patch_req_body;
}

//put

public static String put_resource() {
	String patch_resource="/api/users/2";
	return patch_resource;
}

public static String put_request_body() throws IOException
{
	ArrayList<String> data = DataDriven.getDataExcel("put_data","tc1");
	String Name=data.get(2);
	String Job=data.get(3);
	String put_req_body="{\r\n"
			+ "    \"name\": \""+Name+"\",\r\n"
			+ "    \"job\": \""+Job+"\"\r\n"
			+ "}";
	return put_req_body;
}

//get

public static String get_resource() {
	String get_resource="/api/users?page=2";
	return get_resource;
}
}