package com.crm.ssh2.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.crm.ssh2.right.entity.RightUser;

@WebService
public interface IRightUserService {
	
	@WebMethod
	List<RightUser> list(RightUser rightUser);
	
}
