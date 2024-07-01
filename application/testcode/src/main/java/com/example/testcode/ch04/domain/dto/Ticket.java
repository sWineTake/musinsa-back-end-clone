package com.example.testcode.ch04.domain.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	private UUID performanceId;
	private String performanceName;
	private String reservationName;
	private String reservationPhoneNumber;
	private String reservationStatus;
	private int round;
	private char line;
	private int seat;
	private ArrayList<String> appliedPolicies;

}
