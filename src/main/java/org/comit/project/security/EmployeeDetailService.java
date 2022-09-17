/*package org.comit.project.security;
import org.comit.project.bean.Employee;
import org.comit.project.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service("EmployeeDetailsService")

public class EmployeeDetailService implements EmployeeDetailsService{
	
	
	

		@Autowired
		EmployeeDao empDao;

		@Override
		public EmployeeDetail loadEmployeeByUsername(String username) throws UsernameNotFoundException {


			Employee emp = empDao.findByUsername(username);

			if (emp==null) {
				throw new UsernameNotFoundException("User not found: " + username);
			}

			return new EmployeeDetail(emp);
		}

	}

}*/
