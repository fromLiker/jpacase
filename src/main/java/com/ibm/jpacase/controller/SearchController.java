/**
 * 
 */
package com.ibm.jpacase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ibm.jpacase.service.CompanyService;
import com.ibm.jpacase.utils.CommonResult;
import com.ibm.jpacase.utils.ResponseCode;
import com.ibm.jpacase.entity.CompanyEntity;
import java.util.List;

/**
 * @author PingXue
 *
 */
@RestController
@RequestMapping("/search")
public class SearchController {

	 private static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/company")
	public CommonResult searchCompany() {
		return companyService.findAll();
	}

	@GetMapping("/company_code/{companyCode}")
	public CommonResult searchCompanyByCode(@PathVariable String companyCode) {
		return companyService.findByCode(companyCode);
	}
	
	@PostMapping("/createCompany")
	public CommonResult createCompany(@RequestBody CompanyEntity companyEntity) {
		return companyService.saveCompany(companyEntity);
	}

	@PutMapping("/updateCompany")
	public CommonResult updateCompany(@RequestBody CompanyEntity companyEntity) {
		return companyService.updateCompany(companyEntity);
	}
	
	@DeleteMapping("/deleteCompany/{companyId}")
	public CommonResult deleteCompany(@PathVariable String companyId) {
		return companyService.deleteCompany(companyId);
	}
	
	//sectorName=Automobiles
	@GetMapping("/sector_name/{sectorName}")
	public CommonResult searchCompanyBySectorname(@PathVariable String sectorName) {
		List<CompanyEntity> companyEntityList = companyService.findComBySector(sectorName);
		for(int i = 0;i < companyEntityList.size(); i ++) {
			companyEntityList.get(i);
			logger.info("*************" + companyEntityList.get(i));
		}
		return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", companyEntityList);
	}
	
}
