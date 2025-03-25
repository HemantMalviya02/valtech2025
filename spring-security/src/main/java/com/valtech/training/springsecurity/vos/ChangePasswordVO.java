package com.valtech.training.springsecurity.vos;

public record ChangePasswordVO(String currentPassword, String newPassword, String confirmPassword) {
	
}
