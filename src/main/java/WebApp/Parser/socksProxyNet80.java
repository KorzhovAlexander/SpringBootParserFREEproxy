package WebApp.Parser;

import WebApp.Entity.proxysocks;
import WebApp.Repository.ProxysocksRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;



@Service
public class socksProxyNet80 {
    @Autowired
    private ProxysocksRepository proxysocksRepository;

    LinkedList<String> LL = new LinkedList<String>();

    @Async
    public void startPars() {
        try {
            Document doc = Jsoup.connect("https://www.socks-proxy.net/").get();
            Elements ELE = doc.getElementsByTag("td").not("td.hd").not("td.active");
            for (Element nextEl : ELE) {
                LL.add(String.valueOf(nextEl.text()));
            }
            for (int i = 0; i < 25; i++)
                LL.removeLast();
            for (int i = 0; i < LL.size(); i += 7) {
                proxysocks pr = new proxysocks();
                pr.setType(LL.get(i+4));
                pr.setPort(LL.get(i+1));
                pr.setCode(LL.get(i+2));
                pr.setProxy(LL.get(i));
                proxysocksRepository.save(pr);
            }
            System.out.println("proxy80 added");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

