package org.hwine.domain.member;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class MemberAgeAndBirthVO {

	private LocalDate birthDate;
	private int gender;
}
