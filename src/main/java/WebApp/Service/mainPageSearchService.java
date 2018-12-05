package WebApp.Service;

import WebApp.Entity.proxysocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class mainPageSearchService {
    @Autowired
    private searchService searchService;

    public List<proxysocks> getListProxyLike(String proxy,String port,String County){
        List<proxysocks> statick = searchService.getStatic50Proxy("%");
        List<proxysocks> finalList = new ArrayList<>();

        for (proxysocks aStatick : statick) if (aStatick.getProxy().startsWith(proxy)) finalList.add(aStatick);
        return finalList;
    }
}
