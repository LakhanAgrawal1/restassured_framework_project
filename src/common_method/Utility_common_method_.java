package common_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utility_common_method_ {
	public static void evidencefilecreator(String fileName,String request,String response) throws IOException
	{
		File newtextfile = new File("D:\\restAssuredevidence\\" + fileName + ".txt");
	if (newtextfile.createNewFile())
	{
		FileWriter datawriter =new FileWriter(newtextfile);


		datawriter.write("requestbody is :\n" + request +"\n\n");
		datawriter.write("responsebody is :\n" + response);
		datawriter.close();

		System.out.println("request and respons body data saved in : " + newtextfile.getName());


	}
	else
	{
		System.out.println(newtextfile.getName()  + "  already exists please take up a bakcup of it " );;
	}

	}





}