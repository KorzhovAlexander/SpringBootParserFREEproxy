package WebApp.Service;

import WebApp.Entity.proxysocks;
import WebApp.Entity.search;
import WebApp.Repository.ProxysocksRepository;
import WebApp.Repository.UserRepository;
import WebApp.Repository.searchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class searchService {
    @Autowired
    private ProxysocksRepository proxysocksRepository;

    @Autowired
    private searchRepository searchRepository;

    @Autowired
    private UserRepository userRepository;


    public List<proxysocks> getStatic50Proxy(String s) {
        return proxysocksRepository.getTop50ByPortLike(s);
    }

    public List<proxysocks> get50random(String a) {
        List<proxysocks> prlist = proxysocksRepository.get50random();

        if (prlist.size() == 0) {
            searchRepository.deleteAll();
            return proxysocksRepository.get50random();
        }

        return prlist;
    }

    public List<proxysocks> get50randomGoodProxy(String param, Integer iduser) {
        List<proxysocks> allMy = proxysocksRepository.getMyProxy(iduser, "%");
        List<proxysocks> prlist = proxysocksRepository.getTop50ByCountryLikeAndIdNotInSeachTable(param + "%", iduser);

        if ((prlist.size() == 0) && (param.isEmpty())) {
            searchRepository.deleteAllByIduserEquals(iduser);
            return proxysocksRepository.get50random();
        }

        if (allMy.size() < 150) {
            for (int i = 0; i < prlist.size(); i++) {
                search searcheIND = new search();
                searcheIND.setIdproxy(prlist.get(i).getId());
                searcheIND.setIduser(iduser);
                searchRepository.save(searcheIND);
            }
            return prlist;
        }

        return proxysocksRepository.getMyProxy(iduser,param+ "%");
    }
}
