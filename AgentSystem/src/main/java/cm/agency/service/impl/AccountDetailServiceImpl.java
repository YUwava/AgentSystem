package cm.agency.service.impl;

import cm.agency.dao.AccountDetailDaotS;
import cm.agency.dao.AgentMapper;
import cm.agency.entity.AccountDetail;
import cm.agency.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountDetailService")
public class AccountDetailServiceImpl implements AccountDetailService {
	@Autowired
	private AccountDetailDaotS mapper;

	@Autowired
	AgentMapper agentMapper;


	public List<AccountDetail> getAccountDetailList(AccountDetail accountDetail) throws Exception{
		// TODO Auto-generated method stub
		return mapper.getAccountDetailList(accountDetail);
	}


	public int addAccountDetail(AccountDetail accountDetail)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.addAccountDetail(accountDetail);
	}


	public int modifyAccountDetail(AccountDetail accountDetail)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.modifyAccountDetail(accountDetail);
	}


	public int deleteAccountDetail(AccountDetail accountDetail)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.deleteAccountDetail(accountDetail);
	}



	public List<AccountDetail> getAccountDetail(AccountDetail accountDetail) {
		System.out.println("-----------------查询方法执行------------");
		return agentMapper.getAccountDetail(accountDetail);
	}

	public Integer count(AccountDetail accountDetail)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.count(accountDetail);
	}


	public List<AccountDetail> repostAgentDetail(AccountDetail accountDetail)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.repostAgentDetail(accountDetail);
	}

}
