package api.endpoints;

/*
swagger URI : https://petstore.swagger.io/
create user : https://petstore.swagger.io/v2/user
update user : https://petstore.swagger.io/v2/user/{username}
get user : https://petstore.swagger.io/v2/user/{username}
delete user : https://petstore.swagger.io/v2/user/{username}
*/

public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module
	public static String post_url = base_url + "/user";
	public static String put_url = base_url + "/user/{username}";
	public static String get_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";

}
