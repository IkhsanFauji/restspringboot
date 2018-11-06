package com.test.controllers;

import com.test.models.Members;
import com.test.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController // deklarasi kelas sebagai REST API Controller
@RequestMapping("/members") // mapping end point yag diminta '/members'
public class MembersController {

    @Autowired
    MembersRepository members; // memanggil MemberRepository

    @GetMapping("/") // mapping end points dengan metode GET "http://localhost:8080/members/"
    public List<Members> getAll(){ // membuat list seluruh data member dari model Members
        return members.findAll(); // mengoper list seluruh data member dari model Members ke end point
    }

    @GetMapping("/{id_member}") // mapping end points dengan metode GET "http://localhost:8080/members/id_member"
    public ResponseEntity<Optional<Members>> getMemberById(@PathVariable(value="id_member") Long id_member){
        Optional<Members> member = members.findById(id_member);
        if(member == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(member);
    }

    @PostMapping("/") // mapping end points dengan metode POST "http://localhost:8080/members/"
    public Members tambahMember(@Valid @RequestBody Members member){ // fungsi tambahMember meminta data valid member
        return members.save(member); // data member di simpan
    }

    /*
    * PutMapping masih salah, seharusnya update hasilnya malah nambah data
    * */
//------------------------------------------------------------------ //
    @PutMapping("/{id_member}")
    public ResponseEntity<Members> updateMember(@PathVariable(value="id_member")Long id_member,
                                           @Valid @RequestBody Members detailmember){
        Optional<Members> member = members.findById(id_member);
        if(member == null)
            return ResponseEntity.notFound().build();

        detailmember.setNama(detailmember.getNama());
        detailmember.setAlamat(detailmember.getAlamat());
        detailmember.setUsia(detailmember.getUsia());

        @Valid Members updatedMember = members.save(detailmember);
        return ResponseEntity.ok(updatedMember);
    }
//------------------------------------------------------------------ //

    @DeleteMapping("/{id_member}") // mapping end points dengan metode DELETE "http://localhost:8080/members/id_member"
    public String deleteMember(@PathVariable (value="id_member") Long id_member){
        Optional<Members> member = members.findById(id_member); // mengambil data member berdasarkan id_member
        String result = ""; // deklarasi default value result kosong
        if(member == null) {
            result = "id_member "+id_member+" tidak ditemukan"; // pesan yang ditampilkan jika data tidak ditemukan
            return result;
        }
        result = "id_member "+id_member+" berhasil di hapus"; // pesan yang ditampilkan jika data berhasil dihapus
        members.deleteById(id_member); // data dihapus dengan metode deleteById()
        return result;
    }


}
