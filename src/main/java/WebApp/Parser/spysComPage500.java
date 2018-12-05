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
import java.util.Arrays;
import java.util.LinkedList;

@Service
public class spysComPage500 {
    @Autowired
    private ProxysocksRepository proxysocksRepository;

    @Async
    public void startPars() {
        Document dk;
        String[] elProxyDecr;
        Elements elPort;
        Elements elProxy;
        LinkedList<String> DEClist = new LinkedList<String>();
        LinkedList<String> port = new LinkedList<String>();
        LinkedList<String> Rez = new LinkedList<String>();
        try {
            dk = Jsoup.connect("http://spys.one/en/socks-proxy-list/")
                    .userAgent("@mail_ruAdmin")
                    .data("xpp", "5")
                    .data("xf1", "0")
                    .data("xf2", "0")
                    .data("xf4", "0")
                    .data("xf5", "2")
                    .post();

            /*PortDecr*/
            elProxyDecr = dk.select("body>script").first().data().split(";");
            DEClist.addAll(Arrays.asList(elProxyDecr));


            for (int i = 0; i < DEClist.size(); i++) {
                DEClist.remove();
            }
            for (int i = 0; i < DEClist.size(); i++) {
                DEClist.set(i, DEClist.get(i).replace("=" + (i), ""));
            }
            /*AllPort*/
            elPort = dk.getElementsByClass("spy14")
                    .select("script");
            for (Element element : elPort) {
                port.add(element.data().replace("document.write(\"<font class=spy2>:<\\/font>\"+(", "").replace(")+(", "").replace(")", ""));
            }

            /*IP*/
            elProxy = dk.select("td>font.spy14");
            for (Element element : elProxy) {
                if (!element.data().isEmpty())
                    Rez.add(element.text());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            for (int i = 0; i < port.size(); i++) {
                for (int j = 0; j < DEClist.size(); j++) {
                    port.set(i, port.get(i).replace(DEClist.get(j), String.valueOf(j))); //decryption
                }
                proxysocks pr = new proxysocks();
                pr.setProxy(Rez.get(i));
                pr.setCode("");
                pr.setPort(port.get(i));
                pr.setType("");
                proxysocksRepository.save(pr);
            }
            System.out.println("proxy500 added");
        }
    }
}

