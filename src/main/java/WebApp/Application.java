package WebApp;

import WebApp.Parser.socksProxyNet80;
import WebApp.Parser.spysComPage500;
import WebApp.Repository.ProxysocksRepository;
import WebApp.Repository.searchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private spysComPage500 spysComPage500;

    @Autowired
    private socksProxyNet80 socksProxyNet80;

    @Autowired
    private ProxysocksRepository proxysocksRepository;

    @Autowired
    private searchRepository searchRepository;

    @Override
    public void run(String... args) throws Exception {


        while (true) {
            searchRepository.deleteAll();
            searchRepository.autoincrementNull();
            proxysocksRepository.deleteAll();
            proxysocksRepository.autoincrementNull();
            socksProxyNet80.startPars();
            spysComPage500.startPars();
            System.out.println("ok");
            Thread.sleep(600000);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}