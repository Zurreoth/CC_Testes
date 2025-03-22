package br.upf.ConstruContract.converter;

import br.upf.ConstruContract.dto.ProjetoDTO;
import br.upf.ConstruContract.model.ImagemProjeto;
import br.upf.ConstruContract.model.Projeto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjetoConverter {

    public Projeto toProjeto(ProjetoDTO dto) {
        List<ImagemProjeto> imagens = new ArrayList<>();
        Projeto projeto = new Projeto(dto.getNome(), dto.getValor());

        for (byte[] imagen : dto.getImagens()) {
            imagens.add(new ImagemProjeto(imagen, projeto));
        }

        projeto.setImagens(imagens);

        return projeto;
    }

}
