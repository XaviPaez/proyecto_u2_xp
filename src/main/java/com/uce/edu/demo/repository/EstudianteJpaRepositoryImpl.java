package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante buscarPorId(int cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, cedula);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(int cedula) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.buscarPorId(cedula);
		this.entityManager.remove(estudiante);

	}

	@Override
	public Estudiante buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> miTypedQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=: datoCedula", Estudiante.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> miTypedQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.apellido=: datoApellido ORDER BY e.edad", Estudiante.class);
		miTypedQuery.setParameter("datoApellido", apellido);
		return miTypedQuery.getResultList();

	}

	@Override
	public Estudiante buscarPorNombreNamed(String nombre) {
		// TODO Auto-generated method stub

		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre");
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorSemestreNamed(String semestre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorSemestre");
		myQuery.setParameter("datoSemestre", semestre);
		return (List<Estudiante>) myQuery.getResultList();

	}

	@Override
	public List<Estudiante> buscarPorSemestreEdadGeneroTypedNamed(String semestre, String edad, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorSemestreEdadGenero",
				Estudiante.class);
		myQuery.setParameter("datoSemestre", semestre);
		myQuery.setParameter("datoEdad", edad);
		myQuery.setParameter("datoGenero", genero);

		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorSemestreGeneroTypednamed(String semestre, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorSemestreGenero",
				Estudiante.class);
		myQuery.setParameter("datoSemestre", semestre);
		myQuery.setParameter("datoGenero", genero);

		return myQuery.getResultList();

	}

	@Override
	public List<Estudiante> buscarPorSemestreNative(String semestre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createNativeQuery("SELECT * FROM estudiante WHERE estu_semestre = :datoSemestre", Estudiante.class);
		myQuery.setParameter("datoSemestre", semestre);
		return (List<Estudiante>) myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoNative(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createNativeQuery("SELECT * FROM estudiante WHERE estu_Apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (List<Estudiante>) myQuery.getResultList();

	}

	@Override
	public List<Estudiante> buscarPorSemestreGeneroNamedNative(String semestre, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createNamedQuery("Estudiante.buscarPorSemestreGeneroNamedNative", Estudiante.class);
		myQuery.setParameter("datoSemestre", semestre);
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorNombreGeneroNamedNative(String nombre, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createNamedQuery("Estudiante.buscarPorNombreGeneroNamedNative", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();

	}

	@Override
	public List<Estudiante> buscarDinamicamenteSemestreApellidoEdad(String semestre, String apellido, String edad) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);

		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

		Predicate predicadoSemestre = myCriteria.equal(myTabla.get("semestre"), semestre);
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate predicadoEdad = myCriteria.equal(myTabla.get("edad"), edad);

		Predicate miPredicadoFinal = null;
		if (edad.equals("22")) {
			miPredicadoFinal = myCriteria.and(predicadoSemestre, predicadoEdad);

		} else {
			miPredicadoFinal =predicadoApellido;

		}

		myQuery.select(myTabla).where(miPredicadoFinal);
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}

	@Override
	public List<Estudiante> buscarDinamicamentePorLetraSemestreApellido(String apellido, String letra, String semestre) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);

		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate predicadoLetra = myCriteria.like(myTabla.get("apellido"), letra);
		Predicate predicadoSemestre = myCriteria.equal(myTabla.get("semestre"), semestre);

		Predicate miPredicadoFinal = null;
		if (apellido.contains(letra)) {
			miPredicadoFinal = myCriteria.or(predicadoLetra, predicadoSemestre);
		} else {
			miPredicadoFinal = myCriteria.or(predicadoSemestre, predicadoApellido);
		}
		myQuery.select(myTabla).where(miPredicadoFinal);
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();

	}

}
