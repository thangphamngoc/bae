package com.bae.repository;

import com.bae.entity.home.Home;
import com.bae.repository.repositoryCustom.HomeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * date 2021-03-19 08:44
 *
 * @author Phạm Ngọc Thắng
 */
public interface HomeRepository extends JpaRepository<Home, Long>, HomeRepositoryCustom {
}
