package com.assign.em.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter & setter
@AllArgsConstructor // constructor
@NoArgsConstructor
/*
 * This class is helper to achieve the filter problem as per below fields in
 * this class I declare the necessary fields which are required for filter
 */
public class FilterEmployee {

	public String department;
	public String position;
	public int paginationLimit;
}
