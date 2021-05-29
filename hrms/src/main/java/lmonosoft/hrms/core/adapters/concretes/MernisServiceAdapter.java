package lmonosoft.hrms.core.adapters.concretes;

import java.rmi.RemoteException;
import java.time.LocalDate;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lmonosoft.hrms.core.adapters.abstracts.UserCheckService;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Primary
@Component
public class MernisServiceAdapter implements UserCheckService {

	boolean result = false;

	@Override
	public boolean isRealPerson(String firstName, String lastName, String nationalId, LocalDate birthOfDate) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();

		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(nationalId), firstName.toUpperCase(),
					lastName.toUpperCase(), birthOfDate.getYear());

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
