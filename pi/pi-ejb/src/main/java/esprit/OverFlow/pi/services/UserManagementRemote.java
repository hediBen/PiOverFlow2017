package services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import persistence.Member;
import persistence.User;

@Remote
@WebService(targetNamespace = "http://user.tn")
public interface UserManagementRemote {
	@WebMethod(operationName = "addUserOperation")
	@WebResult(name = "addUserResult")
	void addUser(@WebParam(name="user") User user);

	@WebMethod(operationName = "updateUserOperation")
	@WebResult(name = "updateUserResult")
	void updateUser(@WebParam(name="user")User user);
	
	@WebMethod(operationName = "deleteUserByIdOperation")
	@WebResult(name = "deleteUserByIdResult")
	void deleteUserById(@WebParam(name="idUser")int id);

	@WebMethod(operationName = "deleteUserOperation")
	@WebResult(name = "deleteUserResult")
	void deleteUser(@WebParam(name="user")User user);

	@WebMethod(operationName = "findUserByIdOperation")
	@WebResult(name = "findUserByIdResult")
	User findUserById(@WebParam(name="idUser")int id);
	
	@WebMethod(operationName = "findAllUsersOperation")
	@WebResult(name = "findAllUsersResult")
	List<User> findAllUsers();

	@WebMethod(operationName = "findUserByLoginOperation")
	@WebResult(name = "findUserByLoginResult")
	User findUserByLogin(@WebParam(name="login")String login);
	
	@WebMethod(operationName = "findUserByMailOperation")
	@WebResult(name = "findUserByMailResult")
	User findUserByMail(String mail);
	
	@WebMethod(operationName = "LoginOperation")
	@WebResult(name = "LoginResult")
	User login(@WebParam(name="login")String login,@WebParam(name="password")String pwd);


	@WebMethod(operationName = "EmailExistsOperation")
	@WebResult(name = "EmailExistsResult")
	 int EmailExists(@WebParam(name="mail")String mail);
	
	@WebMethod(operationName = "UsernameExistsOperation")
	@WebResult(name = "UsernameExistsResult")
	 int UsernameExists(@WebParam(name="login")String login) ;
	
	@WebMethod(operationName = "fideliserOperation")
	@WebResult(name = "fideliserResult")
	Member fideliser(Member m,int pts);
	
	@WebMethod(operationName = "findMemberByIdOperation")
	@WebResult(name = "findMemberByIdResult")
	Member findMemberById(int id);
	
	
}