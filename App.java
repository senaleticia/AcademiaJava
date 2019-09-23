package br.senai.sp.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.senai.sp.dao.AlunoDAO;
import br.senai.sp.dao.Conexao;
import br.senai.sp.frame.FrmPrincipal;
import br.senai.sp.frame.FrmAluno;
import br.senai.sp.model.Calculo;
import br.senai.sp.model.Aluno;

public class App {

	public static void main(String[] args) {
		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
			
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");
		
		FrmPrincipal principal = new FrmPrincipal();
		
		//Obter data atual
		Date hoje = new Date();
		System.out.println(hoje);
		
		//Obter uma data qualquer no formato do idioma praticado
		String dataNascimentoStr = "31/07/2001";
		
		//Criar um formatador de datas
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		//Transformar a data de nascimento (String) em um objeto do tipo date 
		Date dataNascimentoDate = null;
		
		try {
			dataNascimentoDate = df.parse(dataNascimentoStr);
			System.out.println(dataNascimentoDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long mils = hoje.getTime() - dataNascimentoDate.getTime();
		
		double idade = mils / 1000 / 60 / 60 / 24 / 365.25;
		System.out.println(idade);
		
		String dataFormatoBR = df.format(hoje);
		System.out.println(dataFormatoBR);
	}
}
