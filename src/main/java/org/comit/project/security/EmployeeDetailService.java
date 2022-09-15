package org.comit.project.security;
import org.comit.project.bean.Employee;
import org.comit.project.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class EmployeeDetailService implements EmployeeDetailsService{{
	
	@Service("UserDetailsService")
	

		@Autowired
		EmployeeDao userDao;

		@Override
		public EmployeeDetails loadUserByUsername(String username) throws UsernameNotFoundException {


			User user = userDao.findByUsername(username);

			if (user==null) {
				throw new UsernameNotFoundException("User not found: " + username);
			}

			return new CustomUserDetails(user);
		}

	}

}
