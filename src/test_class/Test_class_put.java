package test_class;



import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.Common_method;
import io.restassured.path.json.JsonPath;
import request_repository.request_repository;

public class Test_class_put {
	@Test

	public static void orchestractor() throws IOException
	{
		String baseURI=request_repository.baseURI();
		String put_resource=request_repository.put_resource();
		String put_request_body=request_repository.put_request_body();
		String response_body="";
		int status_code=0;

		for (int i=0;i<5;i++)
		{
			status_code=Common_method.put_status_code_extractor(baseURI, put_resource, put_request_body);
		  if (status_code == 200)
		{

			response_body=Common_method.put_response_body_extractor(baseURI, put_resource, put_request_body);
			responsebodyValidator(response_body);
			break;
		}

			else
			{
				System.out.println("incorrect status code is getting hence retry "+ i);
			}
		}
		Assert.assertEquals(status_code, 200);
		common_method.Utility_common_method_.evidencefilecreator("put_tc_validation", put_request_body, response_body);

	}

	public static void responsebodyValidator(String response_body) {
		// TODO Auto-generated method stub
		// extract responsebody
		JsonPath res_body = new JsonPath(response_body);

		// extract responsebody parameter

		String res_name = res_body.getString("name");
		String res_job = res_body.getString("job");
		String res_id = res_body.getString("id");
		String newdate = LocalDate.now().toString();

		// validate response body
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "zion resident");
		Assert.assertNotEquals(res_id, "not null");
		//Assert.assertEquals(date, newdate);

		System.out.println("name : " + res_name + "\nid : " + res_id + "\njob : " + res_job + "\ndate : " + newdate);

	}

}