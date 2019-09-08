package WebApp.Repository;

import WebApp.Entity.proxysocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface ProxysocksRepository extends JpaRepository<proxysocks,Long> {

    proxysocks deleteAllByProxyIsLike(String s);

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE proxysocks AUTO_INCREMENT=1;",nativeQuery = true)
    void autoincrementNull();

    List<proxysocks> getTop50ByPortLike(String s);


    @Query( value =
            "select * from proxysocks " +
                " ORDER BY RAND() LIMIT 50",
                nativeQuery = true)
    List<proxysocks> get50random();


    @Query(value = "select * from proxysocks pr" +
            " left join search se on pr.id=se.idProxy " +
            "where pr.id not in (select idProxy from search where search.idUser=:iduser) and pr.code like :codeCountry " +
            "ORDER BY RAND() LIMIT 50",nativeQuery = true)
    List<proxysocks> getTop50ByCountryLikeAndIdNotInSeachTable(@Param("codeCountry") String country,@Param("iduser") Integer id);

    @Query(value = "select proxysocks.* from proxysocks left join search on proxysocks.id=search.idProxy where id in (select idproxy from search) and idUser=:id and code like :code", nativeQuery = true)
    List<proxysocks> getMyProxy(@Param("id") Integer id, @Param("code") String code);

}
