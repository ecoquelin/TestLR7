package zango.banquepopulaire.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import zango.banquepopulaire.service.AccountBalanceLocalService;
import zango.banquepopulaire.service.AccountBalanceLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AccountBalance Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AccountBalancePortlet extends MVCPortlet {
	
	//@ServiceReference (type=AccountBalanceLocalService.class)
	private AccountBalanceLocalService _accountBalanceLocalService;
	
	private static Log _log = LogFactoryUtil
			.getLog(AccountBalancePortlet.class);
	
	@Activate
    void activate() throws Exception {

        System.out.println("Activating accountbalanceportlet ...");
    }
	
	@Reference(unbind="-")
	protected void setAccountBalanceLocalService(AccountBalanceLocalService accountBalanceLocalService){
		this._accountBalanceLocalService = accountBalanceLocalService;
	}
	
	public void checkAccountBalance(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try{
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			String userName = ParamUtil.getString(actionRequest, "userName");
			String password = ParamUtil.getString(actionRequest, "password");
			String company = ParamUtil.getString(actionRequest, "company");
			String transactionId = ParamUtil.getString(actionRequest, "transactionId");
			_log.debug("userName=" + userName + ", password="
						+ password+", company="
						+ company +", transactionId=" + transactionId);
			Double balance = _accountBalanceLocalService.getAccountBalance(userName, password, company, transactionId, serviceContext);
			if (balance != null){
				//actionRequest.setAttribute("balance", balance);
				actionResponse.setRenderParameter("balance", String.valueOf(balance));
			}
		} catch(PortalException e){
			e.printStackTrace();
		}
	}
	
	
}