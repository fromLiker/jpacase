/**
 * 
 */
package com.ibm.jpacase.repository;

import com.ibm.jpacase.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import javax.transaction.Transactional;

/**
 * @author PingXue
 *
 */
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

	@Query(name = "getCompanyNameByCode", nativeQuery = true,
			value = "SELECT companyname from company where companycode = :companyCode")
	String getCompanyNameByCode(String companyCode);

	CompanyEntity findByCompanyCode(String companyCode);

	@Query(name = "findByName", nativeQuery = true,
			value = "SELECT * from company  where companyname = :companyName")
	CompanyEntity findByName(String companyName);

	List<CompanyEntity> findAllBySectorName(String sector);
	
    @Transactional
    @Modifying
    @Query(value = "delete from company where companyid =?1",nativeQuery = true)
    void deleteByCompanyCode(String companyId);

}

