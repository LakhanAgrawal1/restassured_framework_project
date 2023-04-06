
package driver_class;

import java.io.IOException;

import test_class.Test_class_get;
import test_class.Test_class_patch;

//import test_class.Test_class_get;

import test_class.Test_class_put;

//import test_class.Test_class_patch;
//import test_class.Test_classes;

public class Driver_class {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		test_class.Test_classes.orchestractor();
		  Test_class_patch.orchestractor();
		Test_class_put.orchestractor();
		Test_class_get.orchestractor();

	}

}