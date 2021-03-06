package com.rnc.smems.res.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rnc.smems.res.entities.Material;

public class MaterialRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void save (Material material) {
		entityManager.persist(material);
	}
	
	public void update (Material material) {
		entityManager.merge(material);
	}
	
	public void delete (Material material) {
		entityManager.remove(material);
	}
	
	public Material findByID (long id) {
		String str = "select t from %s t where t.id = " + id;
		String sql = String.format(str, Material.class.getSimpleName());
		TypedQuery<Material> query = entityManager.createQuery(sql, Material.class);
		return query.getSingleResult();
	}
	
	public List<Material>  findByDate (String date) {
		String str = "select t from %s t where t.erase = false and t.date = '"+date+"'";
		String sql = String.format(str, Material.class.getSimpleName());
		TypedQuery<Material> query = entityManager.createQuery(sql, Material.class);
		return query.getResultList();
	}
	
	public List<Material>  findAll () {
		String str = "select t from %s t where t.erase = false";
		String sql = String.format(str, Material.class.getSimpleName());
		TypedQuery<Material> query = entityManager.createQuery(sql, Material.class);
		return query.getResultList();
	}
	
}
