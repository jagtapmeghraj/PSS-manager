package io.pssmanager.repositories;


import io.pssmanager.domain.Jar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JarRepository extends CrudRepository<Jar,Long> {

    Jar findByJarName(String jarName);

}
