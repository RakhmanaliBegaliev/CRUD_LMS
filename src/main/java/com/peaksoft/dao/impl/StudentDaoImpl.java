package com.peaksoft.dao.impl;

import com.peaksoft.dao.StudentDao;
import com.peaksoft.entity.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("from Student ").getResultList();
    }

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student student1 = entityManager.find(Student.class, id);
        student1.setFirstName(student.getFirstName());
        student1.setEmail(student.getEmail());
        student1.setLastName(student.getLastName());
        student1.setStudyFormat(student.getStudyFormat());
        entityManager.merge(student);
    }

    @Override
    public Student getById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }
}
