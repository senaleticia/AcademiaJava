package br.senai.sp.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.senai.sp.dao.AlunoDAO;
import br.senai.sp.model.Calculo;
import br.senai.sp.utils.Data;
import br.senai.sp.model.Aluno;

public class FrmAluno extends JDialog {

	public JTextField txtNome;
	public JTextField txtIdade;
	public JTextField txtDataNascimento;
	public JTextField txtEndereco;
	public JTextField txtEmail;
	public JTextField txtTelefone;
	public JTextField txtPeso;
	public JTextField txtAltura;
	
	public JButton btGravar;
	
	public ButtonGroup buttonGroup1;
	public JRadioButton btMasc;
	public JRadioButton btFem;
	
	public JLabel lblMatricula;
	public JLabel lblResultadoIMC; 
	public JLabel lblResultadoTMB;
	public JLabel lblResultadoFCM;
	
	private Color rosa = new Color(237, 144, 169);
	private Color rosinha = new Color(255,100,255);
	private Color pink = new Color(229, 117, 165);
	private Color vermelho = new Color(237, 101, 101);
	private Color branco = new Color(255, 255, 255);
	
	public FrmAluno() {
		setTitle("Cadastro de Alunos");
		setSize(680,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		//Declara��o dos componentes
		JLabel lblNome = new JLabel("Nome: ");
		JLabel lblDataNascimento = new JLabel("Data Nasc.: ");
		JLabel lblIdade = new JLabel("Idade: ");
		JLabel lblSexo = new JLabel("Sexo: ");
		JLabel lblEndereco = new JLabel("Endere�o: ");
		JLabel lblEmail = new JLabel("E-mail: ");
		JLabel lblTelefone = new JLabel("Telefone: ");
		JLabel lblPeso = new JLabel("Peso: ");
		JLabel lblAltura = new JLabel("Altura: ");
		JLabel lblTMB = new JLabel("TMB: ");
		JLabel lblIMC = new JLabel("IMC: ");
		JLabel lblFCM = new JLabel("FCM: ");
		lblMatricula = new JLabel("");
		lblResultadoIMC = new JLabel("");
		lblResultadoTMB = new JLabel("");
		lblResultadoFCM = new JLabel("");
		
		btGravar = new JButton("Gravar");
		
		String operacoes[] = { 
				"IMC", 
				"tmbMasculino",
				"tmbFeminino",
				"fcmMasculino",
				"fcmFeminino",
				};
		
		txtNome = new JTextField();
		txtIdade = new JTextField();
		txtAltura = new JTextField();
		txtDataNascimento = new JTextField();
		txtEmail = new JTextField();
		txtEndereco = new JTextField();
		txtPeso = new JTextField();
		txtTelefone = new JTextField();
		
		buttonGroup1 = new ButtonGroup();
		btMasc = new JRadioButton("M");
		btFem = new JRadioButton("F");
		
		buttonGroup1.add(btMasc);
		buttonGroup1.add(btFem);
		
		JPanel painelDadosPessoais = new JPanel();
		TitledBorder borda1 = new TitledBorder("Dados Pessoais");
		painelDadosPessoais.setBorder(borda1);
		//Colocar o Painel Dentro do Painel de Conte�do da Tela 
		painelDadosPessoais.setBounds(10, 15, 650, 140);
		painelDadosPessoais.setBackground(rosa);
		painelDadosPessoais.setLayout(null);
		getContentPane().add(painelDadosPessoais);
		
		JPanel painelComunicacao = new JPanel();
		TitledBorder borda2 = new TitledBorder("Comunica��o");
		painelComunicacao.setBorder(borda2);
		painelComunicacao.setBounds(10, 160, 650, 140);
		painelComunicacao.setBackground(rosinha);
		painelComunicacao.setLayout(null);
		getContentPane().add(painelComunicacao);
		
		JPanel painelBio = new JPanel();
		TitledBorder borda3 = new TitledBorder("Bio");
		painelBio.setBorder(borda3);
		painelBio.setBounds(10, 305, 310, 170);
		painelBio.setBackground(pink);
		painelBio.setLayout(null);
		getContentPane().add(painelBio);
		
		JPanel painelResultados = new JPanel();
		TitledBorder borda4 = new TitledBorder("Resultados");
		painelResultados.setBorder(borda4);
		painelResultados.setBounds(330, 305, 325, 170);
		painelResultados.setBackground(vermelho);
		painelResultados.setLayout(null);
		getContentPane().add(painelResultados);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBounds(10, 450, 650, 170);
		painelBotoes.setBackground(branco);
		painelBotoes.setLayout(null);
		getContentPane().add(painelBotoes);
		
		
		//Colocar os componentes no Painel
		painelDadosPessoais.add(lblNome);
		painelDadosPessoais.add(lblIdade);
		painelDadosPessoais.add(lblDataNascimento);
		painelDadosPessoais.add(lblSexo);
		painelDadosPessoais.add(txtNome);
		painelDadosPessoais.add(txtIdade);
		painelDadosPessoais.add(txtDataNascimento);
		painelDadosPessoais.add(btMasc);
		painelDadosPessoais.add(btFem);
		
		painelComunicacao.add(lblEndereco);
		painelComunicacao.add(lblEmail);
		painelComunicacao.add(lblTelefone);
		painelComunicacao.add(txtEmail);
		painelComunicacao.add(txtTelefone);
		
		painelBio.add(lblPeso);
		painelBio.add(txtPeso);
		painelBio.add(lblAltura);
		painelBio.add(txtAltura);
		
		painelResultados.add(lblTMB);
		painelResultados.add(lblIMC);
		painelResultados.add(lblFCM);
		painelResultados.add(lblResultadoTMB);
		painelResultados.add(lblResultadoIMC);
		painelResultados.add(lblResultadoFCM);
		
		painelBotoes.add(btGravar);
		painelBotoes.add(lblMatricula);
		
		//Posicionar os componentes Dentro do Painel
		lblNome.setBounds(10, 20, 100, 20);
		txtNome.setBounds(10, 50, 160, 20);
		lblDataNascimento.setBounds(210, 20, 100, 20);
		txtDataNascimento.setBounds(210, 50, 70, 20);
		txtDataNascimento.setHorizontalAlignment(JTextField.CENTER);
		lblIdade.setBounds(360, 20, 50, 20);
		txtIdade.setBounds(360, 50, 50, 20);
		txtIdade.setEditable(false);
		txtIdade.setHorizontalAlignment(JTextField.CENTER);
		lblSexo.setBounds(470, 20, 100, 20);
		btMasc.setBounds(470, 50, 40, 20);
		btFem.setBounds(515, 50, 40, 20);
		
		lblEndereco.setBounds(10, 20, 160, 20);
		txtEndereco.setBounds(5, 50, 300, 70);
		lblEmail.setBounds(360, 20, 150, 20);
		txtEmail.setBounds(360, 50, 150, 20);
		lblTelefone.setBounds(360, 80, 150, 20);
		txtTelefone.setBounds(360, 100, 150, 20);
		
		JScrollPane scrollEndereco = new JScrollPane();
		scrollEndereco.setBounds(5, 50, 300, 70);
		scrollEndereco.setViewportView(txtEndereco);
		
		painelComunicacao.add(scrollEndereco);
		lblPeso.setBounds(10, 25, 100, 20);
		txtPeso.setBounds(10, 50, 100, 20);
		txtPeso.setHorizontalAlignment(JTextField.RIGHT);
		lblAltura.setBounds(10, 85, 100, 20);
		txtAltura.setBounds(10, 110, 50, 20);
		txtAltura.setHorizontalAlignment(JTextField.RIGHT);
		
		lblTMB.setBounds(10, 20, 100, 20);
		lblIMC.setBounds(10, 50, 100, 20);
		lblFCM.setBounds(10, 80, 100, 20);
		lblResultadoTMB.setBounds(50, 20, 200, 20);
		lblResultadoIMC.setBounds(50, 50, 200, 20);
		lblResultadoFCM.setBounds(50, 80, 200, 20);
		
		btGravar.setBounds(480, 70, 100, 20);
		lblMatricula.setBounds(50, 70, 100, 20);
		
		//Capturar a��es do usu�rio
		btGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (btGravar.getText().equals("Salvar Aluno")) {
					gravar();
				} else if (btGravar.getText().equals("EXCLUIR")) {
					excluir();
				} else if (btGravar.getText().equals("EDITAR")) {
					editar();
				}
				
			}
		});
		
		txtDataNascimento.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				txtIdade.setText(String.valueOf(Data.calcularIdade(txtDataNascimento.getText())));				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				
			}
		});
		
		setModal(true);
	}
	
	public void calcular (Aluno aluno) {
		Calculo calcular = new Calculo(aluno);
		
		lblResultadoIMC.setText(String.format("%.2f", calcular.calcularIMC()) + "-" + calcular.pesoIdeal);
		lblResultadoTMB.setText(String.format("%.0f", calcular.calcularTMB()));
		lblResultadoFCM.setText(String.valueOf(calcular.calcularFCM()));
	}
	
	public void editar() {
		Aluno aluno = criarAluno();
		
		calcular(aluno);
		
		AlunoDAO dao = new AlunoDAO(aluno);
		dao.atualizar();
		
		JOptionPane.showMessageDialog(null, "Aluno Atualizado Com Sucesso!", "Atualiza��o de Alunos", JOptionPane.INFORMATION_MESSAGE);
		btGravar.setEnabled(false);
	}
	
	public void gravar() {
		Aluno aluno = criarAluno();
		
		calcular(aluno);
		
		AlunoDAO dao = new AlunoDAO(aluno);
		dao.gravar();
		
		JOptionPane.showMessageDialog(null, "Aluno Cadastrado Com Sucesso", "Cadastro de Alunos", JOptionPane.INFORMATION_MESSAGE);
		btGravar.setEnabled(false);
	}
	
	public void excluir() {
		
		int resposta = JOptionPane.showConfirmDialog(null, "Confirma a Exclus�o do Aluno?", "Exclus�o de Aluno", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		AlunoDAO dao = new AlunoDAO();
		dao.excluir(Integer.parseInt(lblMatricula.getText()));
		this.dispose();
	}
	
	public Aluno criarAluno() {
		Aluno aluno = new Aluno();
		
		aluno.setMatricula(Integer.parseInt(lblMatricula.getText()));
		aluno.setPeso(Double.parseDouble(txtPeso.getText()));
		aluno.setAltura(Double.parseDouble(txtAltura.getText()));
		aluno.setNome(txtNome.getText());
		aluno.setSexo('M');
		
		if (btMasc.isSelected()) {
			aluno.setSexo('M');
		}else {
			aluno.setSexo('F');
		}
		
		aluno.setTelefone(txtTelefone.getText());
		aluno.setEmail(txtEmail.getText());
		aluno.setEndereco(txtEndereco.getText());
		
		aluno.setDataDeNascimento(Data.converterDataParaBanco(txtDataNascimento.getText()));
		
		return aluno;
	}
}
