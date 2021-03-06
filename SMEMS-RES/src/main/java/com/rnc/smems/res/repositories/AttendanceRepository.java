package com.rnc.smems.res.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rnc.smems.res.entities.Attendance;

public class AttendanceRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Attendance attendance) {
		entityManager.persist(attendance);	
	}
	
	public void update(Attendance attendance) {
		entityManager.merge(attendance);
	}
	
	public void delete(Attendance attendance) {
		entityManager.remove(attendance);
	}
	
	public Attendance findByID(long id) {
		String str = "select t from %s t where t.id = "+id;
		String sql = String.format(str, Attendance.class.getSimpleName());
		TypedQuery<Attendance> query = entityManager.createQuery(sql, Attendance.class);
		return query.getSingleResult();
	}
	
	public List<Attendance> findByDate (LocalDate date) {
		String str = "select t from %s t where t.Date = '"+date.toString()+"'";
		String sql = String.format(str, Attendance.class.getSimpleName());
		TypedQuery<Attendance> query = entityManager.createQuery(sql, Attendance.class);
		return query.getResultList();
	}
	
	public List<Attendance> findAll() {
		String str = "select t from %s t";
		String sql = String.format(str, Attendance.class.getSimpleName());
		TypedQuery<Attendance> query = entityManager.createQuery(sql, Attendance.class);
		return query.getResultList();
	}
	
	public List<Attendance> findByAbsent (long id) {
		String str = "select t from %s t where t.present = false and t.staff.id = " +id;
		String sql = String.format(str, Attendance.class.getSimpleName());
		TypedQuery<Attendance> query = entityManager.createQuery(sql, Attendance.class);
		return query.getResultList();	
	}
	
	public List<Attendance> findByMonth (String dateFrom, String dateTo) {
		String str = "select t from %s t where t.date between '"+dateFrom+"' and '"+dateTo+"'";
		String sql = String.format(str, Attendance.class.getSimpleName());
		TypedQuery<Attendance> query = entityManager.createQuery(sql, Attendance.class);
		return query.getResultList();
	}
	
	public List<Attendance> findByAttendance (LocalDate date) {
		String str = "select t from %s t where t.present = true and t.Date = '"+date.toString()+"'";
		String sql = String.format(str, Attendance.class.getSimpleName());
		TypedQuery<Attendance> query = entityManager.createQuery(sql, Attendance.class);
		return query.getResultList();
	}
	
}