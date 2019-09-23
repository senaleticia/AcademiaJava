package br.senai.sp.frame;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.dao.AlunoDAO;
import br.senai.sp.model.Aluno;
import br.senai.sp.utils.Data;
import jdk.jshell.execution.JdiDefaultExecutionControl;

public class FrmPrincipal extends JFrame {

	private final JScrollPane scroll = new JScrollPane();
	private final JTable tabelaAlunos = new JTable();
	private final JPanel painelTabela = new JPanel();
	private DefaultTableModel modelo;

	public FrmPrincipal() {
		setSize(600, 600);
		setTitle("Academia Active-se");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		// Painel da Tabela
		painelTabela.setBounds(10, 10, 560, 450);
		painelTabela.setLayout(null);
		TitledBorder bordaTabela = new TitledBorder("Lista de Alunos");
		painelTabela.setBorder(bordaTabela);

		// Painel dos Botões
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBounds(10, 470, 560, 80);
		painelBotoes.setLayout(null);
		TitledBorder bordaBotoes = new TitledBorder("");
		painelBotoes.setBorder(bordaBotoes);

		// Botões da Janela
		JButton btNovo = new JButton();
		ImageIcon iconNovo = new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/novo32.png"));
		btNovo.setIcon(iconNovo);

		JButton btExcluir = new JButton();
		ImageIcon iconDelete = new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/delete32.png"));
		btExcluir.setIcon(iconDelete);

		JButton btEditar = new JButton();
		ImageIcon iconEditar = new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/edit32.png"));
		btEditar.setIcon(iconEditar);

		JButton btSair = new JButton();
		ImageIcon iconSair = new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/sair32.png"));
		btSair.setIcon(iconSair);

		// Posicionar os Botões no painelBotoes
		btNovo.setBounds(10, 10, 60, 60);
		btExcluir.setBounds(80, 10, 60, 60);
		btEditar.setBounds(150, 10, 60, 60);
		btSair.setBounds(490, 10, 60, 60);

		// Conectar Com o Banco de Dados
		painelBotoes.add(btNovo);
		painelBotoes.add(btExcluir);
		painelBotoes.add(btEditar);
		painelBotoes.add(btSair);
		
		criarTabela();
		
		getContentPane().add(painelTabela);
		getContentPane().add(painelBotoes);

		// Ouvinte Para o Botão Novo Aluno
		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrmAluno frmAluno = new FrmAluno();
				frmAluno.btGravar.setText("Salvar Aluno");
				frmAluno.setVisible(true);
			}
		});

		btEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abrirFormularioAluno(tabelaAlunos, "EDITAR");
			}
		});

		btExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abrirFormularioAluno(tabelaAlunos, "EXCLUIR");

			}
		});

		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem Certeza que Deseja Sair?", "Sair do Sistema",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (resposta == 0) {
					System.exit(EXIT_ON_CLOSE);
				}
			}
		});
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
	
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
	
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {

			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {

			}
			
			@Override
			public void windowClosing(WindowEvent e) {

			}
			
			@Override
			public void windowClosed(WindowEvent e) {
					
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				criarTabela();
			}
		});

		setVisible(true);
	}

	private void abrirFormularioAluno(JTable tabelaAlunos, String textoDoBotao) {
		// Obter o Número da Matrícula do Aluno
		int linha = tabelaAlunos.getSelectedRow();
		int coluna = 0;

		int matricula = 0;

		if (linha == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um aluno na lista", "Aluno não selecionado",
					JOptionPane.ERROR_MESSAGE);
		} else {
			matricula = Integer.parseInt(tabelaAlunos.getValueAt(linha, coluna).toString());

			// Criar um Novo Aluno Com os Dados do Banco de Dados
			Aluno aluno = new Aluno();

			AlunoDAO dao = new AlunoDAO();
			aluno = dao.getAluno(matricula);

			// Abrir o Formulário Aluno Carregando os Dados nos Campos
			FrmAluno frmAluno = new FrmAluno();

			frmAluno.txtNome.setText(aluno.getNome());
			frmAluno.txtDataNascimento.setText(Data.coverterDataParaPtBr(aluno.getDataDeNascimento()));
			frmAluno.txtIdade.setText(
					String.valueOf(Data.calcularIdade(Data.coverterDataParaPtBr(aluno.getDataDeNascimento()))));
			frmAluno.txtEmail.setText(aluno.getEmail());
			frmAluno.txtEndereco.setText(aluno.getEndereco());
			frmAluno.txtAltura.setText(String.valueOf(aluno.getAltura()));
			frmAluno.txtPeso.setText(String.valueOf(aluno.getPeso()));

			frmAluno.btFem.setSelected(aluno.getSexo() == 'F' ? true : false);
			frmAluno.btMasc.setSelected(aluno.getSexo() == 'M' ? true : false);
			frmAluno.lblMatricula.setText(String.valueOf(aluno.getMatricula()));
			frmAluno.calcular(aluno);
			frmAluno.btGravar.setText(textoDoBotao);

			frmAluno.setVisible(true);
		}

	}

	private void criarTabela() {
		String[] cabecalho = { "MAT", "Nome", "E-mail", "Telefone" };

		AlunoDAO dao = new AlunoDAO();
		ArrayList<Aluno> alunos = dao.listarAlunos();

		int linhas = alunos.size();

		String[][] dados = new String[linhas][4];
		int linha = 0;

		for (Aluno aluno : alunos) {
			dados[linha][0] = String.valueOf(aluno.getMatricula());
			dados[linha][1] = aluno.getNome();
			dados[linha][2] = aluno.getEmail();
			dados[linha][3] = aluno.getTelefone();
			linha++;
		}

		modelo = new DefaultTableModel(dados, cabecalho);
		tabelaAlunos.setModel(modelo);

		// Impedir a Movimentação das Colunas
		tabelaAlunos.getTableHeader().setReorderingAllowed(false);

		// Impedir o Redimensionamento das Colunas
		tabelaAlunos.getTableHeader().setResizingAllowed(false);

		// Bloquear a Edição das Células
		tabelaAlunos.setDefaultEditor(Object.class, null);

		// Determinar a Largura das Colunas
		tabelaAlunos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaAlunos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabelaAlunos.getColumnModel().getColumn(1).setPreferredWidth(160);
		tabelaAlunos.getColumnModel().getColumn(2).setPreferredWidth(190);
		tabelaAlunos.getColumnModel().getColumn(3).setPreferredWidth(100);

		// Criando o Scroll
		scroll.setBounds(10, 20, 540, 420);
		scroll.setViewportView(tabelaAlunos);

		painelTabela.add(scroll);
	}

}
