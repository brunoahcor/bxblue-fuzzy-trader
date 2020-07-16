package br.com.bxblue.fuzzytrader.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.bxblue.fuzzytrader.model.entity.Cliente;
import br.com.bxblue.fuzzytrader.model.vo.AtivoVo;
import br.com.bxblue.fuzzytrader.repository.ClienteRespository;
import br.com.bxblue.fuzzytrader.service.IAtivoService;

@Component
public class RunnerConfig implements CommandLineRunner {

    @Autowired
    private ClienteRespository clienteRepository;

    @Autowired
    private IAtivoService ativoService;

    private Cliente c1 = new Cliente(null, "admin", "079.693.340-59", "admin@bxblue.com.br");
    private Cliente c2 = new Cliente(null, "Bruno Rocha", "109.741.357-80", "bruno.ahcor@bxblue.com.br");

    @Override
    public void run(String... args) throws Exception {

        // add clientes
        clienteRepository.findByCpf(c1.getCpf()).orElseGet(() -> clienteRepository.save(c1));
        clienteRepository.findByCpf(c2.getCpf()).orElseGet(() -> clienteRepository.save(c2));

        // add ativos
        List<AtivoVo> lista = ativoService.listarTodosAtivos();
        for (AtivoVo ativoVo : lista) {
            ativoService.salvar(ativoVo);
        }

    }

}