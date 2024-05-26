package com.veterinarymanagementsystem.core.exception;

// Veri mevcut olduğunda ortaya çıkan istisnaları temsil etmek için kullanılan istisna sınıfı
public class DataExistsException extends RuntimeException {
    // Belirli bir mesajla istisna oluşturmak için kullanılan kurucu metod
    public DataExistsException(String message){
        super(message);
    }
}
