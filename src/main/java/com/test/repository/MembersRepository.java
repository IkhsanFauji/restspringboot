package com.test.repository;

import com.test.models.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // deklarasi kelas sebagai repository data member
public interface MembersRepository extends JpaRepository<Members, Long> { // kelas diubah menjadi interface dan menjadi turunan JpaRepository
    List<Members> findByNama(String nama); // method untuk mencari data berdasarkan nama
}
