package org.comit.project.security;
import java.util.Collection;

import org.comit.project.bean.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
public class EmployeeDetail implements EmpDetails{{
	

	

		private static final long serialVersionUID = 1L;

		Employee emp;


		public Employee(Employee emp) {
			super();
			this.emp = emp;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return null;
		}

		@Override
		public String getPassword() {
			return this.emp.getPassword();
		}

		@Override
		public String getUsername() {
			return this.emp.getUsername();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return "A".equalsIgnoreCase(this.emp.getStatus());
		}

	}

}
