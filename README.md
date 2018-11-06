# restspringboot
Belajar REST API menggunakan Spring Boot

1. Project dibungus dalam folder test
2. Generate project menggunakan spring initiaizr melalui (web / intellij)
3. Jika generate menggunakan web, maka imort projek terlebih dahulu
4. Pastikan XAMPP / LAMPP sudah terinstall
5. Buat database / import database spring1.sql
6. Buat koneksi ke mysql
   
   spring.datasource.url = jdbc:mysql://localhost:3306/spring1?useSSL=false
   spring.datasource.username =root
   spring.datasource.password =
   spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
   spring.jpa.hibernate.ddl-auto = update

7. buat package baru setara dengan TestApplication.java
  - controllers
    - MembersController.java
  - models
    - Members
  - repository
    - MembersRepository.java
    
