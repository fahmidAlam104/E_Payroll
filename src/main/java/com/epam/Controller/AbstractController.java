//package com.epam.Controller;
//
//import com.epam.service.ServiceCrudOperations;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public abstract class AbstractController<T,Id> {
//    @Autowired
//    ServiceCrudOperations ServiceCrudOperations;
//    public List<T> get(){
//        return ServiceCrudOperations.getAll(T);
//    }
//}
