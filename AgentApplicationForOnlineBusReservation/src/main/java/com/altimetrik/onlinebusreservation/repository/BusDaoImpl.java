package com.altimetrik.onlinebusreservation.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.altimetrik.onlinebusreservation.model.Bus;

@Repository
public class BusDaoImpl implements BusDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List getBusInformation(String source_city_name, String destination_city_name, LocalDate travel_date,
			LocalDate return_date) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Bus> query = currentSession.createQuery(
				"from Bus where source_city_name  = :source_city_name  and destination_city_name  = :destination_city_name and travel_date =:travel_date ",
				Bus.class);
		query.setParameter("source_city_name", source_city_name);
		query.setParameter("destination_city_name", destination_city_name);
		query.setParameter("travel_date", travel_date);

		List<Bus> busInformation = query.getResultList();

		System.out.println(busInformation);

		return busInformation;
	}

}
