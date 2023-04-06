package test_class;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.Common_method;
import io.restassured.path.json.JsonPath;
import request_repository.request_repository;

public class Test_class_get {
	@Test
	public static void orchestractor() throws IOException {
		String baseURI = request_repository.baseURI();
		String get_resource = request_repository.get_resource();
		int status_code = 0;
		String responsebody = "";

		for (int i = 0; i < 5; i++) {
			status_code = Common_method.get_status_code_extractor(baseURI, get_resource);
			if (status_code == 200) {

				responsebody = Common_method.get_response_body_extractor(baseURI, get_resource);
				responsebodyValidator(responsebody);
				break;
			}

			else {
				System.out.println("incorrect status code is getting hence retry " + i);
			}
		}
		Assert.assertEquals(status_code, 200);
		common_method.Utility_common_method_.evidencefilecreator("get_tc_validation", "null", responsebody);

	}

	public static void responsebodyValidator(String responsebody) {
		// TODO Auto-generated method stub
		// extract responsebody
		JsonPath res_body = new JsonPath(responsebody);

		// find length of data object array
		int count = res_body.getInt("data.size()");

		System.out.println(count);

		// extract response body parameter date object
		int exp_id[] = { 7, 8, 9, 10, 11, 12 };
		String exp_email[] = { "michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in",
				"byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in" };
		String exp_fname[] = { "Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel" };
		String exp_lname[] = { "Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell" };

		for (int i = 0; i < count; i++) {

			// declare response parameter
			int res_id = res_body.getInt("data[" + i + "].id");
			String res_name = res_body.getString("data[" + i + "].first_name");
			String res_lname = res_body.getString("data[" + i + "].last_name");
			String res_email = res_body.getString("data[" + i + "].email");

			System.out.println(res_id);
			System.out.println(res_name);
			System.out.println(res_lname);
			System.out.println(res_email);

			Assert.assertEquals(res_id, exp_id[i]);
			Assert.assertEquals(res_name, exp_fname[i]);
			Assert.assertEquals(res_lname, exp_lname[i]);
			Assert.assertEquals(res_email, exp_email[i]);

		}
	}
}