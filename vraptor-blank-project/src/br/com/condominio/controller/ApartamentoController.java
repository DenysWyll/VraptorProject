package br.com.condominio.controller;

import java.util.List;


import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.condominio.Model.Apartamento;
import br.com.condominio.hibernate.HibernateUtil;

@Resource
public class ApartamentoController {

	private Result result;
	private Validator validator;

	public ApartamentoController(Result result, Validator validator) {

		this.result = result;
		this.validator = validator;
	}

	public void acessar(List<Apartamento> apartamentos) {
		if(apartamentos == null){
			apartamentos = HibernateUtil.buscar(new Apartamento());
		}
		result.include("apartamentos", apartamentos);
	}
	
	public void pesquisar(int pesquisa){
		Apartamento apartFiltro = new Apartamento();
		apartFiltro.setNumero(pesquisa);
		List<Apartamento> apartamentos = HibernateUtil.buscar(apartFiltro);
		result.redirectTo(this).acessar(apartamentos);
	}

	public void salvar(Apartamento apartamento) {
		//pesquisar para arrumar o validator
		if(apartamento.getNumero() == 0){
			validator.add(new ValidationMessage("O número deve ser preenchido ou diferente de zero!", "error"));
			validator.onErrorRedirectTo(this).acessar(null);
		}
		HibernateUtil.salvar(apartamento);
		result.redirectTo(this).acessar(null);
	}
	
}
