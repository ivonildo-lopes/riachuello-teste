package com.riachuello.teste.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riachuello.teste.entity.Localidade;

@Repository
public interface LocalidadeDao extends JpaRepository<Localidade, String> {
	
//	@Query(value = "SELECT p.name AS name, COUNT(dp.people_id) AS count " +
//            "FROM people p INNER JOIN dream_people dp " +
//            "ON p.id = dp.people_id " +
//            "WHERE p.user_id = :userId " +
//            "GROUP BY dp.people_id " +
//            "ORDER BY p.name", nativeQuery = true)
//	LojaTeste findById();

}


