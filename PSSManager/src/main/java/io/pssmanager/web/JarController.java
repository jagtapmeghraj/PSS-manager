package io.pssmanager.web;

import io.pssmanager.domain.Customer;
import io.pssmanager.domain.Jar;
import io.pssmanager.services.JarService;
import io.pssmanager.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jar")
public class JarController {

    @Autowired
    private JarService jarService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> addNewJar(@Valid @RequestBody Jar jar, BindingResult result)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        Jar _jar = jarService.saveJar(jar);
        return new ResponseEntity<Jar>(_jar, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<?> updateJar(@Valid @RequestBody Jar jar, BindingResult result)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        Jar _jar = jarService.updateJar(jar);
        return new ResponseEntity<Jar>(_jar, HttpStatus.OK);
    }

    @GetMapping("/{jarName}")
    public ResponseEntity<?> getJarByJarName(@PathVariable String jarName)
    {
        Jar jar = jarService.findJarByJarName(jarName);
        return new ResponseEntity<Jar>(jar,HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Jar> getAllJars(){return jarService.findAllJars();}

    @DeleteMapping("/{jarName}")
    public ResponseEntity<?> deleteJar(@PathVariable String jarName){

        jarService.deleteJarByName(jarName);
        return new ResponseEntity<String>("Jar with jarName: '"+jarName+"' was deleted", HttpStatus.OK);
    }
}
