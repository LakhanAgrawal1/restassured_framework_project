package common_method;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Common_method {

	//post

	public static int post_status_code_extractor(String baseURI,String post_resource,String post_req_body )
	{
		RestAssured.baseURI=baseURI;
		int post_status_code=given().header("Content-Type", "application/json").body(post_req_body).when()
				.post(post_resource).then().extract().statusCode();
		return post_status_code;
	}

	public static String post_response_body_extractor(String baseURI,String post_resource,String post_req_body)
	{

		RestAssured.baseURI=baseURI;
		String post_response_body=given().header("Content-Type", "application/json").body(post_req_body).when()
				.post(post_resource).then().extract().response().asString();
		return post_response_body;
			}

	//patch

	public static int patch_status_code_extractor(String baseURI,String patch_resource,String patch_req_body)
	{
		RestAssured.baseURI=baseURI;
				int patch_status_code=given().header("Content-Type", "application/json").body(patch_req_body)
						.when().patch(patch_resource).then().extract().statusCode();
				return patch_status_code;
	}

	public static String patch_response_body_extractor(String baseURI,String patch_resource,String patch_req_body)
			{
		RestAssured.baseURI=baseURI;

		String patch_response_body=given().header("Content-Type", "application/json").body(patch_req_body).when()
				.post(patch_resource).then().extract().response().asString();
		return patch_response_body;

			}

	//put


		public static int put_status_code_extractor(String baseURI,String put_resource,String put_req_body)
		{
			RestAssured.baseURI=baseURI;
					int put_status_code=given().header("Content-Type", "application/json").body(put_req_body)
							.when().patch(put_resource).then().extract().statusCode();
					return put_status_code;
		}

		public static String put_response_body_extractor(String baseURI,String put_resource,String put_req_body)
				{
			RestAssured.baseURI=baseURI;

			String put_response_body=given().header("Content-Type", "application/json").body(put_req_body).when()
					.post(put_resource).then().extract().response().asString();
			return put_response_body;

				}

		//get
		public static int get_status_code_extractor(String baseURI,String get_resource)
		{
			RestAssured.baseURI=baseURI;
					int get_status_code=given().header("Content-Type", "application/json")
							.when().get(get_resource).then().extract().statusCode();
					return get_status_code;
		}

		public static String get_response_body_extractor(String baseURI,String get_resource)
		{
	RestAssured.baseURI=baseURI;

	String put_response_body=given().header("Content-Type", "application/json").when()
			.get(get_resource).then().extract().response().asString();
	return put_response_body;

		}


}