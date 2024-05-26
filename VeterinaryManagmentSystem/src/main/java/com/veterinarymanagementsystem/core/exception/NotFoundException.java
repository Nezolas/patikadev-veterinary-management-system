package com.veterinarymanagementsystem.core.exception;

// Bulunamayan bir kaynak veya varlık için ortaya çıkan istisnaları temsil etmek için kullanılan istisna sınıfı
public class NotFoundException extends RuntimeException {
    // Belirli bir mesajla istisna oluşturmak için kullanılan kurucu metod
    public NotFoundException(String message){
        super(message);
    }
}
