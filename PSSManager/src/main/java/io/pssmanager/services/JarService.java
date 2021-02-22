package io.pssmanager.services;

import io.pssmanager.domain.Customer;
import io.pssmanager.domain.Jar;
import io.pssmanager.exceptions.CustomerIdException;
import io.pssmanager.exceptions.JarNameException;
import io.pssmanager.repositories.JarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JarService {

    @Autowired
    private JarRepository jarRepository;

    public Jar saveJar(Jar jar)
    {
        try{
            jar.setJarName(jar.getJarName());
            return jarRepository.save(jar);
        }catch (Exception e){
            throw new JarNameException("jar with jarName : "+jar.getJarName()+" is already present");
        }
    }

    public Jar updateJar(Jar jar)
    {
        try{
            Jar _jar = jarRepository.findByJarName(jar.getJarName());
            _jar.setCustomer(jar.getCustomer());
            return jarRepository.save(jar);
        }catch(Exception e){
            throw new JarNameException("Jar : "+jar.getJarName()+" could not be updated `\n"+e);
        }
    }

    public Jar findJarByJarName(String jarName){

        Jar jar = jarRepository.findByJarName((jarName));

        if(jar==null){
            throw new JarNameException("There is no jar with name : "+jarName+".");
        }
        return jar;
    }

    public Iterable<Jar> findAllJars(){
        return jarRepository.findAll();
    }

    public void deleteJarByName(String jarName){

        try {
            Jar jar = findJarByJarName(jarName);
            jarRepository.delete(jar);
        }
        catch (Exception e){
            throw new JarNameException("Cannot delete Jar with jarName :"+jarName);
        }


    }
}
