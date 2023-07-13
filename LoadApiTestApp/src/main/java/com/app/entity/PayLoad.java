package com.app.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PayLoad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loadId;
	private String loadingPoint;
	private String productType;
	private String truckType;
	private String numberOfTrucks;
	private String weight;
	private String comment;
	private String shipperId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date date;
}
