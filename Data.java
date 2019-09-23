package br.senai.sp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

	public static String converterDataParaBanco(String dataUsuario) {
		
		/*Criar variáveis para formar a nova data
		Exemplo: 31/07/2001 -> 2001-07-31*/
		String dia = dataUsuario.substring(0, 2);
		String mes = dataUsuario.substring(3, 5);
		String ano = dataUsuario.substring(6, 10);
		
		//Definir a data do banco no formato YYYY-MM-DD (2001-07-31)
		String dataBanco = ano + "-" + mes + "-" + "-" + dia;
		
		return dataBanco;
	}
	
	public static String coverterDataParaPtBr(String dataBanco) {
	
		String dataUsuario;
		String dia = dataBanco.substring(8, 10);
		String mes = dataBanco.substring(5, 7);
		String ano = dataBanco.substring(0, 4);
		
		dataUsuario = dia + "/" + mes + "/"  + ano;
		
		return dataUsuario;
	}
	
	public static int calcularIdade(String dataNascimento) {
		
		//Obter a data de hoje
		Date hoje = new Date();
		
		//Criar um formatador de datas
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		//Transformar a data de nascimento em uma data(Date)
		Date dataNascimentoDate = null;
		try {
			dataNascimentoDate = df.parse(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Obter a diferença entre a data de hoje e a data de nascimento em milissegundos
		long milissegundos = hoje.getTime() - dataNascimentoDate.getTime();
		
		/*Obter a quantidade de anos dos milissegundos com a seguinte operação:
		 milissegundos / 1000 / 60 / 60 / 24 / 365.25 */
		double idade = milissegundos / 1000 / 60 / 60 / 24 / 365.25;
		
		return (int) idade;
	}
}
