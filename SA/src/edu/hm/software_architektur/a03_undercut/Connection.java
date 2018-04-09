package edu.hm.software_architektur.a03_undercut;


public interface Connection {
    
    static Connection make(String specification) throws ReflectiveOperationException {
        return Factory.<Connection>make(specification);
    }
    
    void changePort(int port);
    
    void openConnection(); 
    
}
