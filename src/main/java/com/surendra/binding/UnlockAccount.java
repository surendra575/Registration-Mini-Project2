package com.surendra.binding;

import lombok.Data;

@Data
public class UnlockAccount {
	private String acctEmail;
	private String oldPassword;
	private String newPassword;
	private String confirmNewPassword;

}
